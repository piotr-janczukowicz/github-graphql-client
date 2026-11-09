package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.GenericHovercardContextSelector;

/** Reads and records the fields of {@code GenericHovercardContext}; used by the generated selection code only. */
final class GenericHovercardContextSelectorImpl implements GenericHovercardContextSelector {

    private final Cursor cursor;

    GenericHovercardContextSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String message() {
        return cursor.getRequired("message", ScalarType.STRING);
    }

    @Override
    public String octicon() {
        return cursor.getRequired("octicon", ScalarType.STRING);
    }
}
