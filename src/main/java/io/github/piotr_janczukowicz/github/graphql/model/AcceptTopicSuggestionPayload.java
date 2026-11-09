package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AcceptTopicSuggestionInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AcceptTopicSuggestionPayload(
        @Nullable String clientMutationId,
        @Nullable String name,
        @Nullable String repositoryId) {

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
        if (this.name != null) {
            variable.put("name", this.name);
        }
        if (this.repositoryId != null) {
            variable.put("repositoryId", this.repositoryId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
