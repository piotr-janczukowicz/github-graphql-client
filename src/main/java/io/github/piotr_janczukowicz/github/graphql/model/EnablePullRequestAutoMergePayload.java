package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code EnablePullRequestAutoMergeInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record EnablePullRequestAutoMergePayload(
        @Nullable String authorEmail,
        @Nullable String clientMutationId,
        @Nullable String commitBody,
        @Nullable String commitHeadline,
        @Nullable String expectedHeadOid,
        @Nullable PullRequestMergeMethod mergeMethod,
        String pullRequestId) {

    public EnablePullRequestAutoMergePayload {
        requireNonNull(pullRequestId, "pullRequestId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.authorEmail != null) {
            variable.put("authorEmail", this.authorEmail);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.commitBody != null) {
            variable.put("commitBody", this.commitBody);
        }
        if (this.commitHeadline != null) {
            variable.put("commitHeadline", this.commitHeadline);
        }
        if (this.expectedHeadOid != null) {
            variable.put("expectedHeadOid", this.expectedHeadOid);
        }
        if (this.mergeMethod != null) {
            variable.put("mergeMethod", this.mergeMethod.wireValue());
        }
        variable.put("pullRequestId", this.pullRequestId);
        return Collections.unmodifiableMap(variable);
    }
}
