package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.LicenseRuleSelector;

/** Reads and records the fields of {@code LicenseRule}; used by the generated selection code only. */
final class LicenseRuleSelectorImpl implements LicenseRuleSelector {

    private final Cursor cursor;

    LicenseRuleSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String description() {
        return cursor.getRequired("description", ScalarType.STRING);
    }

    @Override
    public String key() {
        return cursor.getRequired("key", ScalarType.STRING);
    }

    @Override
    public String label() {
        return cursor.getRequired("label", ScalarType.STRING);
    }
}
