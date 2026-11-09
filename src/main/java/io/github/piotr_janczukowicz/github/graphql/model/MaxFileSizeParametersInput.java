package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code MaxFileSizeParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record MaxFileSizeParametersInput(@Nullable List<String> ignoredFilePaths, Integer maxFileSize) {

    public MaxFileSizeParametersInput {
        requireNonNull(maxFileSize, "maxFileSize");
        ignoredFilePaths = ListUtils.copyOrNull(ignoredFilePaths);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.ignoredFilePaths != null) {
            variable.put("ignoredFilePaths", this.ignoredFilePaths);
        }
        variable.put("maxFileSize", this.maxFileSize);
        return Collections.unmodifiableMap(variable);
    }
}
