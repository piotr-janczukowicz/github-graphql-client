package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectColumnPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateProjectColumnPayload}; used by the generated selection code only. */
final class UpdateProjectColumnPayloadSelectorImpl implements UpdateProjectColumnPayloadSelector {

    private final Cursor cursor;

    UpdateProjectColumnPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectColumn(final Function<ProjectColumnSelector, R> selection) {
        return cursor.object("projectColumn", child -> selection.apply(new ProjectColumnSelectorImpl(child)));
    }
}
