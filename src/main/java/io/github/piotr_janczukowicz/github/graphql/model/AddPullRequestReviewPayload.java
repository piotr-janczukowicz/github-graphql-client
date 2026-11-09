package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddPullRequestReviewInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddPullRequestReviewPayload(
        @Nullable String body,
        @Nullable String clientMutationId,
        @Nullable List<DraftPullRequestReviewComment> comments,
        @Nullable String commitOID,
        @Nullable PullRequestReviewEvent event,
        String pullRequestId,
        @Nullable List<DraftPullRequestReviewThread> threads) {

    public AddPullRequestReviewPayload {
        requireNonNull(pullRequestId, "pullRequestId");
        comments = ListUtils.copyOrNull(comments);
        threads = ListUtils.copyOrNull(threads);
    }

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
        if (this.comments != null) {
            variable.put(
                    "comments",
                    this.comments.stream()
                            .map(DraftPullRequestReviewComment::toVariable)
                            .toList());
        }
        if (this.commitOID != null) {
            variable.put("commitOID", this.commitOID);
        }
        if (this.event != null) {
            variable.put("event", this.event.name());
        }
        variable.put("pullRequestId", this.pullRequestId);
        if (this.threads != null) {
            variable.put(
                    "threads",
                    this.threads.stream()
                            .map(DraftPullRequestReviewThread::toVariable)
                            .toList());
        }
        return Collections.unmodifiableMap(variable);
    }
}
