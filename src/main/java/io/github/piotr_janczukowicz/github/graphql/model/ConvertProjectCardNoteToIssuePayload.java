package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ConvertProjectCardNoteToIssueInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record ConvertProjectCardNoteToIssuePayload(
        @Nullable String body,
        @Nullable String clientMutationId,
        String projectCardId,
        String repositoryId,
        @Nullable String title) {

    public ConvertProjectCardNoteToIssuePayload {
        requireNonNull(projectCardId, "projectCardId");
        requireNonNull(repositoryId, "repositoryId");
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
        variable.put("projectCardId", this.projectCardId);
        variable.put("repositoryId", this.repositoryId);
        if (this.title != null) {
            variable.put("title", this.title);
        }
        return Collections.unmodifiableMap(variable);
    }
}
