package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddSubIssueInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddSubIssuePayload(
        @Nullable String clientMutationId,
        String issueId,
        @Nullable Boolean replaceParent,
        @Nullable String subIssueId,
        @Nullable String subIssueUrl) {

    public AddSubIssuePayload {
        requireNonNull(issueId, "issueId");
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
        variable.put("issueId", this.issueId);
        if (this.replaceParent != null) {
            variable.put("replaceParent", this.replaceParent);
        }
        if (this.subIssueId != null) {
            variable.put("subIssueId", this.subIssueId);
        }
        if (this.subIssueUrl != null) {
            variable.put("subIssueUrl", this.subIssueUrl);
        }
        return Collections.unmodifiableMap(variable);
    }
}
