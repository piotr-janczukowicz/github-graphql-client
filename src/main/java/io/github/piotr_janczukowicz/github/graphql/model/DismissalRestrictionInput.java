package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code DismissalRestrictionInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record DismissalRestrictionInput(@Nullable List<String> allowedActors, Boolean enabled) {

    public DismissalRestrictionInput {
        requireNonNull(enabled, "enabled");
        allowedActors = ListUtils.copyOrNull(allowedActors);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.allowedActors != null) {
            variable.put("allowedActors", this.allowedActors);
        }
        variable.put("enabled", this.enabled);
        return Collections.unmodifiableMap(variable);
    }
}
