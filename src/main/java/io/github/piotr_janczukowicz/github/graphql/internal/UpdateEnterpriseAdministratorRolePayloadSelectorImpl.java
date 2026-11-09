package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UpdateEnterpriseAdministratorRolePayloadSelector;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateEnterpriseAdministratorRolePayload}; used by the generated selection
 * code only.
 */
final class UpdateEnterpriseAdministratorRolePayloadSelectorImpl
        implements UpdateEnterpriseAdministratorRolePayloadSelector {

    private final Cursor cursor;

    UpdateEnterpriseAdministratorRolePayloadSelectorImpl(final Cursor cursor) {
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
