package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateRefInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateRefPayload(@Nullable String clientMutationId, String name, String oid, String repositoryId) {

    public CreateRefPayload {
        requireNonNull(name, "name");
        requireNonNull(oid, "oid");
        requireNonNull(repositoryId, "repositoryId");
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
        variable.put("name", this.name);
        variable.put("oid", this.oid);
        variable.put("repositoryId", this.repositoryId);
        return Collections.unmodifiableMap(variable);
    }
}
