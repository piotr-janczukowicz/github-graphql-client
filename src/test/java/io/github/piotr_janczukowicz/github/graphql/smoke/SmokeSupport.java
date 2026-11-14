package io.github.piotr_janczukowicz.github.graphql.smoke;

import io.github.piotr_janczukowicz.github.client.GitHubClient;
import io.github.piotr_janczukowicz.github.client.GitHubClients;
import io.github.piotr_janczukowicz.github.graphql.GitHubGraphQL;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.http.client.authentication.AuthenticationProviders;
import java.io.IOException;
import java.util.Locale;
import org.junit.jupiter.api.Assumptions;

final class SmokeSupport {

    private static final String TOKEN = System.getenv().getOrDefault("SMOKE_GITHUB_TOKEN", "");
    private static final String FULL_NAME =
            System.getenv().getOrDefault("SMOKE_GITHUB_REPO", "piotr-janczukowicz/github-api-smoke");
    private static final String RUN_ID = Long.toString(System.currentTimeMillis(), Character.MAX_RADIX);

    private final String owner;
    private final String repo;
    private final GitHubClient client;
    private final GitHubGraphQL graphql;

    private SmokeSupport(final String owner, final String repo) {
        this.owner = owner;
        this.repo = repo;
        this.client = GitHubClients.create(AuthenticationProviders.bearer(TOKEN), "github-graphql-smoke/1.0");
        this.graphql = GitHubGraphQL.of(client);
    }

    static SmokeSupport connect() {
        Assumptions.assumeTrue(!TOKEN.isBlank(), "SMOKE_GITHUB_TOKEN is not set");
        final String[] parts = FULL_NAME.split("/", -1);
        if (parts.length != 2 || !parts[1].toLowerCase(Locale.ROOT).contains("smoke")) {
            throw new IllegalStateException(
                    "SMOKE_GITHUB_REPO must be owner/name of a sandbox whose name contains smoke");
        }
        return new SmokeSupport(parts[0], parts[1]);
    }

    GitHubGraphQL graphql() {
        return graphql;
    }

    String owner() {
        return owner;
    }

    String repo() {
        return repo;
    }

    String name(final String suffix) {
        return "smoke-" + RUN_ID + "-" + suffix;
    }

    String repositoryId() throws IOException {
        return graphql.query(query -> query.repository(repo, owner, RepositorySelector::id));
    }

    void close() {
        client.close();
    }
}
