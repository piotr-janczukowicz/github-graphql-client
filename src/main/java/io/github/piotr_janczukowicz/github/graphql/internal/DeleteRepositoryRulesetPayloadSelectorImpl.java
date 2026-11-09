package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteRepositoryRulesetPayloadSelector;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code DeleteRepositoryRulesetPayload}; used by the generated selection code only.
 */
final class DeleteRepositoryRulesetPayloadSelectorImpl implements DeleteRepositoryRulesetPayloadSelector {

    private final Cursor cursor;

    DeleteRepositoryRulesetPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
