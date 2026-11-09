package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RequiredStatusChecksParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusCheckConfigurationSelector;
import java.util.List;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code RequiredStatusChecksParameters}; used by the generated selection code only.
 */
final class RequiredStatusChecksParametersSelectorImpl implements RequiredStatusChecksParametersSelector {

    private final Cursor cursor;

    RequiredStatusChecksParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean doNotEnforceOnCreate() {
        return cursor.getRequired("doNotEnforceOnCreate", ScalarType.BOOLEAN);
    }

    @Override
    public <R> List<R> requiredStatusChecks(final Function<StatusCheckConfigurationSelector, R> selection) {
        return cursor.listRequired(
                "requiredStatusChecks", child -> selection.apply(new StatusCheckConfigurationSelectorImpl(child)));
    }

    @Override
    public boolean strictRequiredStatusChecksPolicy() {
        return cursor.getRequired("strictRequiredStatusChecksPolicy", ScalarType.BOOLEAN);
    }
}
