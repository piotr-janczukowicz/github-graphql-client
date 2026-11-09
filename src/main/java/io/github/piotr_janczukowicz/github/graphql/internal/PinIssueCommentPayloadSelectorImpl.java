package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinIssueCommentPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PinIssueCommentPayload}; used by the generated selection code only. */
final class PinIssueCommentPayloadSelectorImpl implements PinIssueCommentPayloadSelector {

    private final Cursor cursor;

    PinIssueCommentPayloadSelectorImpl(final Cursor cursor) {
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
