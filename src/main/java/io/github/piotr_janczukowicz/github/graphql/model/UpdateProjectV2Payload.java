package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateProjectV2Input}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateProjectV2Payload(
        @Nullable String clientMutationId,
        @Nullable Boolean closed,
        String projectId,
        @Nullable Boolean publicValue,
        @Nullable String readme,
        @Nullable String shortDescription,
        @Nullable String title) {

    public UpdateProjectV2Payload {
        requireNonNull(projectId, "projectId");
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
        if (this.closed != null) {
            variable.put("closed", this.closed);
        }
        variable.put("projectId", this.projectId);
        if (this.publicValue != null) {
            variable.put("public", this.publicValue);
        }
        if (this.readme != null) {
            variable.put("readme", this.readme);
        }
        if (this.shortDescription != null) {
            variable.put("shortDescription", this.shortDescription);
        }
        if (this.title != null) {
            variable.put("title", this.title);
        }
        return Collections.unmodifiableMap(variable);
    }
}
