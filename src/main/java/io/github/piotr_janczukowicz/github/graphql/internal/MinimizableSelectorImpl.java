package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MinimizableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Minimizable}; used by the generated selection code only. */
final class MinimizableSelectorImpl implements MinimizableSelector {

    private final Cursor cursor;

    MinimizableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean isMinimized() {
        return cursor.getRequired("isMinimized", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String minimizedReason() {
        return cursor.get("minimizedReason", ScalarType.STRING);
    }

    @Override
    public boolean viewerCanMinimize() {
        return cursor.getRequired("viewerCanMinimize", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanUnminimize() {
        return cursor.getRequired("viewerCanUnminimize", ScalarType.BOOLEAN);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, MinimizableSelector.class, type, selection);
    }
}
