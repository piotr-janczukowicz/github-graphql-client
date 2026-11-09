package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EPSSSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code EPSS}; used by the generated selection code only. */
final class EPSSSelectorImpl implements EPSSSelector {

    private final Cursor cursor;

    EPSSSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Double percentage() {
        return cursor.get("percentage", ScalarType.FLOAT);
    }

    @Override
    public @Nullable Double percentile() {
        return cursor.get("percentile", ScalarType.FLOAT);
    }
}
