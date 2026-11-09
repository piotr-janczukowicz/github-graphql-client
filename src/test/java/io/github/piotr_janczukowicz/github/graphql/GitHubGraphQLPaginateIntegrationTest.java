package io.github.piotr_janczukowicz.github.graphql;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpStatus.OK;
import static io.github.piotr_janczukowicz.test.http.StubHttpServer.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.client.GitHubCaller;
import io.github.piotr_janczukowicz.github.client.GitHubClient;
import io.github.piotr_janczukowicz.github.client.GitHubClientConfiguration;
import io.github.piotr_janczukowicz.github.client.GitHubClients;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFiltersBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.pagination.GitHubPaginationLimitExceededException;
import io.github.piotr_janczukowicz.http.client.HttpClientConfiguration;
import io.github.piotr_janczukowicz.http.client.authentication.AuthenticationProviders;
import io.github.piotr_janczukowicz.pagination.PaginationConfiguration;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitHubGraphQLPaginateIntegrationTest {

    private static final String PATH = "/graphql";
    private static final BiFunction<QuerySelector, Paging, Page<String>> TITLES = (query, paging) ->
            query.repository("n", "o", repository -> repository.issues(paging, IssueSelector::title));

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    private static GitHubClient client(final PaginationConfiguration pagination) {
        final HttpClientConfiguration http = HttpClientConfiguration.builder(URI.create(HTTP.baseUri() + "/"))
                .build();
        final GitHubClientConfiguration configuration = GitHubClientConfiguration.builder()
                .configuration(http)
                .pagination(pagination)
                .build();
        return GitHubClients.create(AuthenticationProviders.bearer("gh-token"), "test-agent/1.0", configuration);
    }

    private static StubHttpServer.StubResponse jsonOk(final String json) {
        return status(OK).header("Content-Type", "application/json").body(json.getBytes(StandardCharsets.UTF_8));
    }

    private static String page(final String titles, final boolean hasNext, final String cursor) {
        return "{\"data\":{\"repository\":{\"issues\":{\"nodes\":[" + titles + "],\"pageInfo\":{\"hasNextPage\":"
                + hasNext + ",\"endCursor\":" + cursor + "}}}}}";
    }

    @Test
    void paginate_shouldReadAllPages_whenThePagingIsGiven() {
        HTTP.stub(
                POST,
                PATH,
                jsonOk(page("{\"title\":\"a\"},{\"title\":\"b\"}", true, "\"c2\"")),
                jsonOk(page("{\"title\":\"c\"}", false, "null")));

        final List<String> titles;
        try (final GitHubClient client = client(PaginationConfiguration.defaults())) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            titles = graphql.paginate(Paging.first(2), TITLES).toList();
        }

        assertSoftly(softly -> {
            softly.assertThat(titles).containsExactly("a", "b", "c");
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
    void paginate_shouldUseThePageSizeOfTheClient_whenNoPagingIsGiven() {
        HTTP.stub(POST, PATH, jsonOk(page("{\"title\":\"a\"}", false, "null")));
        final PaginationConfiguration pagination =
                PaginationConfiguration.builder().perPage(7).build();

        final List<String> titles;
        try (final GitHubClient client = client(pagination)) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            titles = graphql.paginate(TITLES).toList();
        }

        assertSoftly(softly -> {
            softly.assertThat(titles).containsExactly("a");
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!,$first:Int!)"
                            + "{repository(name:$name,owner:$owner){issues(first:$first)"
                            + "{nodes{title} pageInfo{hasNextPage endCursor}}}}\","
                            + "\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":7}}");
        });
    }

    @Test
    void paginate_shouldCarryTheFilterToEveryPage_whenListArgumentsAreGiven() {
        HTTP.stub(
                POST,
                PATH,
                jsonOk(page("{\"title\":\"a\"}", true, "\"c1\"")),
                jsonOk(page("{\"title\":\"b\"}", false, "null")));
        final BiFunction<QuerySelector, Paging, Page<String>> filtered = (query, paging) -> query.repository(
                "n",
                "o",
                repository -> repository.issues(
                        paging,
                        RepositoryIssuesFilterBuilder.builder()
                                .labels(List.of("bug"))
                                .states(List.of(IssueState.OPEN))
                                .build(),
                        IssueSelector::title));

        final List<String> titles;
        try (final GitHubClient client = client(PaginationConfiguration.defaults())) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            titles = graphql.paginate(Paging.first(1), filtered).toList();
        }

        assertSoftly(softly -> {
            softly.assertThat(titles).containsExactly("a", "b");
            final String queryText = "query($name:String!,$owner:String!,$first:Int!,$after:String,"
                    + "$labels:[String!],$states:[IssueState!])"
                    + "{repository(name:$name,owner:$owner){issues(first:$first,after:$after,labels:$labels,"
                    + "states:$states){nodes{title} pageInfo{hasNextPage endCursor}}}}";
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\""
                            + queryText
                                    .replace("$first:Int!,$after:String,", "$first:Int!,")
                                    .replace("first:$first,after:$after,", "first:$first,")
                            + "\",\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":1,"
                            + "\"labels\":[\"bug\"],\"states\":[\"OPEN\"]}}");
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"" + queryText + "\",\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":1,"
                            + "\"after\":\"c1\",\"labels\":[\"bug\"],\"states\":[\"OPEN\"]}}");
        });
    }

    @Test
    void paginate_shouldCarryTheFilterObjectToEveryPage_whenFilterByIsGiven() {
        HTTP.stub(
                POST,
                PATH,
                jsonOk(page("{\"title\":\"a\"}", true, "\"c1\"")),
                jsonOk(page("{\"title\":\"b\"}", false, "null")));
        final BiFunction<QuerySelector, Paging, Page<String>> filtered = (query, paging) -> query.repository(
                "n",
                "o",
                repository -> repository.issues(
                        paging,
                        RepositoryIssuesFilterBuilder.builder()
                                .filterBy(IssueFiltersBuilder.builder()
                                        .assignee("octocat")
                                        .build())
                                .build(),
                        IssueSelector::title));

        final List<String> titles;
        try (final GitHubClient client = client(PaginationConfiguration.defaults())) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            titles = graphql.paginate(Paging.first(1), filtered).toList();
        }

        assertSoftly(softly -> {
            softly.assertThat(titles).containsExactly("a", "b");
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!,$first:Int!,$filterBy:IssueFilters)"
                            + "{repository(name:$name,owner:$owner){issues(first:$first,filterBy:$filterBy)"
                            + "{nodes{title} pageInfo{hasNextPage endCursor}}}}\","
                            + "\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":1,"
                            + "\"filterBy\":{\"assignee\":\"octocat\"}}}");
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!,$first:Int!,$after:String,"
                            + "$filterBy:IssueFilters)"
                            + "{repository(name:$name,owner:$owner){issues(first:$first,after:$after,"
                            + "filterBy:$filterBy){nodes{title} pageInfo{hasNextPage endCursor}}}}\","
                            + "\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":1,"
                            + "\"after\":\"c1\",\"filterBy\":{\"assignee\":\"octocat\"}}}");
        });
    }

    @Test
    void paginate_shouldStopFetching_whenOnlyTheFirstItemIsConsumed() {
        HTTP.stub(
                POST,
                PATH,
                jsonOk(page("{\"title\":\"a\"},{\"title\":\"b\"}", true, "\"c2\"")),
                jsonOk(page("{\"title\":\"c\"}", false, "null")));

        final List<String> titles;
        try (final GitHubClient client = client(PaginationConfiguration.defaults())) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            titles = graphql.paginate(Paging.first(2), TITLES).limit(1).toList();
        }

        assertSoftly(softly -> {
            softly.assertThat(titles).containsExactly("a");
            HTTP.verifyRequested(POST, PATH, 1);
        });
    }

    @Test
    void paginate_shouldFail_whenMaxPagesOfTheClientIsReachedAndMoreIsAvailable() {
        HTTP.stub(POST, PATH, jsonOk(page("{\"title\":\"a\"}", true, "\"c1\"")));
        final PaginationConfiguration pagination =
                PaginationConfiguration.builder().maxPages(1).build();

        final Throwable thrown;
        try (final GitHubClient client = client(pagination)) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            thrown = catchThrowable(
                    () -> graphql.paginate(Paging.first(1), TITLES).toList());
        }

        assertThat(thrown).isInstanceOf(GitHubPaginationLimitExceededException.class);
    }

    @Test
    void paginate_shouldUseThePageSizeOfTheGivenPagination_whenTheCallerIsPassedWithAPagination() {
        HTTP.stub(POST, PATH, jsonOk(page("{\"title\":\"a\"}", false, "null")));
        final PaginationConfiguration pagination =
                PaginationConfiguration.builder().perPage(5).build();

        final List<String> titles;
        try (final GitHubClient client = client(PaginationConfiguration.defaults())) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(GitHubCaller.of(client), pagination);

            titles = graphql.paginate(TITLES).toList();
        }

        assertSoftly(softly -> {
            softly.assertThat(titles).containsExactly("a");
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"query($name:String!,$owner:String!,$first:Int!)"
                            + "{repository(name:$name,owner:$owner){issues(first:$first)"
                            + "{nodes{title} pageInfo{hasNextPage endCursor}}}}\","
                            + "\"variables\":{\"name\":\"n\",\"owner\":\"o\",\"first\":5}}");
        });
    }

    @Test
    void paginate_shouldFail_whenMaxPagesOfTheGivenPaginationIsReached() {
        HTTP.stub(POST, PATH, jsonOk(page("{\"title\":\"a\"}", true, "\"c1\"")));
        final PaginationConfiguration pagination =
                PaginationConfiguration.builder().maxPages(1).build();

        final Throwable thrown;
        try (final GitHubClient client = client(PaginationConfiguration.defaults())) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(GitHubCaller.of(client), pagination);

            thrown = catchThrowable(
                    () -> graphql.paginate(Paging.first(1), TITLES).toList());
        }

        assertThat(thrown).isInstanceOf(GitHubPaginationLimitExceededException.class);
    }

    @Test
    void of_shouldFail_whenThePaginationIsNull() {
        final PaginationConfiguration pagination = null;

        final Throwable thrown;
        try (final GitHubClient client = client(PaginationConfiguration.defaults())) {
            final GitHubCaller caller = GitHubCaller.of(client);

            thrown = catchThrowable(() -> GitHubGraphQL.of(caller, pagination));
        }

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pagination must not be null");
    }

    @Test
    void paginate_shouldFail_whenThePagingIsNull() {
        final Paging paging = null;

        final Throwable thrown;
        try (final GitHubClient client = client(PaginationConfiguration.defaults())) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            thrown = catchThrowable(() -> graphql.paginate(paging, TITLES));
        }

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("paging must not be null");
    }

    @Test
    void paginate_shouldFail_whenTheSelectionIsNull() {
        final BiFunction<QuerySelector, Paging, Page<String>> selection = null;

        final Throwable thrown;
        try (final GitHubClient client = client(PaginationConfiguration.defaults())) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            thrown = catchThrowable(() -> graphql.paginate(selection));
        }

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("selection must not be null");
    }
}
