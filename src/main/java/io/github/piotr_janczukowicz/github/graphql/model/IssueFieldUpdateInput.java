package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code IssueFieldUpdateInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record IssueFieldUpdateInput(
        String fieldName,
        IssueFieldUpdateOperation operation,
        @Nullable String value) {

    public IssueFieldUpdateInput {
        requireNonNull(fieldName, "fieldName");
        requireNonNull(operation, "operation");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("fieldName", this.fieldName);
        variable.put("operation", this.operation.name());
        if (this.value != null) {
            variable.put("value", this.value);
        }
        return Collections.unmodifiableMap(variable);
    }
}
