package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreatePullRequestInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreatePullRequestPayload(
        String baseRefName,
        @Nullable String body,
        @Nullable String clientMutationId,
        @Nullable Boolean draft,
        String headRefName,
        @Nullable String headRepositoryId,
        @Nullable Boolean maintainerCanModify,
        String repositoryId,
        String title) {

    public CreatePullRequestPayload {
        requireNonNull(baseRefName, "baseRefName");
        requireNonNull(headRefName, "headRefName");
        requireNonNull(repositoryId, "repositoryId");
        requireNonNull(title, "title");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("baseRefName", this.baseRefName);
        if (this.body != null) {
            variable.put("body", this.body);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.draft != null) {
            variable.put("draft", this.draft);
        }
        variable.put("headRefName", this.headRefName);
        if (this.headRepositoryId != null) {
            variable.put("headRepositoryId", this.headRepositoryId);
        }
        if (this.maintainerCanModify != null) {
            variable.put("maintainerCanModify", this.maintainerCanModify);
        }
        variable.put("repositoryId", this.repositoryId);
        variable.put("title", this.title);
        return Collections.unmodifiableMap(variable);
    }
}
