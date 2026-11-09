package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteRefPayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteRefPayload}; used by the generated selection code only. */
final class DeleteRefPayloadSelectorImpl implements DeleteRefPayloadSelector {

    private final Cursor cursor;

    DeleteRefPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
