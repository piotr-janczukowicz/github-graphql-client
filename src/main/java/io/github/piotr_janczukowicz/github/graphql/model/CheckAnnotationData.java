package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CheckAnnotationData}; a field left {@code null} is not sent. */
@RecordBuilder
public record CheckAnnotationData(
        CheckAnnotationLevel annotationLevel,
        CheckAnnotationRange location,
        String message,
        String path,
        @Nullable String rawDetails,
        @Nullable String title) {

    public CheckAnnotationData {
        requireNonNull(annotationLevel, "annotationLevel");
        requireNonNull(location, "location");
        requireNonNull(message, "message");
        requireNonNull(path, "path");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("annotationLevel", this.annotationLevel.wireValue());
        variable.put("location", this.location.toVariable());
        variable.put("message", this.message);
        variable.put("path", this.path);
        if (this.rawDetails != null) {
            variable.put("rawDetails", this.rawDetails);
        }
        if (this.title != null) {
            variable.put("title", this.title);
        }
        return Collections.unmodifiableMap(variable);
    }
}
