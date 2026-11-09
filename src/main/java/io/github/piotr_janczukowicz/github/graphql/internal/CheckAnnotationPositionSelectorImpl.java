package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationPositionSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CheckAnnotationPosition}; used by the generated selection code only. */
final class CheckAnnotationPositionSelectorImpl implements CheckAnnotationPositionSelector {

    private final Cursor cursor;

    CheckAnnotationPositionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Integer column() {
        return cursor.get("column", ScalarType.INT);
    }

    @Override
    public int line() {
        return cursor.getRequired("line", ScalarType.INT);
    }
}
