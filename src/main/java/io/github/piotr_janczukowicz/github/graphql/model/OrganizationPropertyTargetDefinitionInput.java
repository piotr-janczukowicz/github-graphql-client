package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The GraphQL input object {@code OrganizationPropertyTargetDefinitionInput}; a field left {@code null} is not sent.
 */
@RecordBuilder
public record OrganizationPropertyTargetDefinitionInput(String name, List<String> propertyValues) {

    public OrganizationPropertyTargetDefinitionInput {
        requireNonNull(name, "name");
        propertyValues = ListUtils.copyOf(propertyValues, "propertyValues");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("name", this.name);
        variable.put("propertyValues", this.propertyValues);
        return Collections.unmodifiableMap(variable);
    }
}
