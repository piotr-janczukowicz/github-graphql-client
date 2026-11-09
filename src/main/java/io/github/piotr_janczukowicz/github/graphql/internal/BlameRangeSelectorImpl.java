package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BlameRangeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code BlameRange}; used by the generated selection code only. */
final class BlameRangeSelectorImpl implements BlameRangeSelector {

    private final Cursor cursor;

    BlameRangeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int age() {
        return cursor.getRequired("age", ScalarType.INT);
    }

    @Override
    public <R> R commit(final Function<CommitSelector, R> selection) {
        return cursor.objectRequired("commit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public int endingLine() {
        return cursor.getRequired("endingLine", ScalarType.INT);
    }

    @Override
    public int startingLine() {
        return cursor.getRequired("startingLine", ScalarType.INT);
    }
}
