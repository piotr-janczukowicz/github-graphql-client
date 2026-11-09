package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddPullRequestReviewCommentInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddPullRequestReviewCommentPayload(
        @Nullable String body,
        @Nullable String clientMutationId,
        @Nullable String commitOID,
        @Nullable String inReplyTo,
        @Nullable String path,
        @Nullable Integer position,
        @Nullable String pullRequestId,
        @Nullable String pullRequestReviewId) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.body != null) {
            variable.put("body", this.body);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.commitOID != null) {
            variable.put("commitOID", this.commitOID);
        }
        if (this.inReplyTo != null) {
            variable.put("inReplyTo", this.inReplyTo);
        }
        if (this.path != null) {
            variable.put("path", this.path);
        }
        if (this.position != null) {
            variable.put("position", this.position);
        }
        if (this.pullRequestId != null) {
            variable.put("pullRequestId", this.pullRequestId);
        }
        if (this.pullRequestReviewId != null) {
            variable.put("pullRequestReviewId", this.pullRequestReviewId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
