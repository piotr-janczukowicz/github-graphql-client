package io.github.piotr_janczukowicz.github.graphql.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.client.GitHubClient;
import io.github.piotr_janczukowicz.github.client.GitHubClients;
import io.github.piotr_janczukowicz.github.graphql.GitHubGraphQL;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.http.client.authentication.AuthenticationProviders;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class GitHubGraphQLSmokeIT {

    private static final String TOKEN = System.getenv().getOrDefault("SMOKE_GITHUB_TOKEN", "");
    private static final String FULL_NAME =
            System.getenv().getOrDefault("SMOKE_GITHUB_REPO", "piotr-janczukowicz/github-api-smoke");

    private static GitHubClient client;
    private static GitHubGraphQL graphql;
    private static String owner;
    private static String repo;

    record Info(String name, int stars, String ownerLogin) {}

    @BeforeAll
    static void connect() {
        Assumptions.assumeTrue(!TOKEN.isBlank(), "SMOKE_GITHUB_TOKEN is not set");
        final String[] parts = FULL_NAME.split("/", -1);
        if (parts.length != 2 || !parts[1].toLowerCase(Locale.ROOT).contains("smoke")) {
            throw new IllegalStateException(
                    "SMOKE_GITHUB_REPO must be owner/name of a sandbox whose name contains smoke");
        }
        owner = parts[0];
        repo = parts[1];
        client = GitHubClients.create(AuthenticationProviders.bearer(TOKEN), "github-graphql-smoke/1.0");
        graphql = GitHubGraphQL.of(client);
    }

    @AfterAll
    static void disconnect() {
        if (client != null) {
            client.close();
        }
    }

    @Test
    void query_shouldReadTheSandboxRepository_whenTheTokenIsValid() throws IOException {
        final Info info = graphql.query(query -> query.repository(
                repo,
                owner,
                repository -> new Info(
                        repository.name(),
                        repository.stargazerCount(),
                        repository.owner(RepositoryOwnerSelector::login))));

        assertSoftly(softly -> {
            softly.assertThat(info.name()).isEqualToIgnoringCase(repo);
            softly.assertThat(info.ownerLogin()).isEqualToIgnoringCase(owner);
            softly.assertThat(info.stars()).isNotNegative();
        });
    }

    @Test
    void paginate_shouldReadFilteredIssues_whenTheFilterNamesTheState() {
        final List<String> titles = graphql.paginate(
                        Paging.first(2),
                        (query, paging) -> query.repository(
                                repo,
                                owner,
                                repository -> repository.issues(
                                        paging,
                                        RepositoryIssuesFilterBuilder.builder()
                                                .states(List.of(IssueState.OPEN, IssueState.CLOSED))
                                                .build(),
                                        IssueSelector::title)))
                .limit(5)
                .toList();

        assertThat(titles).hasSizeLessThanOrEqualTo(5).doesNotContainNull();
    }

    @Test
    void query_shouldReadTheAuthorThroughTheInterfaceAndABranch_whenTheIssueHasAnAuthor() {
        final List<String> authors = graphql.paginate(
                        Paging.first(1),
                        (query, paging) -> query.repository(
                                repo,
                                owner,
                                repository -> repository.issues(
                                        paging,
                                        issue -> issue.author(actor -> {
                                            final String name = actor.on(UserSelector.class, UserSelector::name);
                                            return actor.login() + "/" + (name == null ? "" : name);
                                        }))))
                .limit(1)
                .toList();

        assertThat(authors).hasSize(1).allSatisfy(author -> assertThat(author).contains("/"));
    }

    @Test
    void query_shouldReadAUnionThroughOn_whenTheNumberIsAnIssueOrAPullRequest() throws IOException {
        final String kind = graphql.query(query -> query.repository(
                repo,
                owner,
                repository -> repository.issueOrPullRequest(1, item -> {
                    final String issue = item.on(IssueSelector.class, IssueSelector::title);
                    final String pull = item.on(PullRequestSelector.class, PullRequestSelector::title);
                    return issue != null ? "issue" : pull != null ? "pull" : "other";
                })));

        assertThat(kind).isIn("issue", "pull");
    }
}
