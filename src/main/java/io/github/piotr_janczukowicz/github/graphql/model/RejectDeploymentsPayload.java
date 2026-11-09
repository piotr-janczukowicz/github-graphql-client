package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RejectDeploymentsInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RejectDeploymentsPayload(
        @Nullable String clientMutationId,
        @Nullable String comment,
        List<String> environmentIds,
        String workflowRunId) {

    public RejectDeploymentsPayload {
        requireNonNull(workflowRunId, "workflowRunId");
        environmentIds = ListUtils.copyOf(environmentIds, "environmentIds");
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
        if (this.comment != null) {
            variable.put("comment", this.comment);
        }
        variable.put("environmentIds", this.environmentIds);
        variable.put("workflowRunId", this.workflowRunId);
        return Collections.unmodifiableMap(variable);
    }
}
