package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RepositoryNameConditionTargetInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RepositoryNameConditionTargetInput(
        List<String> exclude,
        List<String> include,
        @Nullable Boolean protectedValue) {

    public RepositoryNameConditionTargetInput {
        exclude = ListUtils.copyOf(exclude, "exclude");
        include = ListUtils.copyOf(include, "include");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("exclude", this.exclude);
        variable.put("include", this.include);
        if (this.protectedValue != null) {
            variable.put("protected", this.protectedValue);
        }
        return Collections.unmodifiableMap(variable);
    }
}
