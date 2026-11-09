package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CVSSSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CVSS}; used by the generated selection code only. */
final class CVSSSelectorImpl implements CVSSSelector {

    private final Cursor cursor;

    CVSSSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public double score() {
        return cursor.getRequired("score", ScalarType.FLOAT);
    }

    @Override
    public @Nullable String vectorString() {
        return cursor.get("vectorString", ScalarType.STRING);
    }
}
