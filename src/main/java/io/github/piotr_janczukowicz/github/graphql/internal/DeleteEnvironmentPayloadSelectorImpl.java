package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteEnvironmentPayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteEnvironmentPayload}; used by the generated selection code only. */
final class DeleteEnvironmentPayloadSelectorImpl implements DeleteEnvironmentPayloadSelector {

    private final Cursor cursor;

    DeleteEnvironmentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
