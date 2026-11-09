package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteIssueCommentPayloadSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteIssueCommentPayload}; used by the generated selection code only. */
final class DeleteIssueCommentPayloadSelectorImpl implements DeleteIssueCommentPayloadSelector {

    private final Cursor cursor;

    DeleteIssueCommentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
