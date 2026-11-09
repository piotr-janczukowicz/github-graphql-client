package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldPullRequestValuePullRequestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldPullRequestValuePullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldPullRequestValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code ProjectV2ItemFieldPullRequestValue}; used by the generated selection code
 * only.
 */
final class ProjectV2ItemFieldPullRequestValueSelectorImpl implements ProjectV2ItemFieldPullRequestValueSelector {

    private final Cursor cursor;

    ProjectV2ItemFieldPullRequestValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> R field(final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return cursor.objectRequired(
                "field", child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> pullRequests(
            final Paging paging,
            final ProjectV2ItemFieldPullRequestValuePullRequestsFilter arguments,
            final Function<PullRequestSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "pullRequests",
                child -> selection.apply(new PullRequestSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "PullRequestOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> pullRequests(final Paging paging, final Function<PullRequestSelector, R> selection) {
        return pullRequests(
                paging,
                ProjectV2ItemFieldPullRequestValuePullRequestsFilterBuilder.builder()
                        .build(),
                selection);
    }
}
