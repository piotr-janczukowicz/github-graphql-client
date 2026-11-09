package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldReviewerValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequestedReviewerSelector;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code ProjectV2ItemFieldReviewerValue}; used by the generated selection code only.
 */
final class ProjectV2ItemFieldReviewerValueSelectorImpl implements ProjectV2ItemFieldReviewerValueSelector {

    private final Cursor cursor;

    ProjectV2ItemFieldReviewerValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> R field(final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return cursor.objectRequired(
                "field", child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> reviewers(final Paging paging, final Function<RequestedReviewerSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "reviewers",
                child -> selection.apply(new RequestedReviewerSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }
}
