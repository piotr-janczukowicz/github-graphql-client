package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateDeploymentInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateDeploymentPayload(
        @Nullable Boolean autoMerge,
        @Nullable String clientMutationId,
        @Nullable String description,
        @Nullable String environment,
        @Nullable String payload,
        String refId,
        String repositoryId,
        @Nullable List<String> requiredContexts,
        @Nullable String task) {

    public CreateDeploymentPayload {
        requireNonNull(refId, "refId");
        requireNonNull(repositoryId, "repositoryId");
        requiredContexts = ListUtils.copyOrNull(requiredContexts);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.autoMerge != null) {
            variable.put("autoMerge", this.autoMerge);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.description != null) {
            variable.put("description", this.description);
        }
        if (this.environment != null) {
            variable.put("environment", this.environment);
        }
        if (this.payload != null) {
            variable.put("payload", this.payload);
        }
        variable.put("refId", this.refId);
        variable.put("repositoryId", this.repositoryId);
        if (this.requiredContexts != null) {
            variable.put("requiredContexts", this.requiredContexts);
        }
        if (this.task != null) {
            variable.put("task", this.task);
        }
        return Collections.unmodifiableMap(variable);
    }
}
