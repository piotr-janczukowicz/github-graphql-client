package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateProjectV2ViewInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateProjectV2ViewPayload(
        @Nullable String clientMutationId,
        @Nullable ProjectV2ViewConfigurationInput configuration,
        @Nullable String filter,
        @Nullable ProjectV2ViewLayout layout,
        @Nullable String name,
        String viewId) {

    public UpdateProjectV2ViewPayload {
        requireNonNull(viewId, "viewId");
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
        if (this.filter != null) {
            variable.put("filter", this.filter);
        }
        if (this.layout != null) {
            variable.put("layout", this.layout.wireValue());
        }
        if (this.name != null) {
            variable.put("name", this.name);
        }
        variable.put("viewId", this.viewId);
        return Collections.unmodifiableMap(variable);
    }
}
