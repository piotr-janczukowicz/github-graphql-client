package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CloneProjectInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CloneProjectPayload(
        @Nullable String body,
        @Nullable String clientMutationId,
        Boolean includeWorkflows,
        String name,
        @Nullable Boolean publicValue,
        String sourceId,
        String targetOwnerId) {

    public CloneProjectPayload {
        requireNonNull(includeWorkflows, "includeWorkflows");
        requireNonNull(name, "name");
        requireNonNull(sourceId, "sourceId");
        requireNonNull(targetOwnerId, "targetOwnerId");
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
        variable.put("includeWorkflows", this.includeWorkflows);
        variable.put("name", this.name);
        if (this.publicValue != null) {
            variable.put("public", this.publicValue);
        }
        variable.put("sourceId", this.sourceId);
        variable.put("targetOwnerId", this.targetOwnerId);
        return Collections.unmodifiableMap(variable);
    }
}
