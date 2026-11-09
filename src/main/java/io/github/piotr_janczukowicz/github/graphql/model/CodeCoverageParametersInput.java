package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CodeCoverageParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CodeCoverageParametersInput(
        @Nullable Double maxCoverageDrop, @Nullable Double minimumCoverage) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.maxCoverageDrop != null) {
            variable.put("maxCoverageDrop", this.maxCoverageDrop);
        }
        if (this.minimumCoverage != null) {
            variable.put("minimumCoverage", this.minimumCoverage);
        }
        return Collections.unmodifiableMap(variable);
    }
}
