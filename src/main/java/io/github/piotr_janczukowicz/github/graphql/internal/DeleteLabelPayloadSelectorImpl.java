package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteLabelPayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteLabelPayload}; used by the generated selection code only. */
final class DeleteLabelPayloadSelectorImpl implements DeleteLabelPayloadSelector {

    private final Cursor cursor;

    DeleteLabelPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
