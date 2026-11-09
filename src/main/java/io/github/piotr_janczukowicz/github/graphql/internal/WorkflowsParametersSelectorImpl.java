package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.WorkflowFileReferenceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowsParametersSelector;
import java.util.List;
import java.util.function.Function;

/** Reads and records the fields of {@code WorkflowsParameters}; used by the generated selection code only. */
final class WorkflowsParametersSelectorImpl implements WorkflowsParametersSelector {

    private final Cursor cursor;

    WorkflowsParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean doNotEnforceOnCreate() {
        return cursor.getRequired("doNotEnforceOnCreate", ScalarType.BOOLEAN);
    }

    @Override
    public <R> List<R> workflows(final Function<WorkflowFileReferenceSelector, R> selection) {
        return cursor.listRequired("workflows", child -> selection.apply(new WorkflowFileReferenceSelectorImpl(child)));
    }
}
