package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CodeScanningToolSelector;

/** Reads and records the fields of {@code CodeScanningTool}; used by the generated selection code only. */
final class CodeScanningToolSelectorImpl implements CodeScanningToolSelector {

    private final Cursor cursor;

    CodeScanningToolSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String alertsThreshold() {
        return cursor.getRequired("alertsThreshold", ScalarType.STRING);
    }

    @Override
    public String securityAlertsThreshold() {
        return cursor.getRequired("securityAlertsThreshold", ScalarType.STRING);
    }

    @Override
    public String tool() {
        return cursor.getRequired("tool", ScalarType.STRING);
    }
}
