package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CopilotCodeReviewParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CopilotCodeReviewParametersInput(
        @Nullable Boolean reviewDraftPullRequests, @Nullable Boolean reviewOnPush) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.reviewDraftPullRequests != null) {
            variable.put("reviewDraftPullRequests", this.reviewDraftPullRequests);
        }
        if (this.reviewOnPush != null) {
            variable.put("reviewOnPush", this.reviewOnPush);
        }
        return Collections.unmodifiableMap(variable);
    }
}
