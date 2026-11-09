package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateProjectInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateProjectPayload(
        @Nullable String body,
        @Nullable String clientMutationId,
        @Nullable String name,
        String projectId,
        @Nullable Boolean publicValue,
        @Nullable ProjectState state) {

    public UpdateProjectPayload {
        requireNonNull(projectId, "projectId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.body != null) {
            variable.put("body", this.body);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.name != null) {
            variable.put("name", this.name);
        }
        variable.put("projectId", this.projectId);
        if (this.publicValue != null) {
            variable.put("public", this.publicValue);
        }
        if (this.state != null) {
            variable.put("state", this.state.wireValue());
        }
        return Collections.unmodifiableMap(variable);
    }
}
