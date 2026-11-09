package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateRefsInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateRefsPayload(@Nullable String clientMutationId, List<RefUpdate> refUpdates, String repositoryId) {

    public UpdateRefsPayload {
        requireNonNull(repositoryId, "repositoryId");
        refUpdates = ListUtils.copyOf(refUpdates, "refUpdates");
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
                "refUpdates",
                this.refUpdates.stream().map(RefUpdate::toVariable).toList());
        variable.put("repositoryId", this.repositoryId);
        return Collections.unmodifiableMap(variable);
    }
}
