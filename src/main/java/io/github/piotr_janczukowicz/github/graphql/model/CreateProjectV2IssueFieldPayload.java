package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateProjectV2IssueFieldInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateProjectV2IssueFieldPayload(
        @Nullable String clientMutationId, String issueFieldId, String projectId) {

    public CreateProjectV2IssueFieldPayload {
        requireNonNull(issueFieldId, "issueFieldId");
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
        variable.put("issueFieldId", this.issueFieldId);
        variable.put("projectId", this.projectId);
        return Collections.unmodifiableMap(variable);
    }
}
