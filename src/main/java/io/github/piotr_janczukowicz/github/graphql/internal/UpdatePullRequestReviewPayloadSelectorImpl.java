package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdatePullRequestReviewPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdatePullRequestReviewPayload}; used by the generated selection code only.
 */
final class UpdatePullRequestReviewPayloadSelectorImpl implements UpdatePullRequestReviewPayloadSelector {

    private final Cursor cursor;

    UpdatePullRequestReviewPayloadSelectorImpl(final Cursor cursor) {
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
