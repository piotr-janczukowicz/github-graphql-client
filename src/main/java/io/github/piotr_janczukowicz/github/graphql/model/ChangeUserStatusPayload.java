package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ChangeUserStatusInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record ChangeUserStatusPayload(
        @Nullable String clientMutationId,
        @Nullable String emoji,
        @Nullable Instant expiresAt,
        @Nullable Boolean limitedAvailability,
        @Nullable String message,
        @Nullable String organizationId) {

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
        if (this.emoji != null) {
            variable.put("emoji", this.emoji);
        }
        if (this.expiresAt != null) {
            variable.put("expiresAt", this.expiresAt.toString());
        }
        if (this.limitedAvailability != null) {
            variable.put("limitedAvailability", this.limitedAvailability);
        }
        if (this.message != null) {
            variable.put("message", this.message);
        }
        if (this.organizationId != null) {
            variable.put("organizationId", this.organizationId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
