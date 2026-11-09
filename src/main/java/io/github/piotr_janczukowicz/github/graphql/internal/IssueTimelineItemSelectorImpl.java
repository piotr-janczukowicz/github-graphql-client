package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueTimelineItem}; used by the generated selection code only. */
final class IssueTimelineItemSelectorImpl implements IssueTimelineItemSelector {

    private final Cursor cursor;

    IssueTimelineItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, IssueTimelineItemSelector.class, type, selection);
    }
}
