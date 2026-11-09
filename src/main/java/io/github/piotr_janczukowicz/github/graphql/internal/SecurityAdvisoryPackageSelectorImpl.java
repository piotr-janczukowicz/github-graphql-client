package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryEcosystem;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryPackageSelector;

/** Reads and records the fields of {@code SecurityAdvisoryPackage}; used by the generated selection code only. */
final class SecurityAdvisoryPackageSelectorImpl implements SecurityAdvisoryPackageSelector {

    private final Cursor cursor;

    SecurityAdvisoryPackageSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public SecurityAdvisoryEcosystem ecosystem() {
        return cursor.getRequired(
                "ecosystem",
                ScalarType.enumeration(SecurityAdvisoryEcosystem::fromWire, SecurityAdvisoryEcosystem.ACTIONS));
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }
}
