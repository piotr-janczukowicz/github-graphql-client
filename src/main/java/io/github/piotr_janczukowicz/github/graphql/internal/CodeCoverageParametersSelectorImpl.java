package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CodeCoverageParametersSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CodeCoverageParameters}; used by the generated selection code only. */
final class CodeCoverageParametersSelectorImpl implements CodeCoverageParametersSelector {

    private final Cursor cursor;

    CodeCoverageParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Double maxCoverageDrop() {
        return cursor.get("maxCoverageDrop", ScalarType.FLOAT);
    }

    @Override
    public @Nullable Double minimumCoverage() {
        return cursor.get("minimumCoverage", ScalarType.FLOAT);
    }
}
