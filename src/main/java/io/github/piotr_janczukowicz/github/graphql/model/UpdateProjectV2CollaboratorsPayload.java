package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateProjectV2CollaboratorsInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateProjectV2CollaboratorsPayload(
        @Nullable String clientMutationId, List<ProjectV2Collaborator> collaborators, String projectId) {

    public UpdateProjectV2CollaboratorsPayload {
        requireNonNull(projectId, "projectId");
        collaborators = ListUtils.copyOf(collaborators, "collaborators");
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
        variable.put(
                "collaborators",
                this.collaborators.stream()
                        .map(ProjectV2Collaborator::toVariable)
                        .toList());
        variable.put("projectId", this.projectId);
        return Collections.unmodifiableMap(variable);
    }
}
