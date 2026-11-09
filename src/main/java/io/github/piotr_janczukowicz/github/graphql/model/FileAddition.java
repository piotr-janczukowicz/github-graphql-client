package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** The GraphQL input object {@code FileAddition}; a field left {@code null} is not sent. */
@RecordBuilder
public record FileAddition(String contents, String path) {

    public FileAddition {
        requireNonNull(contents, "contents");
        requireNonNull(path, "path");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("contents", this.contents);
        variable.put("path", this.path);
        return Collections.unmodifiableMap(variable);
    }
}
