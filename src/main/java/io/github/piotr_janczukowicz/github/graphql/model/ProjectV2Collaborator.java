package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ProjectV2Collaborator}; a field left {@code null} is not sent. */
@RecordBuilder
public record ProjectV2Collaborator(
        ProjectV2Roles role,
        @Nullable String teamId,
        @Nullable String userId) {

    public ProjectV2Collaborator {
        requireNonNull(role, "role");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("role", this.role.name());
        if (this.teamId != null) {
            variable.put("teamId", this.teamId);
        }
        if (this.userId != null) {
            variable.put("userId", this.userId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
