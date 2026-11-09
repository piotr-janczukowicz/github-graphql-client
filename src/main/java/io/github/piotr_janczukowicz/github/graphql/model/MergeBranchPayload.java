package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code MergeBranchInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record MergeBranchPayload(
        @Nullable String authorEmail,
        String base,
        @Nullable String clientMutationId,
        @Nullable String commitMessage,
        String head,
        String repositoryId) {

    public MergeBranchPayload {
        requireNonNull(base, "base");
        requireNonNull(head, "head");
        requireNonNull(repositoryId, "repositoryId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.authorEmail != null) {
            variable.put("authorEmail", this.authorEmail);
        }
        variable.put("base", this.base);
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.commitMessage != null) {
            variable.put("commitMessage", this.commitMessage);
        }
        variable.put("head", this.head);
        variable.put("repositoryId", this.repositoryId);
        return Collections.unmodifiableMap(variable);
    }
}
