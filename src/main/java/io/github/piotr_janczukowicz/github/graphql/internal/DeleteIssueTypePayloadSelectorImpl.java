package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteIssueTypePayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteIssueTypePayload}; used by the generated selection code only. */
final class DeleteIssueTypePayloadSelectorImpl implements DeleteIssueTypePayloadSelector {

    private final Cursor cursor;

    DeleteIssueTypePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable String deletedIssueTypeId() {
        return cursor.get("deletedIssueTypeId", ScalarType.STRING);
    }
}
