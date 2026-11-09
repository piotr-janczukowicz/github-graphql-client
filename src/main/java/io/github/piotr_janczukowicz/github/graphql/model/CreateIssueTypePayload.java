package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateIssueTypeInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateIssueTypePayload(
        @Nullable String clientMutationId,
        @Nullable IssueTypeColor color,
        @Nullable String description,
        Boolean isEnabled,
        String name,
        String ownerId) {

    public CreateIssueTypePayload {
        requireNonNull(isEnabled, "isEnabled");
        requireNonNull(name, "name");
        requireNonNull(ownerId, "ownerId");
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
        if (this.color != null) {
            variable.put("color", this.color.wireValue());
        }
        if (this.description != null) {
            variable.put("description", this.description);
        }
        variable.put("isEnabled", this.isEnabled);
        variable.put("name", this.name);
        variable.put("ownerId", this.ownerId);
        return Collections.unmodifiableMap(variable);
    }
}
