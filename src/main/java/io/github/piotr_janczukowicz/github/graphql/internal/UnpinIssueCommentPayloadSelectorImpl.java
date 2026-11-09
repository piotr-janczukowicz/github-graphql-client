package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnpinIssueCommentPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UnpinIssueCommentPayload}; used by the generated selection code only. */
final class UnpinIssueCommentPayloadSelectorImpl implements UnpinIssueCommentPayloadSelector {

    private final Cursor cursor;

    UnpinIssueCommentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R issueComment(final Function<IssueCommentSelector, R> selection) {
        return cursor.object("issueComment", child -> selection.apply(new IssueCommentSelectorImpl(child)));
    }
}
