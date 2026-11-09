package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CheckRunOutputImage}; a field left {@code null} is not sent. */
@RecordBuilder
public record CheckRunOutputImage(String alt, @Nullable String caption, String imageUrl) {

    public CheckRunOutputImage {
        requireNonNull(alt, "alt");
        requireNonNull(imageUrl, "imageUrl");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("alt", this.alt);
        if (this.caption != null) {
            variable.put("caption", this.caption);
        }
        variable.put("imageUrl", this.imageUrl);
        return Collections.unmodifiableMap(variable);
    }
}
