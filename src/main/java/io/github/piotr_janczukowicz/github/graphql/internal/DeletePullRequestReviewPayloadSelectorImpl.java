package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeletePullRequestReviewPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code DeletePullRequestReviewPayload}; used by the generated selection code only.
 */
final class DeletePullRequestReviewPayloadSelectorImpl implements DeletePullRequestReviewPayloadSelector {

    private final Cursor cursor;

    DeletePullRequestReviewPayloadSelectorImpl(final Cursor cursor) {
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
}
