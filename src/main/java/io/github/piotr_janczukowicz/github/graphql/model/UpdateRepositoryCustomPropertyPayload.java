package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateRepositoryCustomPropertyInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateRepositoryCustomPropertyPayload(
        @Nullable List<String> allowedValues,
        @Nullable String clientMutationId,
        @Nullable String defaultValue,
        @Nullable String description,
        @Nullable String regex,
        String repositoryCustomPropertyId,
        @Nullable Boolean requireExplicitValues,
        @Nullable Boolean required,
        @Nullable RepositoryCustomPropertyValuesEditableBy valuesEditableBy) {

    public UpdateRepositoryCustomPropertyPayload {
        requireNonNull(repositoryCustomPropertyId, "repositoryCustomPropertyId");
        allowedValues = ListUtils.copyOrNull(allowedValues);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.allowedValues != null) {
            variable.put("allowedValues", this.allowedValues);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.defaultValue != null) {
            variable.put("defaultValue", this.defaultValue);
        }
        if (this.description != null) {
            variable.put("description", this.description);
        }
        if (this.regex != null) {
            variable.put("regex", this.regex);
        }
        variable.put("repositoryCustomPropertyId", this.repositoryCustomPropertyId);
        if (this.requireExplicitValues != null) {
            variable.put("requireExplicitValues", this.requireExplicitValues);
        }
        if (this.required != null) {
            variable.put("required", this.required);
        }
        if (this.valuesEditableBy != null) {
            variable.put("valuesEditableBy", this.valuesEditableBy.wireValue());
        }
        return Collections.unmodifiableMap(variable);
    }
}
