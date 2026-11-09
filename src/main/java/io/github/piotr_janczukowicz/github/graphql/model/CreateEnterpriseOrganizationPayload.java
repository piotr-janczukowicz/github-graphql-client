package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateEnterpriseOrganizationInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateEnterpriseOrganizationPayload(
        List<String> adminLogins,
        String billingEmail,
        @Nullable String clientMutationId,
        String enterpriseId,
        String login,
        String profileName) {

    public CreateEnterpriseOrganizationPayload {
        requireNonNull(billingEmail, "billingEmail");
        requireNonNull(enterpriseId, "enterpriseId");
        requireNonNull(login, "login");
        requireNonNull(profileName, "profileName");
        adminLogins = ListUtils.copyOf(adminLogins, "adminLogins");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("adminLogins", this.adminLogins);
        variable.put("billingEmail", this.billingEmail);
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("enterpriseId", this.enterpriseId);
        variable.put("login", this.login);
        variable.put("profileName", this.profileName);
        return Collections.unmodifiableMap(variable);
    }
}
