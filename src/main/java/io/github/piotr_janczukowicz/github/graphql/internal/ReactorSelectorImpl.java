package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ReactorSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Reactor}; used by the generated selection code only. */
final class ReactorSelectorImpl implements ReactorSelector {

    private final Cursor cursor;

    ReactorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ReactorSelector.class, type, selection);
    }
}
