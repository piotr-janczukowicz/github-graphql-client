package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CheckRunOutput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CheckRunOutput(
        @Nullable List<CheckAnnotationData> annotations,
        @Nullable List<CheckRunOutputImage> images,
        String summary,
        @Nullable String text,
        String title) {

    public CheckRunOutput {
        requireNonNull(summary, "summary");
        requireNonNull(title, "title");
        annotations = ListUtils.copyOrNull(annotations);
        images = ListUtils.copyOrNull(images);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.annotations != null) {
            variable.put(
                    "annotations",
                    this.annotations.stream()
                            .map(CheckAnnotationData::toVariable)
                            .toList());
        }
        if (this.images != null) {
            variable.put(
                    "images",
                    this.images.stream().map(CheckRunOutputImage::toVariable).toList());
        }
        variable.put("summary", this.summary);
        if (this.text != null) {
            variable.put("text", this.text);
        }
        variable.put("title", this.title);
        return Collections.unmodifiableMap(variable);
    }
}
