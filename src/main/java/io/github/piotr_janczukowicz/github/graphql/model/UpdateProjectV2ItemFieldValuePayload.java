package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateProjectV2ItemFieldValueInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateProjectV2ItemFieldValuePayload(
        @Nullable String clientMutationId, String fieldId, String itemId, String projectId, ProjectV2FieldValue value) {

    public UpdateProjectV2ItemFieldValuePayload {
        requireNonNull(fieldId, "fieldId");
        requireNonNull(itemId, "itemId");
        requireNonNull(projectId, "projectId");
        requireNonNull(value, "value");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("fieldId", this.fieldId);
        variable.put("itemId", this.itemId);
        variable.put("projectId", this.projectId);
        variable.put("value", this.value.toVariable());
        return Collections.unmodifiableMap(variable);
    }
}
