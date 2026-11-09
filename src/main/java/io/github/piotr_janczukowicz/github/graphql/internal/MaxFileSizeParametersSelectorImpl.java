package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MaxFileSizeParametersSelector;
import java.util.List;

/** Reads and records the fields of {@code MaxFileSizeParameters}; used by the generated selection code only. */
final class MaxFileSizeParametersSelectorImpl implements MaxFileSizeParametersSelector {

    private final Cursor cursor;

    MaxFileSizeParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> ignoredFilePaths() {
        return cursor.scalarList("ignoredFilePaths", ScalarType.STRING);
    }

    @Override
    public int maxFileSize() {
        return cursor.getRequired("maxFileSize", ScalarType.INT);
    }
}
