package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequestReviewCommentEdge}; used by the generated selection code only. */
final class PullRequestReviewCommentEdgeSelectorImpl implements PullRequestReviewCommentEdgeSelector {

    private final Cursor cursor;

    PullRequestReviewCommentEdgeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String cursor() {
        return cursor.getRequired("cursor", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R node(final Function<PullRequestReviewCommentSelector, R> selection) {
        return cursor.object("node", child -> selection.apply(new PullRequestReviewCommentSelectorImpl(child)));
    }
}
