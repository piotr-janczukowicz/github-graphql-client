package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddAssigneesToAssignableInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddAssigneesToAssignablePayload(
        @Nullable AgentAssignmentInput agentAssignment,
        String assignableId,
        @Nullable List<String> assigneeIds,
        @Nullable List<AssigneeUpdateInput> assignees,
        @Nullable String clientMutationId) {

    public AddAssigneesToAssignablePayload {
        requireNonNull(assignableId, "assignableId");
        assigneeIds = ListUtils.copyOrNull(assigneeIds);
        assignees = ListUtils.copyOrNull(assignees);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.agentAssignment != null) {
            variable.put("agentAssignment", this.agentAssignment.toVariable());
        }
        variable.put("assignableId", this.assignableId);
        if (this.assigneeIds != null) {
            variable.put("assigneeIds", this.assigneeIds);
        }
        if (this.assignees != null) {
            variable.put(
                    "assignees",
                    this.assignees.stream().map(AssigneeUpdateInput::toVariable).toList());
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
