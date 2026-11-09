package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CheckAnnotationRange}; a field left {@code null} is not sent. */
@RecordBuilder
public record CheckAnnotationRange(
        @Nullable Integer endColumn,
        Integer endLine,
        @Nullable Integer startColumn,
        Integer startLine) {

    public CheckAnnotationRange {
        requireNonNull(endLine, "endLine");
        requireNonNull(startLine, "startLine");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.endColumn != null) {
            variable.put("endColumn", this.endColumn);
        }
        variable.put("endLine", this.endLine);
        if (this.startColumn != null) {
            variable.put("startColumn", this.startColumn);
        }
        variable.put("startLine", this.startLine);
        return Collections.unmodifiableMap(variable);
    }
}
