package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BlameRangeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BlameSelector;
import java.util.List;
import java.util.function.Function;

/** Reads and records the fields of {@code Blame}; used by the generated selection code only. */
final class BlameSelectorImpl implements BlameSelector {

    private final Cursor cursor;

    BlameSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> ranges(final Function<BlameRangeSelector, R> selection) {
        return cursor.listRequired("ranges", child -> selection.apply(new BlameRangeSelectorImpl(child)));
    }
}
