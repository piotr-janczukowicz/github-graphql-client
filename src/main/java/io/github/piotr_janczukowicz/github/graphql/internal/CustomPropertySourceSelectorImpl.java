package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CustomPropertySourceSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CustomPropertySource}; used by the generated selection code only. */
final class CustomPropertySourceSelectorImpl implements CustomPropertySourceSelector {

    private final Cursor cursor;

    CustomPropertySourceSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, CustomPropertySourceSelector.class, type, selection);
    }
}
