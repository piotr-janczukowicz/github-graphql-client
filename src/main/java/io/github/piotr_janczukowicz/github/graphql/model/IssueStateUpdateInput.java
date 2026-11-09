package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code IssueStateUpdateInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record IssueStateUpdateInput(
        @Nullable IssueEventConfidenceLevel confidence,
        @Nullable String duplicateIssueId,
        @Nullable String rationale,
        @Nullable IssueClosedStateReason stateReason,
        @Nullable Boolean suggest,
        IssueState value) {

    public IssueStateUpdateInput {
        requireNonNull(value, "value");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.confidence != null) {
            variable.put("confidence", this.confidence.wireValue());
        }
        if (this.duplicateIssueId != null) {
            variable.put("duplicateIssueId", this.duplicateIssueId);
        }
        if (this.rationale != null) {
            variable.put("rationale", this.rationale);
        }
        if (this.stateReason != null) {
            variable.put("stateReason", this.stateReason.name());
        }
        if (this.suggest != null) {
            variable.put("suggest", this.suggest);
        }
        variable.put("value", this.value.wireValue());
        return Collections.unmodifiableMap(variable);
    }
}
