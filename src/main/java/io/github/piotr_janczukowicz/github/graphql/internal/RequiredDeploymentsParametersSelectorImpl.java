package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RequiredDeploymentsParametersSelector;
import java.util.List;

/** Reads and records the fields of {@code RequiredDeploymentsParameters}; used by the generated selection code only. */
final class RequiredDeploymentsParametersSelectorImpl implements RequiredDeploymentsParametersSelector {

    private final Cursor cursor;

    RequiredDeploymentsParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> requiredDeploymentEnvironments() {
        return cursor.scalarListRequired("requiredDeploymentEnvironments", ScalarType.STRING);
    }
}
