package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewDecision;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewStatusHovercardContextSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReviewStatusHovercardContext}; used by the generated selection code only. */
final class ReviewStatusHovercardContextSelectorImpl implements ReviewStatusHovercardContextSelector {

    private final Cursor cursor;

    ReviewStatusHovercardContextSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String message() {
        return cursor.getRequired("message", ScalarType.STRING);
    }

    @Override
    public String octicon() {
        return cursor.getRequired("octicon", ScalarType.STRING);
    }

    @Override
    public @Nullable PullRequestReviewDecision reviewDecision() {
        return cursor.get(
                "reviewDecision",
                ScalarType.enumeration(PullRequestReviewDecision::fromWire, PullRequestReviewDecision.APPROVED));
    }
}
