package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.json.OptionalNull;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code IssueTypeUpdateInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record IssueTypeUpdateInput(
        @Nullable IssueEventConfidenceLevel confidence,
        @Nullable OptionalNull<String> issueTypeId,
        @Nullable String rationale,
        @Nullable Boolean suggest) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, @Nullable Object> toVariable() {
        final Map<String, @Nullable Object> variable = new LinkedHashMap<>();
        if (this.confidence != null) {
            variable.put("confidence", this.confidence.wireValue());
        }
        if (this.issueTypeId != null) {
            variable.put("issueTypeId", this.issueTypeId.value());
        }
        if (this.rationale != null) {
            variable.put("rationale", this.rationale);
        }
        if (this.suggest != null) {
            variable.put("suggest", this.suggest);
        }
        return Collections.unmodifiableMap(variable);
    }
}
