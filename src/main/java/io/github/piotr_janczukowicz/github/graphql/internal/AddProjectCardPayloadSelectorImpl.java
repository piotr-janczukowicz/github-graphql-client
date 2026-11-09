package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddProjectCardPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddProjectCardPayload}; used by the generated selection code only. */
final class AddProjectCardPayloadSelectorImpl implements AddProjectCardPayloadSelector {

    private final Cursor cursor;

    AddProjectCardPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R cardEdge(final Function<ProjectCardEdgeSelector, R> selection) {
        return cursor.object("cardEdge", child -> selection.apply(new ProjectCardEdgeSelectorImpl(child)));
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
