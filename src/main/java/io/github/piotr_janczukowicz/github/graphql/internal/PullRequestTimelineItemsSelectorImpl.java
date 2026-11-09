package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemsSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequestTimelineItems}; used by the generated selection code only. */
final class PullRequestTimelineItemsSelectorImpl implements PullRequestTimelineItemsSelector {

    private final Cursor cursor;

    PullRequestTimelineItemsSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, PullRequestTimelineItemsSelector.class, type, selection);
    }
}
