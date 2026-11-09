package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateLinkedBranchInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateLinkedBranchPayload(
        @Nullable String clientMutationId,
        String issueId,
        @Nullable String name,
        String oid,
        @Nullable String repositoryId) {

    public CreateLinkedBranchPayload {
        requireNonNull(issueId, "issueId");
        requireNonNull(oid, "oid");
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
        variable.put("issueId", this.issueId);
        if (this.name != null) {
            variable.put("name", this.name);
        }
        variable.put("oid", this.oid);
        if (this.repositoryId != null) {
            variable.put("repositoryId", this.repositoryId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
