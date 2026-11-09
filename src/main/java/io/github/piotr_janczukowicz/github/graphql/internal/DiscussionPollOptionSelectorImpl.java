package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DiscussionPollOption}; used by the generated selection code only. */
final class DiscussionPollOptionSelectorImpl implements DiscussionPollOptionSelector {

    private final Cursor cursor;

    DiscussionPollOptionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String option() {
        return cursor.getRequired("option", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R poll(final Function<DiscussionPollSelector, R> selection) {
        return cursor.object("poll", child -> selection.apply(new DiscussionPollSelectorImpl(child)));
    }

    @Override
    public int totalVoteCount() {
        return cursor.getRequired("totalVoteCount", ScalarType.INT);
    }

    @Override
    public boolean viewerHasVoted() {
        return cursor.getRequired("viewerHasVoted", ScalarType.BOOLEAN);
    }
}
