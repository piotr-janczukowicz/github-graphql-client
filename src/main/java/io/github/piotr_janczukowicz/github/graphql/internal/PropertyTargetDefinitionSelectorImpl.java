package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PropertyTargetDefinitionSelector;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PropertyTargetDefinition}; used by the generated selection code only. */
final class PropertyTargetDefinitionSelectorImpl implements PropertyTargetDefinitionSelector {

    private final Cursor cursor;

    PropertyTargetDefinitionSelectorImpl(final Cursor cursor) {
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

    @Override
    public @Nullable String source() {
        return cursor.get("source", ScalarType.STRING);
    }
}
