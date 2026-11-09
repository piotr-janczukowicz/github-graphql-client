package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code EnqueuePullRequestInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record EnqueuePullRequestPayload(
        @Nullable String clientMutationId,
        @Nullable String expectedHeadOid,
        @Nullable Boolean jump,
        String pullRequestId) {

    public EnqueuePullRequestPayload {
        requireNonNull(pullRequestId, "pullRequestId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.expectedHeadOid != null) {
            variable.put("expectedHeadOid", this.expectedHeadOid);
        }
        if (this.jump != null) {
            variable.put("jump", this.jump);
        }
        variable.put("pullRequestId", this.pullRequestId);
        return Collections.unmodifiableMap(variable);
    }
}
