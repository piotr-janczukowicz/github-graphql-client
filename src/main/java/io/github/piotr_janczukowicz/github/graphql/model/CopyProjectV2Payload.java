package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CopyProjectV2Input}; a field left {@code null} is not sent. */
@RecordBuilder
public record CopyProjectV2Payload(
        @Nullable String clientMutationId,
        @Nullable Boolean includeDraftIssues,
        String ownerId,
        String projectId,
        String title) {

    public CopyProjectV2Payload {
        requireNonNull(ownerId, "ownerId");
        requireNonNull(projectId, "projectId");
        requireNonNull(title, "title");
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
        if (this.includeDraftIssues != null) {
            variable.put("includeDraftIssues", this.includeDraftIssues);
        }
        variable.put("ownerId", this.ownerId);
        variable.put("projectId", this.projectId);
        variable.put("title", this.title);
        return Collections.unmodifiableMap(variable);
    }
}
