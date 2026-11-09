package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteBranchProtectionRulePayloadSelector;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code DeleteBranchProtectionRulePayload}; used by the generated selection code only.
 */
final class DeleteBranchProtectionRulePayloadSelectorImpl implements DeleteBranchProtectionRulePayloadSelector {

    private final Cursor cursor;

    DeleteBranchProtectionRulePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
