package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PendingIssueSuggestionSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PendingIssueSuggestion}; used by the generated selection code only. */
final class PendingIssueSuggestionSelectorImpl implements PendingIssueSuggestionSelector {

    private final Cursor cursor;

    PendingIssueSuggestionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, PendingIssueSuggestionSelector.class, type, selection);
    }
}
