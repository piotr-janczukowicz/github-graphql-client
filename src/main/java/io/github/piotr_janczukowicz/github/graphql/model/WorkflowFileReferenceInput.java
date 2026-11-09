package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code WorkflowFileReferenceInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record WorkflowFileReferenceInput(
        String path,
        @Nullable String ref,
        Integer repositoryId,
        @Nullable String sha) {

    public WorkflowFileReferenceInput {
        requireNonNull(path, "path");
        requireNonNull(repositoryId, "repositoryId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("path", this.path);
        if (this.ref != null) {
            variable.put("ref", this.ref);
        }
        variable.put("repositoryId", this.repositoryId);
        if (this.sha != null) {
            variable.put("sha", this.sha);
        }
        return Collections.unmodifiableMap(variable);
    }
}
