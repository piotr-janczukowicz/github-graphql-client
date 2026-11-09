package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeletePullRequestReviewCommentPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code DeletePullRequestReviewCommentPayload}; used by the generated selection code
 * only.
 */
final class DeletePullRequestReviewCommentPayloadSelectorImpl implements DeletePullRequestReviewCommentPayloadSelector {

    private final Cursor cursor;

    DeletePullRequestReviewCommentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R pullRequestReview(final Function<PullRequestReviewSelector, R> selection) {
        return cursor.object("pullRequestReview", child -> selection.apply(new PullRequestReviewSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R pullRequestReviewComment(final Function<PullRequestReviewCommentSelector, R> selection) {
        return cursor.object(
                "pullRequestReviewComment", child -> selection.apply(new PullRequestReviewCommentSelectorImpl(child)));
    }
}
