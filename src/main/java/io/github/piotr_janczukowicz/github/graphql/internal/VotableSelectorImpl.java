package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.VotableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Votable}; used by the generated selection code only. */
final class VotableSelectorImpl implements VotableSelector {

    private final Cursor cursor;

    VotableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int upvoteCount() {
        return cursor.getRequired("upvoteCount", ScalarType.INT);
    }

    @Override
    public boolean viewerCanUpvote() {
        return cursor.getRequired("viewerCanUpvote", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerHasUpvoted() {
        return cursor.getRequired("viewerHasUpvoted", ScalarType.BOOLEAN);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, VotableSelector.class, type, selection);
    }
}
