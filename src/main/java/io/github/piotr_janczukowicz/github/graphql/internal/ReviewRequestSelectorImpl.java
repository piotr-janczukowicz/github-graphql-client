package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequestedReviewerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewRequestSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReviewRequest}; used by the generated selection code only. */
final class ReviewRequestSelectorImpl implements ReviewRequestSelector {

    private final Cursor cursor;

    ReviewRequestSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean asCodeOwner() {
        return cursor.getRequired("asCodeOwner", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R requestedReviewer(final Function<RequestedReviewerSelector, R> selection) {
        return cursor.object("requestedReviewer", child -> selection.apply(new RequestedReviewerSelectorImpl(child)));
    }
}
