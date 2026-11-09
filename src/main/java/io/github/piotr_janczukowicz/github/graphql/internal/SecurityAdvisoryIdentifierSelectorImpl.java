package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryIdentifierSelector;

/** Reads and records the fields of {@code SecurityAdvisoryIdentifier}; used by the generated selection code only. */
final class SecurityAdvisoryIdentifierSelectorImpl implements SecurityAdvisoryIdentifierSelector {

    private final Cursor cursor;

    SecurityAdvisoryIdentifierSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String type() {
        return cursor.getRequired("type", ScalarType.STRING);
    }

    @Override
    public String value() {
        return cursor.getRequired("value", ScalarType.STRING);
    }
}
