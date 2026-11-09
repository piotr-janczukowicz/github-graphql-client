package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PinnableItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PinnableItem}; used by the generated selection code only. */
final class PinnableItemSelectorImpl implements PinnableItemSelector {

    private final Cursor cursor;

    PinnableItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, PinnableItemSelector.class, type, selection);
    }
}
