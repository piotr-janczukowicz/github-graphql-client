package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SearchResultItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SearchResultItem}; used by the generated selection code only. */
final class SearchResultItemSelectorImpl implements SearchResultItemSelector {

    private final Cursor cursor;

    SearchResultItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, SearchResultItemSelector.class, type, selection);
    }
}
