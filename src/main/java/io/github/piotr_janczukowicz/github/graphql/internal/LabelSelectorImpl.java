package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelIssuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.LabelIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelPullRequestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.LabelPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Label}; used by the generated selection code only. */
final class LabelSelectorImpl implements LabelSelector {

    private static final String STRING = "String";

    private final Cursor cursor;

    LabelSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String color() {
        return cursor.getRequired("color", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant createdAt() {
        return cursor.get("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isDefault() {
        return cursor.getRequired("isDefault", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> issues(
            final Paging paging, final LabelIssuesFilter arguments, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "issues",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of(
                        "filterBy",
                        "IssueFilters",
                        arguments.filterBy() == null
                                ? null
                                : arguments.filterBy().toVariable()),
                Argument.of("labels", "[String!]", arguments.labels()),
                Argument.of(
                        "orderBy",
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("states", "[IssueState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> issues(final Paging paging, final Function<IssueSelector, R> selection) {
        return issues(paging, LabelIssuesFilterBuilder.builder().build(), selection);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> pullRequests(
            final Paging paging,
            final LabelPullRequestsFilter arguments,
            final Function<PullRequestSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "pullRequests",
                child -> selection.apply(new PullRequestSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of("baseRefName", STRING, arguments.baseRefName()),
                Argument.of("headRefName", STRING, arguments.headRefName()),
                Argument.of("labels", "[String!]", arguments.labels()),
                Argument.of(
                        "orderBy",
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("states", "[PullRequestState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> pullRequests(final Paging paging, final Function<PullRequestSelector, R> selection) {
        return pullRequests(paging, LabelPullRequestsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant updatedAt() {
        return cursor.get("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
