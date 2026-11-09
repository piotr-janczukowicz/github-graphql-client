package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AbortQueuedMigrationsPayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AbortQueuedMigrationsPayload}; used by the generated selection code only. */
final class AbortQueuedMigrationsPayloadSelectorImpl implements AbortQueuedMigrationsPayloadSelector {

    private final Cursor cursor;

    AbortQueuedMigrationsPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable Boolean success() {
        return cursor.get("success", ScalarType.BOOLEAN);
    }
}
