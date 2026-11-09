package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UniformResourceLocatableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UniformResourceLocatable}; used by the generated selection code only. */
final class UniformResourceLocatableSelectorImpl implements UniformResourceLocatableSelector {

    private final Cursor cursor;

    UniformResourceLocatableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, UniformResourceLocatableSelector.class, type, selection);
    }
}
