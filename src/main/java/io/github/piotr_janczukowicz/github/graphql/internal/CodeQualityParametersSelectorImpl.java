package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CodeQualityParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CodeQualitySeverity;

/** Reads and records the fields of {@code CodeQualityParameters}; used by the generated selection code only. */
final class CodeQualityParametersSelectorImpl implements CodeQualityParametersSelector {

    private final Cursor cursor;

    CodeQualityParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public CodeQualitySeverity severity() {
        return cursor.getRequired(
                "severity", ScalarType.enumeration(CodeQualitySeverity::fromWire, CodeQualitySeverity.ALL));
    }
}
