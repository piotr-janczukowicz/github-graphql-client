package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequestReviewEdge}; used by the generated selection code only. */
final class PullRequestReviewEdgeSelectorImpl implements PullRequestReviewEdgeSelector {

    private final Cursor cursor;

    PullRequestReviewEdgeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String cursor() {
        return cursor.getRequired("cursor", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R node(final Function<PullRequestReviewSelector, R> selection) {
        return cursor.object("node", child -> selection.apply(new PullRequestReviewSelectorImpl(child)));
    }
}
