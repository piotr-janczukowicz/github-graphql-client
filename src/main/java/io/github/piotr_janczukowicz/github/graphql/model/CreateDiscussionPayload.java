package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateDiscussionInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateDiscussionPayload(
        String body, String categoryId, @Nullable String clientMutationId, String repositoryId, String title) {

    public CreateDiscussionPayload {
        requireNonNull(body, "body");
        requireNonNull(categoryId, "categoryId");
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
        variable.put("body", this.body);
        variable.put("categoryId", this.categoryId);
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("repositoryId", this.repositoryId);
        variable.put("title", this.title);
        return Collections.unmodifiableMap(variable);
    }
}
