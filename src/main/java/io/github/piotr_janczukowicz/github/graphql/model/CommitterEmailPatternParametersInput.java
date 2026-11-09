package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CommitterEmailPatternParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CommitterEmailPatternParametersInput(
        @Nullable String name, @Nullable Boolean negate, String operator, String pattern) {

    public CommitterEmailPatternParametersInput {
        requireNonNull(operator, "operator");
        requireNonNull(pattern, "pattern");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.name != null) {
            variable.put("name", this.name);
        }
        if (this.negate != null) {
            variable.put("negate", this.negate);
        }
        variable.put("operator", this.operator);
        variable.put("pattern", this.pattern);
        return Collections.unmodifiableMap(variable);
    }
}
