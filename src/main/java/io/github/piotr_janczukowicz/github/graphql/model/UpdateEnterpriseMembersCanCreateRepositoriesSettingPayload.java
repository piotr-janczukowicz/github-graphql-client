package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The GraphQL input object {@code UpdateEnterpriseMembersCanCreateRepositoriesSettingInput}; a field left {@code null}
 * is not sent.
 */
@RecordBuilder
public record UpdateEnterpriseMembersCanCreateRepositoriesSettingPayload(
        @Nullable String clientMutationId,
        String enterpriseId,
        @Nullable Boolean membersCanCreateInternalRepositories,
        @Nullable Boolean membersCanCreatePrivateRepositories,
        @Nullable Boolean membersCanCreatePublicRepositories,
        @Nullable Boolean membersCanCreateRepositoriesPolicyEnabled,
        @Nullable EnterpriseMembersCanCreateRepositoriesSettingValue settingValue) {

    public UpdateEnterpriseMembersCanCreateRepositoriesSettingPayload {
        requireNonNull(enterpriseId, "enterpriseId");
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
        if (this.membersCanCreateInternalRepositories != null) {
            variable.put("membersCanCreateInternalRepositories", this.membersCanCreateInternalRepositories);
        }
        if (this.membersCanCreatePrivateRepositories != null) {
            variable.put("membersCanCreatePrivateRepositories", this.membersCanCreatePrivateRepositories);
        }
        if (this.membersCanCreatePublicRepositories != null) {
            variable.put("membersCanCreatePublicRepositories", this.membersCanCreatePublicRepositories);
        }
        if (this.membersCanCreateRepositoriesPolicyEnabled != null) {
            variable.put("membersCanCreateRepositoriesPolicyEnabled", this.membersCanCreateRepositoriesPolicyEnabled);
        }
        if (this.settingValue != null) {
            variable.put("settingValue", this.settingValue.wireValue());
        }
        return Collections.unmodifiableMap(variable);
    }
}
