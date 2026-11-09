package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** The GraphQL input object {@code FileExtensionRestrictionParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record FileExtensionRestrictionParametersInput(List<String> restrictedFileExtensions) {

    public FileExtensionRestrictionParametersInput {
        restrictedFileExtensions = ListUtils.copyOf(restrictedFileExtensions, "restrictedFileExtensions");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("restrictedFileExtensions", this.restrictedFileExtensions);
        return Collections.unmodifiableMap(variable);
    }
}
