package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryPackageVersionSelector;

/**
 * Reads and records the fields of {@code SecurityAdvisoryPackageVersion}; used by the generated selection code only.
 */
final class SecurityAdvisoryPackageVersionSelectorImpl implements SecurityAdvisoryPackageVersionSelector {

    private final Cursor cursor;

    SecurityAdvisoryPackageVersionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String identifier() {
        return cursor.getRequired("identifier", ScalarType.STRING);
    }
}
