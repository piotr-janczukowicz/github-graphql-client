package io.github.piotr_janczukowicz.github.graphql;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.client.GitHubCaller;
import io.github.piotr_janczukowicz.github.client.GitHubClient;
import io.github.piotr_janczukowicz.github.graphql.internal.PageWalk;
import io.github.piotr_janczukowicz.github.graphql.internal.Planned;
import io.github.piotr_janczukowicz.github.graphql.internal.SelectionPlanner;
import io.github.piotr_janczukowicz.github.graphql.model.MutationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySelector;
import io.github.piotr_janczukowicz.http.HttpResponse;
import io.github.piotr_janczukowicz.http.client.HttpCall;
import io.github.piotr_janczukowicz.pagination.PaginationConfiguration;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

/**
 * Sends typed GraphQL queries to GitHub. The request goes through the {@link GitHubClient} it was created from, so
 * transport, authentication, retry and rate-limit handling are the client's own.
 *
 * <p>Limits: github.com only. The request goes to {@code /graphql} below the client's base URI; GitHub Enterprise
 * Server, whose GraphQL endpoint is {@code /api/graphql}, is not supported yet. Queries are sent with POST, so the
 * client's mutation pacing applies to them.
 */
public final class GitHubGraphQL {

    private static final String PATH = "/graphql";
    private static final String SELECTION = "selection";
    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private final GitHubCaller caller;
    private final PaginationConfiguration pagination;

    private GitHubGraphQL(final GitHubCaller caller, final PaginationConfiguration pagination) {
        this.caller = caller;
        this.pagination = pagination;
    }

    /**
     * Creates a GraphQL client over a GitHub client. Its {@link GitHubClient#pagination() pagination settings} (page
     * size and page limit) apply to {@link #paginate(BiFunction)}.
     *
     * @param client the client that sends the requests; the caller keeps ownership and closes it
     * @return the GraphQL client
     */
    public static GitHubGraphQL of(final GitHubClient client) {
        requireNonNull(client, "client");
        return new GitHubGraphQL(GitHubCaller.of(client), client.pagination());
    }

    /**
     * Creates a GraphQL client over an existing caller, so that code that already holds a {@link GitHubCaller} can
     * share it. A caller does not expose its client's pagination settings, so {@link #paginate(BiFunction)} uses the
     * defaults (100 items per page, no page limit); to choose them, use {@link #of(GitHubCaller,
     * PaginationConfiguration)} or {@link #of(GitHubClient)}, or pass a {@link Paging} to set the page size per call.
     *
     * @param caller the caller that sends the requests; its client stays with whoever created it
     * @return the GraphQL client
     */
    public static GitHubGraphQL of(final GitHubCaller caller) {
        return of(caller, PaginationConfiguration.defaults());
    }

    /**
     * Creates a GraphQL client over an existing caller with the given pagination settings for
     * {@link #paginate(BiFunction)}: the page size, and the page limit.
     *
     * @param caller the caller that sends the requests; its client stays with whoever created it
     * @param pagination the page size and page limit that {@link #paginate(BiFunction)} uses
     * @return the GraphQL client
     */
    public static GitHubGraphQL of(final GitHubCaller caller, final PaginationConfiguration pagination) {
        return new GitHubGraphQL(requireNonNull(caller, "caller"), requireNonNull(pagination, "pagination"));
    }

    /**
     * Runs a query. The lambda runs twice: once to learn which fields it reads and once over the response, so it must
     * have no side effects and must not branch on a value it reads.
     *
     * @param selection reads the fields it needs from the selector and builds the result
     * @param <R> the result type
     * @return what the lambda builds from the response
     * @throws IOException when the request fails
     * @throws GitHubGraphQLException when the response has errors, even with partial data
     */
    public <R> R query(final Function<QuerySelector, R> selection) throws IOException {
        return send(SelectionPlanner.plan(requireNonNull(selection, SELECTION)));
    }

