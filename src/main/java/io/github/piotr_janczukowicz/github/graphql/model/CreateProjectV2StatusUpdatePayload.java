package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateProjectV2StatusUpdateInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateProjectV2StatusUpdatePayload(
        @Nullable String body,
        @Nullable String clientMutationId,
        String projectId,
        @Nullable LocalDate startDate,
        @Nullable ProjectV2StatusUpdateStatus status,
        @Nullable LocalDate targetDate) {

    public CreateProjectV2StatusUpdatePayload {
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
        variable.put("projectId", this.projectId);
        if (this.startDate != null) {
            variable.put("startDate", this.startDate.toString());
        }
        if (this.status != null) {
            variable.put("status", this.status.wireValue());
        }
        if (this.targetDate != null) {
            variable.put("targetDate", this.targetDate.toString());
        }
        return Collections.unmodifiableMap(variable);
    }
}
