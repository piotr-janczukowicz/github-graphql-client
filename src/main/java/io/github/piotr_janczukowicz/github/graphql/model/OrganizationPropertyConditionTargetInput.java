package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** The GraphQL input object {@code OrganizationPropertyConditionTargetInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record OrganizationPropertyConditionTargetInput(
        List<OrganizationPropertyTargetDefinitionInput> exclude,
        List<OrganizationPropertyTargetDefinitionInput> include) {

    public OrganizationPropertyConditionTargetInput {
        exclude = ListUtils.copyOf(exclude, "exclude");
        include = ListUtils.copyOf(include, "include");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put(
                "exclude",
                this.exclude.stream()
                        .map(OrganizationPropertyTargetDefinitionInput::toVariable)
                        .toList());
        variable.put(
                "include",
                this.include.stream()
                        .map(OrganizationPropertyTargetDefinitionInput::toVariable)
                        .toList());
        return Collections.unmodifiableMap(variable);
    }
}
