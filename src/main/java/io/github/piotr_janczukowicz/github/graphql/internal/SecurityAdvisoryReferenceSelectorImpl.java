package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryReferenceSelector;

/** Reads and records the fields of {@code SecurityAdvisoryReference}; used by the generated selection code only. */
final class SecurityAdvisoryReferenceSelectorImpl implements SecurityAdvisoryReferenceSelector {

    private final Cursor cursor;

    SecurityAdvisoryReferenceSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
