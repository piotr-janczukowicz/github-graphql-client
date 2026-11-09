package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code SubmitPullRequestReviewInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record SubmitPullRequestReviewPayload(
        @Nullable String body,
        @Nullable String clientMutationId,
        PullRequestReviewEvent event,
        @Nullable String pullRequestId,
        @Nullable String pullRequestReviewId) {

    public SubmitPullRequestReviewPayload {
        requireNonNull(event, "event");
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
        variable.put("event", this.event.name());
        if (this.pullRequestId != null) {
            variable.put("pullRequestId", this.pullRequestId);
        }
        if (this.pullRequestReviewId != null) {
            variable.put("pullRequestReviewId", this.pullRequestReviewId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
