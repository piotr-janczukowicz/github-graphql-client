package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import io.github.piotr_janczukowicz.github.graphql.model.CustomPropertySourceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CustomPropertyValueType;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertyValuesEditableBy;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryCustomProperty}; used by the generated selection code only. */
final class RepositoryCustomPropertySelectorImpl implements RepositoryCustomPropertySelector {

    private final Cursor cursor;

    RepositoryCustomPropertySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> allowedValues() {
        return cursor.scalarList("allowedValues", ScalarType.STRING);
    }

    @Override
    public @Nullable CustomPropertyValue defaultValue() {
        return cursor.get("defaultValue", ScalarType.CUSTOM_PROPERTY_VALUE);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String propertyName() {
        return cursor.getRequired("propertyName", ScalarType.STRING);
    }

    @Override
    public @Nullable String regex() {
        return cursor.get("regex", ScalarType.STRING);
    }

    @Override
    public @Nullable Boolean requireExplicitValues() {
        return cursor.get("requireExplicitValues", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean required() {
        return cursor.get("required", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R source(final Function<CustomPropertySourceSelector, R> selection) {
        return cursor.objectRequired("source", child -> selection.apply(new CustomPropertySourceSelectorImpl(child)));
    }

    @Override
    public CustomPropertyValueType valueType() {
        return cursor.getRequired(
                "valueType",
                ScalarType.enumeration(CustomPropertyValueType::fromWire, CustomPropertyValueType.MULTI_SELECT));
    }

    @Override
    public RepositoryCustomPropertyValuesEditableBy valuesEditableBy() {
        return cursor.getRequired(
                "valuesEditableBy",
                ScalarType.enumeration(
                        RepositoryCustomPropertyValuesEditableBy::fromWire,
                        RepositoryCustomPropertyValuesEditableBy.ORG_ACTORS));
    }
}
