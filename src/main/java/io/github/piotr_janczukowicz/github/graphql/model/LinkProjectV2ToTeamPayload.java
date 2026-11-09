package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code LinkProjectV2ToTeamInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record LinkProjectV2ToTeamPayload(@Nullable String clientMutationId, String projectId, String teamId) {

    public LinkProjectV2ToTeamPayload {
        requireNonNull(projectId, "projectId");
        requireNonNull(teamId, "teamId");
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
        variable.put("projectId", this.projectId);
        variable.put("teamId", this.teamId);
        return Collections.unmodifiableMap(variable);
    }
}
