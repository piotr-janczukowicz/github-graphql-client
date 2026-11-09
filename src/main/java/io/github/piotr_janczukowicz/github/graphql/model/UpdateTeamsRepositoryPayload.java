package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateTeamsRepositoryInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateTeamsRepositoryPayload(
        @Nullable String clientMutationId, RepositoryPermission permission, String repositoryId, List<String> teamIds) {

    public UpdateTeamsRepositoryPayload {
        requireNonNull(permission, "permission");
        requireNonNull(repositoryId, "repositoryId");
        teamIds = ListUtils.copyOf(teamIds, "teamIds");
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
        variable.put("permission", this.permission.wireValue());
        variable.put("repositoryId", this.repositoryId);
        variable.put("teamIds", this.teamIds);
        return Collections.unmodifiableMap(variable);
    }
}
