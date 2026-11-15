package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The GraphQL input object {@code UpdateRepositoryCopilotCodeReviewSettingsInput}; a field left {@code null} is not
 * sent.
 */
@RecordBuilder
public record UpdateRepositoryCopilotCodeReviewSettingsPayload(
        @Nullable String clientMutationId,
        @Nullable Boolean customInstructionsEnabled,
        @Nullable Boolean mcpEnabled,
        String repositoryId,
        @Nullable RepositoryCopilotCodeReviewEffortSetting reviewEffort,
        @Nullable CopilotCodeReviewSeverityFilter severityFilter) {

    public UpdateRepositoryCopilotCodeReviewSettingsPayload {
        requireNonNull(repositoryId, "repositoryId");
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
        if (this.customInstructionsEnabled != null) {
            variable.put("customInstructionsEnabled", this.customInstructionsEnabled);
        }
        if (this.mcpEnabled != null) {
            variable.put("mcpEnabled", this.mcpEnabled);
        }
        variable.put("repositoryId", this.repositoryId);
        if (this.reviewEffort != null) {
            variable.put("reviewEffort", this.reviewEffort.name());
        }
        if (this.severityFilter != null) {
            variable.put("severityFilter", this.severityFilter.wireValue());
        }
        return Collections.unmodifiableMap(variable);
    }
}
