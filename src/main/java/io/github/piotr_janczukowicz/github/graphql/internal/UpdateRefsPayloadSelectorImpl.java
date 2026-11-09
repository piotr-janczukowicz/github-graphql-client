package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UpdateRefsPayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateRefsPayload}; used by the generated selection code only. */
final class UpdateRefsPayloadSelectorImpl implements UpdateRefsPayloadSelector {

    private final Cursor cursor;

    UpdateRefsPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
