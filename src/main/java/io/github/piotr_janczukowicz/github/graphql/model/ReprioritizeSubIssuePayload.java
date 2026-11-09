package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ReprioritizeSubIssueInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record ReprioritizeSubIssuePayload(
        @Nullable String afterId,
        @Nullable String beforeId,
        @Nullable String clientMutationId,
        String issueId,
        String subIssueId) {

    public ReprioritizeSubIssuePayload {
        requireNonNull(issueId, "issueId");
        requireNonNull(subIssueId, "subIssueId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.afterId != null) {
            variable.put("afterId", this.afterId);
        }
        if (this.beforeId != null) {
            variable.put("beforeId", this.beforeId);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("issueId", this.issueId);
        variable.put("subIssueId", this.subIssueId);
        return Collections.unmodifiableMap(variable);
    }
}
