package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddEnterpriseSupportEntitlementPayloadSelector;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code AddEnterpriseSupportEntitlementPayload}; used by the generated selection code
 * only.
 */
final class AddEnterpriseSupportEntitlementPayloadSelectorImpl
        implements AddEnterpriseSupportEntitlementPayloadSelector {

    private final Cursor cursor;

    AddEnterpriseSupportEntitlementPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable String message() {
        return cursor.get("message", ScalarType.STRING);
    }
}
