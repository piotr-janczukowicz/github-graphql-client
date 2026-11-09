package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddProjectV2DraftIssueInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddProjectV2DraftIssuePayload(
        @Nullable List<String> assigneeIds,
        @Nullable String body,
        @Nullable String clientMutationId,
        String projectId,
        String title) {

    public AddProjectV2DraftIssuePayload {
        requireNonNull(projectId, "projectId");
        requireNonNull(title, "title");
        assigneeIds = ListUtils.copyOrNull(assigneeIds);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.assigneeIds != null) {
            variable.put("assigneeIds", this.assigneeIds);
        }
        if (this.body != null) {
            variable.put("body", this.body);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("projectId", this.projectId);
        variable.put("title", this.title);
        return Collections.unmodifiableMap(variable);
    }
}
