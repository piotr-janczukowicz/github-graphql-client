package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CloneTemplateRepositoryInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CloneTemplateRepositoryPayload(
        @Nullable String clientMutationId,
        @Nullable String description,
        @Nullable Boolean includeAllBranches,
        String name,
        String ownerId,
        String repositoryId,
        RepositoryVisibility visibility) {

    public CloneTemplateRepositoryPayload {
        requireNonNull(name, "name");
        requireNonNull(ownerId, "ownerId");
        requireNonNull(repositoryId, "repositoryId");
        requireNonNull(visibility, "visibility");
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
        if (this.description != null) {
            variable.put("description", this.description);
        }
        if (this.includeAllBranches != null) {
            variable.put("includeAllBranches", this.includeAllBranches);
        }
        variable.put("name", this.name);
        variable.put("ownerId", this.ownerId);
        variable.put("repositoryId", this.repositoryId);
        variable.put("visibility", this.visibility.wireValue());
        return Collections.unmodifiableMap(variable);
    }
}
