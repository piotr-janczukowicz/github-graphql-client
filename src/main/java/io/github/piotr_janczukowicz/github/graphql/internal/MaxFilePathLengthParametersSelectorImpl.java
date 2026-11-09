package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MaxFilePathLengthParametersSelector;

/** Reads and records the fields of {@code MaxFilePathLengthParameters}; used by the generated selection code only. */
final class MaxFilePathLengthParametersSelectorImpl implements MaxFilePathLengthParametersSelector {

    private final Cursor cursor;

    MaxFilePathLengthParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int maxFilePathLength() {
        return cursor.getRequired("maxFilePathLength", ScalarType.INT);
    }
}
