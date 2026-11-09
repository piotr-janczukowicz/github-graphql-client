package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddPullRequestReviewThreadReplyPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code AddPullRequestReviewThreadReplyPayload}; used by the generated selection code
 * only.
 */
final class AddPullRequestReviewThreadReplyPayloadSelectorImpl
        implements AddPullRequestReviewThreadReplyPayloadSelector {

    private final Cursor cursor;

    AddPullRequestReviewThreadReplyPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R comment(final Function<PullRequestReviewCommentSelector, R> selection) {
        return cursor.object("comment", child -> selection.apply(new PullRequestReviewCommentSelectorImpl(child)));
    }
}
