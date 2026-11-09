package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddPullRequestReviewCommentPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code AddPullRequestReviewCommentPayload}; used by the generated selection code
 * only.
 */
final class AddPullRequestReviewCommentPayloadSelectorImpl implements AddPullRequestReviewCommentPayloadSelector {

    private final Cursor cursor;

    AddPullRequestReviewCommentPayloadSelectorImpl(final Cursor cursor) {
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

    @Override
    public <R> @Nullable R commentEdge(final Function<PullRequestReviewCommentEdgeSelector, R> selection) {
        return cursor.object(
                "commentEdge", child -> selection.apply(new PullRequestReviewCommentEdgeSelectorImpl(child)));
    }
}
