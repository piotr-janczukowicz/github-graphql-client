package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code SetRepositoryCustomPropertyValuesInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record SetRepositoryCustomPropertyValuesPayload(
        @Nullable String clientMutationId, List<CustomPropertyValueInput> properties, String repositoryId) {

    public SetRepositoryCustomPropertyValuesPayload {
        requireNonNull(repositoryId, "repositoryId");
        properties = ListUtils.copyOf(properties, "properties");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put(
                "properties",
                this.properties.stream()
                        .map(CustomPropertyValueInput::toVariable)
                        .toList());
        variable.put("repositoryId", this.repositoryId);
        return Collections.unmodifiableMap(variable);
    }
}
