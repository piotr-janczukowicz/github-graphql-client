package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DependabotUpdateErrorSelector;

/** Reads and records the fields of {@code DependabotUpdateError}; used by the generated selection code only. */
final class DependabotUpdateErrorSelectorImpl implements DependabotUpdateErrorSelector {

    private final Cursor cursor;

    DependabotUpdateErrorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String body() {
        return cursor.getRequired("body", ScalarType.STRING);
    }

    @Override
    public String errorType() {
        return cursor.getRequired("errorType", ScalarType.STRING);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }
}
