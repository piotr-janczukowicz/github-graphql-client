package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddEnterpriseOrganizationMemberInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddEnterpriseOrganizationMemberPayload(
        @Nullable String clientMutationId,
        String enterpriseId,
        String organizationId,
        @Nullable OrganizationMemberRole role,
        List<String> userIds) {

    public AddEnterpriseOrganizationMemberPayload {
        requireNonNull(enterpriseId, "enterpriseId");
        requireNonNull(organizationId, "organizationId");
        userIds = ListUtils.copyOf(userIds, "userIds");
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
        if (this.role != null) {
            variable.put("role", this.role.name());
        }
        variable.put("userIds", this.userIds);
        return Collections.unmodifiableMap(variable);
    }
}
