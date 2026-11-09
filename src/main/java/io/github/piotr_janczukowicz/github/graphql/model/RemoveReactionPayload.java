package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RemoveReactionInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RemoveReactionPayload(@Nullable String clientMutationId, ReactionContent content, String subjectId) {

    public RemoveReactionPayload {
        requireNonNull(content, "content");
        requireNonNull(subjectId, "subjectId");
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
        variable.put("content", this.content.wireValue());
        variable.put("subjectId", this.subjectId);
        return Collections.unmodifiableMap(variable);
    }
}
