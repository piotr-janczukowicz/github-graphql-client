package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeatureableItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code SponsorsListingFeatureableItem}; used by the generated selection code only.
 */
final class SponsorsListingFeatureableItemSelectorImpl implements SponsorsListingFeatureableItemSelector {

    private final Cursor cursor;

    SponsorsListingFeatureableItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, SponsorsListingFeatureableItemSelector.class, type, selection);
    }
}
