package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateProjectCardInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateProjectCardPayload(
        @Nullable String clientMutationId,
        @Nullable Boolean isArchived,
        @Nullable String note,
        String projectCardId) {

    public UpdateProjectCardPayload {
        requireNonNull(projectCardId, "projectCardId");
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
        if (this.isArchived != null) {
            variable.put("isArchived", this.isArchived);
        }
        if (this.note != null) {
            variable.put("note", this.note);
        }
        variable.put("projectCardId", this.projectCardId);
        return Collections.unmodifiableMap(variable);
    }
}
