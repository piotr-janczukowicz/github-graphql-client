package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code GrantMigratorRoleInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record GrantMigratorRolePayload(
        String actor, ActorType actorType, @Nullable String clientMutationId, String organizationId) {

    public GrantMigratorRolePayload {
        requireNonNull(actor, "actor");
        requireNonNull(actorType, "actorType");
        requireNonNull(organizationId, "organizationId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("actor", this.actor);
        variable.put("actorType", this.actorType.name());
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("organizationId", this.organizationId);
        return Collections.unmodifiableMap(variable);
    }
}
