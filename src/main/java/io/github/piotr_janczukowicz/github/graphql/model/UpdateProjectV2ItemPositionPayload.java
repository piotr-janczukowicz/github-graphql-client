package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.json.OptionalNull;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateProjectV2ItemPositionInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateProjectV2ItemPositionPayload(
        @Nullable OptionalNull<String> afterId, @Nullable String clientMutationId, String itemId, String projectId) {

    public UpdateProjectV2ItemPositionPayload {
        requireNonNull(itemId, "itemId");
        requireNonNull(projectId, "projectId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, @Nullable Object> toVariable() {
        final Map<String, @Nullable Object> variable = new LinkedHashMap<>();
        if (this.afterId != null) {
            variable.put("afterId", this.afterId.value());
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("itemId", this.itemId);
        variable.put("projectId", this.projectId);
        return Collections.unmodifiableMap(variable);
    }
}
