package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.GrantMigratorRolePayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code GrantMigratorRolePayload}; used by the generated selection code only. */
final class GrantMigratorRolePayloadSelectorImpl implements GrantMigratorRolePayloadSelector {

    private final Cursor cursor;

    GrantMigratorRolePayloadSelectorImpl(final Cursor cursor) {
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
