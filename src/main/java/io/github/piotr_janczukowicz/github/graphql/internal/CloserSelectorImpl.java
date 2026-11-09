package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CloserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Closer}; used by the generated selection code only. */
final class CloserSelectorImpl implements CloserSelector {

    private final Cursor cursor;

    CloserSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, CloserSelector.class, type, selection);
    }
}
