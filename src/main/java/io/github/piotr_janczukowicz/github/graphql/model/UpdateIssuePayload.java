package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateIssueInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateIssuePayload(
        @Nullable AgentAssignmentInput agentAssignment,
        @Nullable List<String> assigneeIds,
        @Nullable List<AssigneeUpdateInput> assignees,
        @Nullable String body,
        @Nullable String clientMutationId,
        String id,
        @Nullable List<IssueFieldUpdateInput> issueFieldUpdates,
        @Nullable IssueTypeUpdateInput issueType,
        @Nullable String issueTypeId,
        @Nullable List<String> labelIds,
        @Nullable List<LabelUpdateInput> labels,
        @Nullable String milestoneId,
        @Nullable List<String> projectIds,
        @Nullable IssueState state,
        @Nullable IssueStateUpdateInput stateInput,
        @Nullable String title) {

    public UpdateIssuePayload {
        requireNonNull(id, "id");
        assigneeIds = ListUtils.copyOrNull(assigneeIds);
        assignees = ListUtils.copyOrNull(assignees);
        issueFieldUpdates = ListUtils.copyOrNull(issueFieldUpdates);
        labelIds = ListUtils.copyOrNull(labelIds);
        labels = ListUtils.copyOrNull(labels);
        projectIds = ListUtils.copyOrNull(projectIds);
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
        if (this.assigneeIds != null) {
            variable.put("assigneeIds", this.assigneeIds);
        }
        if (this.assignees != null) {
            variable.put(
                    "assignees",
                    this.assignees.stream().map(AssigneeUpdateInput::toVariable).toList());
        }
        if (this.body != null) {
            variable.put("body", this.body);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("id", this.id);
        if (this.issueFieldUpdates != null) {
            variable.put(
                    "issueFieldUpdates",
                    this.issueFieldUpdates.stream()
                            .map(IssueFieldUpdateInput::toVariable)
                            .toList());
        }
        if (this.issueType != null) {
            variable.put("issueType", this.issueType.toVariable());
        }
        if (this.issueTypeId != null) {
            variable.put("issueTypeId", this.issueTypeId);
        }
        if (this.labelIds != null) {
            variable.put("labelIds", this.labelIds);
        }
        if (this.labels != null) {
            variable.put(
                    "labels",
                    this.labels.stream().map(LabelUpdateInput::toVariable).toList());
        }
        if (this.milestoneId != null) {
            variable.put("milestoneId", this.milestoneId);
        }
        if (this.projectIds != null) {
            variable.put("projectIds", this.projectIds);
        }
        if (this.state != null) {
            variable.put("state", this.state.wireValue());
        }
        if (this.stateInput != null) {
            variable.put("stateInput", this.stateInput.toVariable());
        }
        if (this.title != null) {
            variable.put("title", this.title);
        }
        return Collections.unmodifiableMap(variable);
    }
}
