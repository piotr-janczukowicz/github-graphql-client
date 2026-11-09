package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code PendingIssueSuggestionRef}; a field left {@code null} is not sent. */
@RecordBuilder
public record PendingIssueSuggestionRef(
        @Nullable String assigneeId,
        @Nullable String issueFieldId,
        @Nullable String issueTypeId,
        PendingIssueSuggestionKind kind,
        @Nullable String labelId) {

    public PendingIssueSuggestionRef {
        requireNonNull(kind, "kind");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.assigneeId != null) {
            variable.put("assigneeId", this.assigneeId);
        }
        if (this.issueFieldId != null) {
            variable.put("issueFieldId", this.issueFieldId);
        }
        if (this.issueTypeId != null) {
            variable.put("issueTypeId", this.issueTypeId);
        }
        variable.put("kind", this.kind.name());
        if (this.labelId != null) {
            variable.put("labelId", this.labelId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
