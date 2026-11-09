package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldLabelValueSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code ProjectV2ItemFieldLabelValue}; used by the generated selection code only. */
final class ProjectV2ItemFieldLabelValueSelectorImpl implements ProjectV2ItemFieldLabelValueSelector {

    private final Cursor cursor;

    ProjectV2ItemFieldLabelValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> R field(final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return cursor.objectRequired(
                "field", child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> labels(final Paging paging, final Function<LabelSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "labels",
                child -> selection.apply(new LabelSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }
}
