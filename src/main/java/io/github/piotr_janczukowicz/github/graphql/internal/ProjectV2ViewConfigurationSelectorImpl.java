package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewConfigurationSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code ProjectV2ViewConfiguration}; used by the generated selection code only. */
final class ProjectV2ViewConfigurationSelectorImpl implements ProjectV2ViewConfigurationSelector {

    private final Cursor cursor;

    ProjectV2ViewConfigurationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> visibleFields(
            final Paging paging, final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "visibleFields",
                child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }
}
