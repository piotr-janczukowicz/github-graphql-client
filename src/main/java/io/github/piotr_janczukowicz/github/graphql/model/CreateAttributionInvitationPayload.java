package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateAttributionInvitationInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateAttributionInvitationPayload(
        @Nullable String clientMutationId, String ownerId, String sourceId, String targetId) {

    public CreateAttributionInvitationPayload {
        requireNonNull(ownerId, "ownerId");
        requireNonNull(sourceId, "sourceId");
        requireNonNull(targetId, "targetId");
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
        variable.put("ownerId", this.ownerId);
        variable.put("sourceId", this.sourceId);
        variable.put("targetId", this.targetId);
        return Collections.unmodifiableMap(variable);
    }
}
