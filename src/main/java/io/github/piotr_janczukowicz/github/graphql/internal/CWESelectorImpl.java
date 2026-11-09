package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CWESelector;

/** Reads and records the fields of {@code CWE}; used by the generated selection code only. */
final class CWESelectorImpl implements CWESelector {

    private final Cursor cursor;

    CWESelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String cweId() {
        return cursor.getRequired("cweId", ScalarType.STRING);
    }

    @Override
    public String description() {
        return cursor.getRequired("description", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }
}
