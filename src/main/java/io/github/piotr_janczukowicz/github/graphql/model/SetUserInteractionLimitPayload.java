package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code SetUserInteractionLimitInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record SetUserInteractionLimitPayload(
        @Nullable String clientMutationId,
        @Nullable RepositoryInteractionLimitExpiry expiry,
        RepositoryInteractionLimit limit,
        String userId) {

    public SetUserInteractionLimitPayload {
        requireNonNull(limit, "limit");
        requireNonNull(userId, "userId");
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
        if (this.expiry != null) {
            variable.put("expiry", this.expiry.name());
        }
        variable.put("limit", this.limit.wireValue());
        variable.put("userId", this.userId);
        return Collections.unmodifiableMap(variable);
    }
}
