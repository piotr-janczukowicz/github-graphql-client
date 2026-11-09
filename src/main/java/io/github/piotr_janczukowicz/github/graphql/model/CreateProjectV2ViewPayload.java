package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateProjectV2ViewInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateProjectV2ViewPayload(
        @Nullable String clientMutationId,
        @Nullable ProjectV2ViewConfigurationInput configuration,
        ProjectV2ViewLayout layout,
        String name,
        String projectId) {

    public CreateProjectV2ViewPayload {
        requireNonNull(layout, "layout");
        requireNonNull(name, "name");
        requireNonNull(projectId, "projectId");
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
        if (this.configuration != null) {
            variable.put("configuration", this.configuration.toVariable());
        }
        variable.put("layout", this.layout.wireValue());
        variable.put("name", this.name);
        variable.put("projectId", this.projectId);
        return Collections.unmodifiableMap(variable);
    }
}
