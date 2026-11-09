package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code IssueFieldSingleSelectOptionInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record IssueFieldSingleSelectOptionInput(
        IssueFieldSingleSelectOptionColor color, @Nullable String description, String name, Integer priority) {

    public IssueFieldSingleSelectOptionInput {
        requireNonNull(color, "color");
        requireNonNull(name, "name");
        requireNonNull(priority, "priority");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("color", this.color.wireValue());
        if (this.description != null) {
            variable.put("description", this.description);
        }
        variable.put("name", this.name);
        variable.put("priority", this.priority);
        return Collections.unmodifiableMap(variable);
    }
}
