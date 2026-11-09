package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MoveProjectCardPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardEdgeSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code MoveProjectCardPayload}; used by the generated selection code only. */
final class MoveProjectCardPayloadSelectorImpl implements MoveProjectCardPayloadSelector {

    private final Cursor cursor;

    MoveProjectCardPayloadSelectorImpl(final Cursor cursor) {
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
}
