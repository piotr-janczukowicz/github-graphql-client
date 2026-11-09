package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CodeScanningParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CodeScanningToolSelector;
import java.util.List;
import java.util.function.Function;

/** Reads and records the fields of {@code CodeScanningParameters}; used by the generated selection code only. */
final class CodeScanningParametersSelectorImpl implements CodeScanningParametersSelector {

    private final Cursor cursor;

    CodeScanningParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> codeScanningTools(final Function<CodeScanningToolSelector, R> selection) {
        return cursor.listRequired(
                "codeScanningTools", child -> selection.apply(new CodeScanningToolSelectorImpl(child)));
    }
}
