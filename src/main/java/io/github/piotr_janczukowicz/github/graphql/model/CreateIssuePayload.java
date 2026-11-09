package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateIssueInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateIssuePayload(
        @Nullable AgentAssignmentInput agentAssignment,
        @Nullable List<String> assigneeIds,
        @Nullable String body,
        @Nullable String clientMutationId,
        @Nullable List<IssueFieldCreateOrUpdateInput> issueFields,
        @Nullable String issueTemplate,
        @Nullable String issueTypeId,
        @Nullable List<String> labelIds,
        @Nullable String milestoneId,
        @Nullable String parentIssueId,
        @Nullable List<String> projectIds,
        @Nullable List<String> projectV2Ids,
        String repositoryId,
        String title) {

    public CreateIssuePayload {
        requireNonNull(repositoryId, "repositoryId");
        requireNonNull(title, "title");
        assigneeIds = ListUtils.copyOrNull(assigneeIds);
        issueFields = ListUtils.copyOrNull(issueFields);
        labelIds = ListUtils.copyOrNull(labelIds);
        projectIds = ListUtils.copyOrNull(projectIds);
        projectV2Ids = ListUtils.copyOrNull(projectV2Ids);
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
        if (this.body != null) {
            variable.put("body", this.body);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.issueFields != null) {
            variable.put(
                    "issueFields",
                    this.issueFields.stream()
                            .map(IssueFieldCreateOrUpdateInput::toVariable)
                            .toList());
        }
        if (this.issueTemplate != null) {
            variable.put("issueTemplate", this.issueTemplate);
        }
        if (this.issueTypeId != null) {
            variable.put("issueTypeId", this.issueTypeId);
        }
        if (this.labelIds != null) {
            variable.put("labelIds", this.labelIds);
        }
        if (this.milestoneId != null) {
            variable.put("milestoneId", this.milestoneId);
        }
        if (this.parentIssueId != null) {
            variable.put("parentIssueId", this.parentIssueId);
        }
        if (this.projectIds != null) {
            variable.put("projectIds", this.projectIds);
        }
        if (this.projectV2Ids != null) {
            variable.put("projectV2Ids", this.projectV2Ids);
        }
        variable.put("repositoryId", this.repositoryId);
        variable.put("title", this.title);
        return Collections.unmodifiableMap(variable);
    }
}
