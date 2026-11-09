package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertyValueSelector;

/** Reads and records the fields of {@code RepositoryCustomPropertyValue}; used by the generated selection code only. */
final class RepositoryCustomPropertyValueSelectorImpl implements RepositoryCustomPropertyValueSelector {

    private final Cursor cursor;

    RepositoryCustomPropertyValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String propertyName() {
        return cursor.getRequired("propertyName", ScalarType.STRING);
    }

    @Override
    public CustomPropertyValue value() {
        return cursor.getRequired("value", ScalarType.CUSTOM_PROPERTY_VALUE);
    }
}
