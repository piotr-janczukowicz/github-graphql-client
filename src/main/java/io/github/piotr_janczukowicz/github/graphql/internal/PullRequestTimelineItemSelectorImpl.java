package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequestTimelineItem}; used by the generated selection code only. */
final class PullRequestTimelineItemSelectorImpl implements PullRequestTimelineItemSelector {

    private final Cursor cursor;

    PullRequestTimelineItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, PullRequestTimelineItemSelector.class, type, selection);
    }
}
