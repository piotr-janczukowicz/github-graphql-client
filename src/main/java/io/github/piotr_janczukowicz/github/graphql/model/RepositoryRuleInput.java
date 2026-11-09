package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RepositoryRuleInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RepositoryRuleInput(
        @Nullable String id, @Nullable RuleParametersInput parameters, RepositoryRuleType type) {

    public RepositoryRuleInput {
        requireNonNull(type, "type");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.id != null) {
            variable.put("id", this.id);
        }
        if (this.parameters != null) {
            variable.put("parameters", this.parameters.toVariable());
        }
        variable.put("type", this.type.wireValue());
        return Collections.unmodifiableMap(variable);
    }
}
