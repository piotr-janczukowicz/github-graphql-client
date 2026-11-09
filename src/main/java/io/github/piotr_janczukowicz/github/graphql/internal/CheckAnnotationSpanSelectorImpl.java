package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationPositionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationSpanSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code CheckAnnotationSpan}; used by the generated selection code only. */
final class CheckAnnotationSpanSelectorImpl implements CheckAnnotationSpanSelector {

    private final Cursor cursor;

    CheckAnnotationSpanSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> R end(final Function<CheckAnnotationPositionSelector, R> selection) {
        return cursor.objectRequired("end", child -> selection.apply(new CheckAnnotationPositionSelectorImpl(child)));
    }

    @Override
    public <R> R start(final Function<CheckAnnotationPositionSelector, R> selection) {
        return cursor.objectRequired("start", child -> selection.apply(new CheckAnnotationPositionSelectorImpl(child)));
    }
}
