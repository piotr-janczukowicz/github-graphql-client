package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddDiscussionCommentInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddDiscussionCommentPayload(
        String body,
        @Nullable String clientMutationId,
        String discussionId,
        @Nullable String replyToId) {

    public AddDiscussionCommentPayload {
        requireNonNull(body, "body");
        requireNonNull(discussionId, "discussionId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("body", this.body);
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("discussionId", this.discussionId);
        if (this.replyToId != null) {
            variable.put("replyToId", this.replyToId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
