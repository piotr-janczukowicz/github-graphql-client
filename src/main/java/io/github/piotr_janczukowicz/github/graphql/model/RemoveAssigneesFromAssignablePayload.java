package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RemoveAssigneesFromAssignableInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RemoveAssigneesFromAssignablePayload(
        String assignableId,
        List<String> assigneeIds,
        @Nullable String clientMutationId) {

    public RemoveAssigneesFromAssignablePayload {
        requireNonNull(assignableId, "assignableId");
        assigneeIds = ListUtils.copyOf(assigneeIds, "assigneeIds");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("assignableId", this.assignableId);
        variable.put("assigneeIds", this.assigneeIds);
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