    /**
     * Runs a mutation. The lambda runs twice, like in {@link #query(Function)}: once to learn which fields it reads and
     * once over the response, so it must have no side effects and must not branch on a value it reads. The mutation
     * itself is sent once.
     *
     * <p>A mutation is a POST that the client does not repeat after a read error or a server error, because it could
     * have taken effect; only a failure to open the connection and a rate-limit response are retried. A response with
     * errors fails with {@link GitHubGraphQLException}, even when the mutation changed something and part of the data
     * came back.
     *
     * @param selection reads the fields it needs from the selector and builds the result
     * @param <R> the result type
     * @return what the lambda builds from the response
     * @throws IOException when the request fails
     * @throws GitHubGraphQLException when the response has errors, even with partial data
     */
    public <R> R mutate(final Function<MutationSelector, R> selection) throws IOException {
        return send(SelectionPlanner.planMutation(requireNonNull(selection, SELECTION)));
    }

    /**
     * Reads every page of one connection as a lazy stream of items, with the page size of the client's
     * {@link GitHubClient#pagination() pagination settings}.
     *
     * <p>The selection must return the page itself, as in {@code (query, paging) -> query.repository("o", "n", r ->
     * r.issues(paging, issue -> issue.title()))}; pass the given {@code paging} to the connection. The runtime sets the
     * cursor for every page. A page is fetched only when the stream needs its first item, so {@code limit(n)} stops
     * early. The whole query is sent again for each page and runs twice per page, like in {@link #query(Function)}, so
     * it must have no side effects. One query pages one connection; a connection inside a paged item is not followed.
     *
     * <p>Reading more pages than the client's {@code maxPages} fails with
     * {@link io.github.piotr_janczukowicz.github.pagination.GitHubPaginationLimitExceededException}; a repeating cursor
     * fails with {@link io.github.piotr_janczukowicz.github.pagination.GitHubPaginationLoopException}; a page that says
     * more follows but has no end cursor fails with {@link IllegalStateException}. These checks run when the next page
     * is requested, so they never hide the items already read. A failed request surfaces as
     * {@link UncheckedIOException}, and a response with errors as {@link GitHubGraphQLException}, both while the stream
     * is consumed. The stream is sequential, also after {@code parallel()}. Pages are POST requests, which the client
     * paces at least one second apart.
     *
     * @param selection builds the page from the selector and the paging to use
     * @param <R> the item type
     * @return the lazy stream of the items of all pages
     */
    public <R> Stream<R> paginate(final BiFunction<QuerySelector, Paging, Page<R>> selection) {
        return paginate(Paging.first(pagination.perPage()), selection);
    }

    /**
     * Reads every page of one connection as a lazy stream of items, starting with the given paging.
     *
     * <p>See {@link #paginate(BiFunction)} for how the selection, the limits and failures work.
     *
     * @param paging the page size, and the cursor to start after
     * @param selection builds the page from the selector and the paging to use
     * @param <R> the item type
     * @return the lazy stream of the items of all pages
     */
    public <R> Stream<R> paginate(final Paging paging, final BiFunction<QuerySelector, Paging, Page<R>> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(selection, SELECTION);
        return PageWalk.stream(
                paging, pagination.maxPages(), current -> query(query -> selection.apply(query, current)));
    }

    private <R> R send(final Planned<R> planned) throws IOException {
        final Map<String, Object> body = new LinkedHashMap<>();
        body.put("query", planned.document().text());
        body.put("variables", planned.document().variables());
        final HttpCall call = caller.json(HttpCall.post(PATH), body);

        final HttpResponse response = caller.send(call);

        final JsonNode root = MAPPER.readTree(response.requireBodyBytes());
        final JsonNode errors = root.get("errors");
        if (errors != null && !errors.isEmpty()) {
            throw new GitHubGraphQLException(readErrors(errors));
        }
        final JsonNode data = root.get("data");
        if (data == null || data.isNull()) {
            throw new IllegalStateException("the response has no data and no errors");
        }
        return planned.map(data);
    }

    private static List<GraphQLError> readErrors(final JsonNode errors) {
        return errors.valueStream().map(GitHubGraphQL::readError).toList();
    }

    private static GraphQLError readError(final JsonNode error) {
        final List<String> path = new ArrayList<>();
        for (final JsonNode step : error.path("path")) {
            path.add(step.asString());
        }
        return new GraphQLError(error.path("message").asString("GraphQL error"), path);
    }
}
