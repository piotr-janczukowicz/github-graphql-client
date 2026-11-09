package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorableItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SponsorableItem}; used by the generated selection code only. */
final class SponsorableItemSelectorImpl implements SponsorableItemSelector {

    private final Cursor cursor;

    SponsorableItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, SponsorableItemSelector.class, type, selection);
    }
}
