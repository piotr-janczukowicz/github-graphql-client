package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddPullRequestReviewThreadReplyInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddPullRequestReviewThreadReplyPayload(
        String body,
        @Nullable String clientMutationId,
        @Nullable String pullRequestReviewId,
        String pullRequestReviewThreadId) {

    public AddPullRequestReviewThreadReplyPayload {
        requireNonNull(body, "body");
        requireNonNull(pullRequestReviewThreadId, "pullRequestReviewThreadId");
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
        if (this.pullRequestReviewId != null) {
            variable.put("pullRequestReviewId", this.pullRequestReviewId);
        }
        variable.put("pullRequestReviewThreadId", this.pullRequestReviewThreadId);
        return Collections.unmodifiableMap(variable);
    }
}
