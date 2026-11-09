package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UpdateParametersSelector;

/** Reads and records the fields of {@code UpdateParameters}; used by the generated selection code only. */
final class UpdateParametersSelectorImpl implements UpdateParametersSelector {

    private final Cursor cursor;

    UpdateParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean updateAllowsFetchAndMerge() {
        return cursor.getRequired("updateAllowsFetchAndMerge", ScalarType.BOOLEAN);
    }
}
