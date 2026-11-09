package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteDeploymentPayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteDeploymentPayload}; used by the generated selection code only. */
final class DeleteDeploymentPayloadSelectorImpl implements DeleteDeploymentPayloadSelector {

    private final Cursor cursor;

    DeleteDeploymentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
