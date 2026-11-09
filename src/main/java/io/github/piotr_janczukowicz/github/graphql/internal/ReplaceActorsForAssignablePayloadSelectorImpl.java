package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AssignableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReplaceActorsForAssignablePayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ReplaceActorsForAssignablePayload}; used by the generated selection code only.
 */
final class ReplaceActorsForAssignablePayloadSelectorImpl implements ReplaceActorsForAssignablePayloadSelector {

    private final Cursor cursor;

    ReplaceActorsForAssignablePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R assignable(final Function<AssignableSelector, R> selection) {
        return cursor.object("assignable", child -> selection.apply(new AssignableSelectorImpl(child)));
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
