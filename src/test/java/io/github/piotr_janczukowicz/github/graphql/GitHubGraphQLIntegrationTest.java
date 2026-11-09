package io.github.piotr_janczukowicz.github.graphql;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpStatus.OK;
import static io.github.piotr_janczukowicz.test.http.StubHttpServer.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.client.GitHubCaller;
import io.github.piotr_janczukowicz.github.client.GitHubClient;
import io.github.piotr_janczukowicz.github.client.GitHubClients;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFiltersBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.http.client.HttpClientConfiguration;
import io.github.piotr_janczukowicz.http.client.authentication.AuthenticationProviders;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitHubGraphQLIntegrationTest {

    private static final String PATH = "/graphql";

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    record Info(String name, int stars, String owner) {}

    private static GitHubClient client() {
        final HttpClientConfiguration configuration = HttpClientConfiguration.builder(URI.create(HTTP.baseUri() + "/"))
                .build();
        return GitHubClients.create(AuthenticationProviders.bearer("gh-token"), "test-agent/1.0", configuration);
    }

    private static StubHttpServer.StubResponse jsonOk(final String json) {
        return status(OK).header("Content-Type", "application/json").body(json.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void query_shouldPostTheDocumentAndReturnTheMappedResult_whenTheResponseHasData() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"repository":{"name":"Hello-World","stargazerCount":42,"owner":{"login":"octocat"}}}}
                """));

        final Info info;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            info = graphql.query(query -> query.repository(
                    "Hello-World",
                    "octocat",
                    repository -> new Info(
                            repository.name(),
                            repository.stargazerCount(),
                            repository.owner(RepositoryOwnerSelector::login))));
        }

        assertSoftly(softly -> {
            softly.assertThat(info).isEqualTo(new Info("Hello-World", 42, "octocat"));
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!)"
                            + "{repository(name:$name,owner:$owner){name stargazerCount owner{login}}}\","
                            + "\"variables\":{\"name\":\"Hello-World\",\"owner\":\"octocat\"}}");
        });
    }

    @Test
    void query_shouldUseTheGivenCaller_whenTheCallerIsPassedToOf() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("{\"data\":{\"repository\":{\"name\":\"Hello-World\"}}}"));

        final String name;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(GitHubCaller.of(client));

            name = graphql.query(query -> query.repository("Hello-World", "octocat", RepositorySelector::name));
        }

        assertThat(name).isEqualTo("Hello-World");
    }

    @Test
    void query_shouldSkipNullItemsAndSendTheDocument_whenAPageIsSelected() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"repository":{"issues":{"nodes":[{"title":"Bug A"},null,{"title":"Bug B"}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}}
                """));

        final Page<String> page;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            page = graphql.query(query -> query.repository(
                    "n", "o", repository -> repository.issues(Paging.first(10), IssueSelector::title)));
        }

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly("Bug A", "Bug B");
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!,$first:Int!)"
                            + "{repository(name:$name,owner:$owner){issues(first:$first)"
                            + "{nodes{title} pageInfo{hasNextPage endCursor}}}}\","
                            + "\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":10}}");
        });
    }

    record IssueView(IssueState state, Instant createdAt, String url) {}

    @Test
    void query_shouldReadAnEnumAndATypedDate_whenTheIssuesAreSelected() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"repository":{"issues":{"nodes":[
                 {"state":"OPEN","createdAt":"2024-05-01T10:15:30Z","url":"https://github.com/o/n/issues/1"},
                 {"state":"DRAFT","createdAt":"2024-05-02T08:00:00Z","url":"https://github.com/o/n/issues/2"}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}}
                """));

        final Page<IssueView> page;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            page = graphql.query(query -> query.repository(
                    "n",
                    "o",
                    repository -> repository.issues(
                            Paging.first(10), issue -> new IssueView(issue.state(), issue.createdAt(), issue.url()))));
        }

        assertThat(page.items())
                .containsExactly(
                        new IssueView(
                                IssueState.OPEN,
                                Instant.parse("2024-05-01T10:15:30Z"),
                                "https://github.com/o/n/issues/1"),
                        new IssueView(
                                IssueState.UNRECOGNIZED,
                                Instant.parse("2024-05-02T08:00:00Z"),
                                "https://github.com/o/n/issues/2"));
    }

    @Test
    void query_shouldSendTheFilterAsVariables_whenListArgumentsAreGiven() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"repository":{"issues":{"nodes":[{"title":"Bug A"}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}}
                """));

        final Page<String> page;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            page = graphql.query(query -> query.repository(
                    "n",
                    "o",
                    repository -> repository.issues(
                            Paging.first(10),
                            RepositoryIssuesFilterBuilder.builder()
                                    .labels(List.of("bug"))
                                    .states(List.of(IssueState.OPEN))
                                    .build(),
                            IssueSelector::title)));
        }

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly("Bug A");
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!,$first:Int!,"
                            + "$labels:[String!],$states:[IssueState!])"
                            + "{repository(name:$name,owner:$owner){issues(first:$first,labels:$labels,"
                            + "states:$states){nodes{title} pageInfo{hasNextPage endCursor}}}}\","
                            + "\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":10,"
                            + "\"labels\":[\"bug\"],\"states\":[\"OPEN\"]}}");
        });
    }

    @Test
    void query_shouldReturnAPageAndTheCursor_whenAConnectionIsSelected() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"repository":{"issues":{"nodes":[{"title":"Bug A"},{"title":"Bug B"}],
                 "pageInfo":{"hasNextPage":true,"endCursor":"c2"}}}}}
                """));

        final Page<String> page;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            page = graphql.query(query ->
                    query.repository("n", "o", repository -> repository.issues(Paging.first(2), IssueSelector::title)));
        }

        assertSoftly(softly -> {
            softly.assertThat(page).isEqualTo(new Page<>(List.of("Bug A", "Bug B"), true, "c2"));
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!,$first:Int!)"
                            + "{repository(name:$name,owner:$owner){issues(first:$first)"
                            + "{nodes{title} pageInfo{hasNextPage endCursor}}}}\","
                            + "\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":2}}");
        });
    }

    @Test
    void query_shouldReadTheSecondPage_whenThePagingCarriesTheEndCursor() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"repository":{"issues":{"nodes":[{"title":"Bug A"},{"title":"Bug B"}],
                 "pageInfo":{"hasNextPage":true,"endCursor":"c2"}}}}}
                """), jsonOk("""
                {"data":{"repository":{"issues":{"nodes":[{"title":"Bug C"}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}}
                """));

        final List<String> titles = new ArrayList<>();
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);
            Paging paging = Paging.first(2);
            boolean hasNext = true;
            while (hasNext) {
                final Paging current = paging;
                final Page<String> page = graphql.query(query ->
                        query.repository("n", "o", repository -> repository.issues(current, IssueSelector::title)));
                titles.addAll(page.items());
                hasNext = page.hasNext();
                if (hasNext) {
                    paging = paging.after(page.endCursor());
                }
            }
        }

        assertSoftly(softly -> {
            softly.assertThat(titles).containsExactly("Bug A", "Bug B", "Bug C");
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!,$first:Int!,$after:String)"
                            + "{repository(name:$name,owner:$owner){issues(first:$first,after:$after)"
                            + "{nodes{title} pageInfo{hasNextPage endCursor}}}}\","
                            + "\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":2,\"after\":\"c2\"}}");
        });
    }

    @Test
    void query_shouldThrowWithTheErrorList_whenTheResponseHasErrorsAndNoData() {
        HTTP.stub(POST, PATH, jsonOk("""
                {"errors":[{"message":"Could not resolve to a Repository","path":["repository"]}]}
                """));

        final Throwable thrown;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            thrown = catchThrowable(
                    () -> graphql.query(query -> query.repository("missing", "octocat", RepositorySelector::name)));
        }

        assertThat(thrown).isInstanceOfSatisfying(GitHubGraphQLException.class, exception -> {
            assertThat(exception).hasMessageContaining("Could not resolve to a Repository");
            assertThat(exception.errors())
                    .containsExactly(new GraphQLError("Could not resolve to a Repository", List.of("repository")));
        });
    }

    @Test
    void query_shouldKeepListIndexesInThePath_whenAnErrorPathHasANumber() {
        HTTP.stub(POST, PATH, jsonOk("""
                {"errors":[{"message":"bad item","path":["repository","issues",0]}]}
                """));

        final Throwable thrown;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            thrown = catchThrowable(
                    () -> graphql.query(query -> query.repository("Hello-World", "octocat", RepositorySelector::name)));
        }

        assertThat(thrown)
                .isInstanceOfSatisfying(
                        GitHubGraphQLException.class,
                        exception -> assertThat(exception.errors().getFirst().path())
                                .containsExactly("repository", "issues", "0"));
    }

    @Test
    void query_shouldReturnTheResult_whenTheErrorListIsEmpty() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"repository":{"name":"Hello-World"}},"errors":[]}
                """));

        final String name;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            name = graphql.query(query -> query.repository("Hello-World", "octocat", RepositorySelector::name));
        }

        assertThat(name).isEqualTo("Hello-World");
    }

    @Test
    void query_shouldFail_whenTheResponseHasNoDataAndNoErrors() {
        HTTP.stub(POST, PATH, jsonOk("{}"));

        final Throwable thrown;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            thrown = catchThrowable(
                    () -> graphql.query(query -> query.repository("Hello-World", "octocat", RepositorySelector::name)));
        }

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("no data");
    }

    @Test
    void query_shouldFail_whenTheDataIsNullAndThereAreNoErrors() {
        HTTP.stub(POST, PATH, jsonOk("{\"data\":null}"));

        final Throwable thrown;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            thrown = catchThrowable(
                    () -> graphql.query(query -> query.repository("Hello-World", "octocat", RepositorySelector::name)));
        }

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("no data");
    }

    @Test
    void query_shouldThrowByDefault_whenPartialDataComesWithErrors() {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"repository":{"name":"Hello-World"}},"errors":[{"message":"partial failure","path":["repository","name"]}]}
                """));

        final Throwable thrown;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            thrown = catchThrowable(
                    () -> graphql.query(query -> query.repository("Hello-World", "octocat", RepositorySelector::name)));
        }

        assertThat(thrown).isInstanceOf(GitHubGraphQLException.class).hasMessageContaining("partial failure");
    }

    @Test
    void query_shouldSendTheInputObjectsAsVariables_whenFilterByAndOrderByAreGiven() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"repository":{"issues":{"nodes":[{"title":"Bug A"}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}}
                """));

        final Page<String> page;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            page = graphql.query(query -> query.repository(
                    "n",
                    "o",
                    repository -> repository.issues(
                            Paging.first(10),
                            RepositoryIssuesFilterBuilder.builder()
                                    .filterBy(IssueFiltersBuilder.builder()
                                            .assignee("octocat")
                                            .since(Instant.parse("2024-05-01T00:00:00Z"))
                                            .states(List.of(IssueState.OPEN))
                                            .build())
                                    .orderBy(IssueOrderBuilder.builder()
                                            .direction(OrderDirection.DESC)
                                            .field(IssueOrderField.CREATED_AT)
                                            .build())
                                    .build(),
                            IssueSelector::title)));
        }

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly("Bug A");
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!,$first:Int!,"
                            + "$filterBy:IssueFilters,$orderBy:IssueOrder)"
                            + "{repository(name:$name,owner:$owner){issues(first:$first,filterBy:$filterBy,"
                            + "orderBy:$orderBy){nodes{title} pageInfo{hasNextPage endCursor}}}}\","
                            + "\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":10,"
                            + "\"filterBy\":{\"assignee\":\"octocat\",\"since\":\"2024-05-01T00:00:00Z\","
                            + "\"states\":[\"OPEN\"]},"
                            + "\"orderBy\":{\"direction\":\"DESC\",\"field\":\"CREATED_AT\"}}}");
        });
    }
}
