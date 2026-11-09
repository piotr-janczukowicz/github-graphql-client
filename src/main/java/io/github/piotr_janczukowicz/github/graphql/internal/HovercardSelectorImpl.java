package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.HovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.HovercardSelector;
import java.util.List;
import java.util.function.Function;

/** Reads and records the fields of {@code Hovercard}; used by the generated selection code only. */
final class HovercardSelectorImpl implements HovercardSelector {

    private final Cursor cursor;

    HovercardSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> contexts(final Function<HovercardContextSelector, R> selection) {
        return cursor.listRequired("contexts", child -> selection.apply(new HovercardContextSelectorImpl(child)));
    }
}
