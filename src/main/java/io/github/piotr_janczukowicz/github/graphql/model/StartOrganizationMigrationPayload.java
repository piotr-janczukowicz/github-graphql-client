package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code StartOrganizationMigrationInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record StartOrganizationMigrationPayload(
        @Nullable String clientMutationId,
        String sourceAccessToken,
        String sourceOrgUrl,
        String targetEnterpriseId,
        String targetOrgName) {

    public StartOrganizationMigrationPayload {
        requireNonNull(sourceAccessToken, "sourceAccessToken");
        requireNonNull(sourceOrgUrl, "sourceOrgUrl");
        requireNonNull(targetEnterpriseId, "targetEnterpriseId");
        requireNonNull(targetOrgName, "targetOrgName");
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
        variable.put("sourceAccessToken", this.sourceAccessToken);
        variable.put("sourceOrgUrl", this.sourceOrgUrl);
        variable.put("targetEnterpriseId", this.targetEnterpriseId);
        variable.put("targetOrgName", this.targetOrgName);
        return Collections.unmodifiableMap(variable);
    }
}
