package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPropertyTargetDefinitionSelector;
import java.util.List;

/**
 * Reads and records the fields of {@code OrganizationPropertyTargetDefinition}; used by the generated selection code
 * only.
 */
final class OrganizationPropertyTargetDefinitionSelectorImpl implements OrganizationPropertyTargetDefinitionSelector {

    private final Cursor cursor;

    OrganizationPropertyTargetDefinitionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public List<String> propertyValues() {
        return cursor.scalarListRequired("propertyValues", ScalarType.STRING);
    }
}
