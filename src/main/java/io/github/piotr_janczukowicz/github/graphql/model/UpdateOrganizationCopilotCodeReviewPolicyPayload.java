package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The GraphQL input object {@code UpdateOrganizationCopilotCodeReviewPolicyInput}; a field left {@code null} is not
 * sent.
 */
@RecordBuilder
public record UpdateOrganizationCopilotCodeReviewPolicyPayload(
        @Nullable String clientMutationId, String organizationId, OrganizationCopilotCodeReviewPolicyState state) {

    public UpdateOrganizationCopilotCodeReviewPolicyPayload {
        requireNonNull(organizationId, "organizationId");
        requireNonNull(state, "state");
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
        variable.put("organizationId", this.organizationId);
        variable.put("state", this.state.wireValue());
        return Collections.unmodifiableMap(variable);
    }
}
