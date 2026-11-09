package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AgentAssignmentInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AgentAssignmentInput(
        @Nullable String baseRef,
        @Nullable String customAgent,
        @Nullable String customInstructions,
        @Nullable String targetRepositoryId) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.baseRef != null) {
            variable.put("baseRef", this.baseRef);
        }
        if (this.customAgent != null) {
            variable.put("customAgent", this.customAgent);
        }
        if (this.customInstructions != null) {
            variable.put("customInstructions", this.customInstructions);
        }
        if (this.targetRepositoryId != null) {
            variable.put("targetRepositoryId", this.targetRepositoryId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
