package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The GraphQL input object {@code UpdateEnterpriseOwnerOrganizationRoleInput}; a field left {@code null} is not sent.
 */
@RecordBuilder
public record UpdateEnterpriseOwnerOrganizationRolePayload(
        @Nullable String clientMutationId,
        String enterpriseId,
        String organizationId,
        RoleInOrganization organizationRole) {

    public UpdateEnterpriseOwnerOrganizationRolePayload {
        requireNonNull(enterpriseId, "enterpriseId");
        requireNonNull(organizationId, "organizationId");
        requireNonNull(organizationRole, "organizationRole");
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
        variable.put("enterpriseId", this.enterpriseId);
        variable.put("organizationId", this.organizationId);
        variable.put("organizationRole", this.organizationRole.name());
        return Collections.unmodifiableMap(variable);
    }
}
