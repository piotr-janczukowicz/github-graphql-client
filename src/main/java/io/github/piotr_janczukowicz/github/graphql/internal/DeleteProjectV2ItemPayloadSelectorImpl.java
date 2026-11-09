package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteProjectV2ItemPayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteProjectV2ItemPayload}; used by the generated selection code only. */
final class DeleteProjectV2ItemPayloadSelectorImpl implements DeleteProjectV2ItemPayloadSelector {

    private final Cursor cursor;

    DeleteProjectV2ItemPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable String deletedItemId() {
        return cursor.get("deletedItemId", ScalarType.STRING);
    }
}
