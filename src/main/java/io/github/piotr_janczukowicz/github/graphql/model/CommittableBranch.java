package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CommittableBranch}; a field left {@code null} is not sent. */
@RecordBuilder
public record CommittableBranch(
        @Nullable String branchName,
        @Nullable String id,
        @Nullable String repositoryNameWithOwner) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.branchName != null) {
            variable.put("branchName", this.branchName);
        }
        if (this.id != null) {
            variable.put("id", this.id);
        }
        if (this.repositoryNameWithOwner != null) {
            variable.put("repositoryNameWithOwner", this.repositoryNameWithOwner);
        }
        return Collections.unmodifiableMap(variable);
    }
}
