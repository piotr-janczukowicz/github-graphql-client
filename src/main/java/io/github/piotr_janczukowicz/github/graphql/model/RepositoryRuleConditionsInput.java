package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RepositoryRuleConditionsInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RepositoryRuleConditionsInput(
        @Nullable OrganizationPropertyConditionTargetInput organizationProperty,
        @Nullable RefNameConditionTargetInput refName,
        @Nullable RepositoryIdConditionTargetInput repositoryId,
        @Nullable RepositoryNameConditionTargetInput repositoryName,
        @Nullable RepositoryPropertyConditionTargetInput repositoryProperty) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.organizationProperty != null) {
            variable.put("organizationProperty", this.organizationProperty.toVariable());
        }
        if (this.refName != null) {
            variable.put("refName", this.refName.toVariable());
        }
        if (this.repositoryId != null) {
            variable.put("repositoryId", this.repositoryId.toVariable());
        }
        if (this.repositoryName != null) {
            variable.put("repositoryName", this.repositoryName.toVariable());
        }
        if (this.repositoryProperty != null) {
            variable.put("repositoryProperty", this.repositoryProperty.toVariable());
        }
        return Collections.unmodifiableMap(variable);
    }
}
