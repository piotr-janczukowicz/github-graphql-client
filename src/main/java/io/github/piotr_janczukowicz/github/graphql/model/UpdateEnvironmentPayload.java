package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateEnvironmentInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateEnvironmentPayload(
        @Nullable String clientMutationId,
        String environmentId,
        @Nullable Boolean preventSelfReview,
        @Nullable List<String> reviewers,
        @Nullable Integer waitTimer) {

    public UpdateEnvironmentPayload {
        requireNonNull(environmentId, "environmentId");
        reviewers = ListUtils.copyOrNull(reviewers);
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
        variable.put("environmentId", this.environmentId);
        if (this.preventSelfReview != null) {
            variable.put("preventSelfReview", this.preventSelfReview);
        }
        if (this.reviewers != null) {
            variable.put("reviewers", this.reviewers);
        }
        if (this.waitTimer != null) {
            variable.put("waitTimer", this.waitTimer);
        }
        return Collections.unmodifiableMap(variable);
    }
}
