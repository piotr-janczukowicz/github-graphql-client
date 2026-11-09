package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeletePackageVersionPayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeletePackageVersionPayload}; used by the generated selection code only. */
final class DeletePackageVersionPayloadSelectorImpl implements DeletePackageVersionPayloadSelector {

    private final Cursor cursor;

    DeletePackageVersionPayloadSelectorImpl(final Cursor cursor) {
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
