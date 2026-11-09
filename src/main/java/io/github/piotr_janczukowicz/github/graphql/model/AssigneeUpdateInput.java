package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AssigneeUpdateInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AssigneeUpdateInput(
        String actorId,
        @Nullable IssueEventConfidenceLevel confidence,
        @Nullable String rationale,
        @Nullable Boolean suggest) {

    public AssigneeUpdateInput {
        requireNonNull(actorId, "actorId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("actorId", this.actorId);
        if (this.confidence != null) {
            variable.put("confidence", this.confidence.wireValue());
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
