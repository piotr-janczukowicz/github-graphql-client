package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateDeploymentStatusInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateDeploymentStatusPayload(
        @Nullable Boolean autoInactive,
        @Nullable String clientMutationId,
        String deploymentId,
        @Nullable String description,
        @Nullable String environment,
        @Nullable String environmentUrl,
        @Nullable String logUrl,
        DeploymentStatusState state) {

    public CreateDeploymentStatusPayload {
        requireNonNull(deploymentId, "deploymentId");
        requireNonNull(state, "state");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.autoInactive != null) {
            variable.put("autoInactive", this.autoInactive);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("deploymentId", this.deploymentId);
        if (this.description != null) {
            variable.put("description", this.description);
        }
        if (this.environment != null) {
            variable.put("environment", this.environment);
        }
        if (this.environmentUrl != null) {
            variable.put("environmentUrl", this.environmentUrl);
        }
        if (this.logUrl != null) {
            variable.put("logUrl", this.logUrl);
        }
        variable.put("state", this.state.wireValue());
        return Collections.unmodifiableMap(variable);
    }
}
