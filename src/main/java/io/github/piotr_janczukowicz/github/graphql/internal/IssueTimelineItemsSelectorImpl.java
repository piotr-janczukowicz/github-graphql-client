package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemsSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueTimelineItems}; used by the generated selection code only. */
final class IssueTimelineItemsSelectorImpl implements IssueTimelineItemsSelector {

    private final Cursor cursor;

    IssueTimelineItemsSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, IssueTimelineItemsSelector.class, type, selection);
    }
}
