package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddPullRequestReviewThreadInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddPullRequestReviewThreadPayload(
        String body,
        @Nullable String clientMutationId,
        @Nullable Integer line,
        @Nullable String path,
        @Nullable String pullRequestId,
        @Nullable String pullRequestReviewId,
        @Nullable DiffSide side,
        @Nullable Integer startLine,
        @Nullable DiffSide startSide,
        @Nullable PullRequestReviewThreadSubjectType subjectType) {

    public AddPullRequestReviewThreadPayload {
        requireNonNull(body, "body");
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
        if (this.line != null) {
            variable.put("line", this.line);
        }
        if (this.path != null) {
            variable.put("path", this.path);
        }
        if (this.pullRequestId != null) {
            variable.put("pullRequestId", this.pullRequestId);
        }
        if (this.pullRequestReviewId != null) {
            variable.put("pullRequestReviewId", this.pullRequestReviewId);
        }
        if (this.side != null) {
            variable.put("side", this.side.wireValue());
        }
        if (this.startLine != null) {
            variable.put("startLine", this.startLine);
        }
        if (this.startSide != null) {
            variable.put("startSide", this.startSide.wireValue());
        }
        if (this.subjectType != null) {
            variable.put("subjectType", this.subjectType.wireValue());
        }
        return Collections.unmodifiableMap(variable);
    }
}
