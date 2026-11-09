package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ProjectV2MultiSelectFieldOptionInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record ProjectV2MultiSelectFieldOptionInput(
        ProjectV2SingleSelectFieldOptionColor color,
        String description,
        @Nullable String id,
        String name) {

    public ProjectV2MultiSelectFieldOptionInput {
        requireNonNull(color, "color");
        requireNonNull(description, "description");
        requireNonNull(name, "name");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("color", this.color.wireValue());
        variable.put("description", this.description);
        if (this.id != null) {
            variable.put("id", this.id);
        }
        variable.put("name", this.name);
        return Collections.unmodifiableMap(variable);
    }
}
