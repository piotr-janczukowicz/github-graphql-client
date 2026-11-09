package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MilestoneItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code MilestoneItem}; used by the generated selection code only. */
final class MilestoneItemSelectorImpl implements MilestoneItemSelector {

    private final Cursor cursor;

    MilestoneItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, MilestoneItemSelector.class, type, selection);
    }
}
