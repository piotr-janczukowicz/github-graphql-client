package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code FilePathRestrictionParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record FilePathRestrictionParametersInput(
        @Nullable List<String> ignoredFilePaths, List<String> restrictedFilePaths) {

    public FilePathRestrictionParametersInput {
        ignoredFilePaths = ListUtils.copyOrNull(ignoredFilePaths);
        restrictedFilePaths = ListUtils.copyOf(restrictedFilePaths, "restrictedFilePaths");
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
        variable.put("restrictedFilePaths", this.restrictedFilePaths);
        return Collections.unmodifiableMap(variable);
    }
}
