package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RepositoryRulesetBypassActorInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RepositoryRulesetBypassActorInput(
        @Nullable String actorId,
        RepositoryRulesetBypassActorBypassMode bypassMode,
        @Nullable Boolean deployKey,
        @Nullable Boolean enterpriseOwner,
        @Nullable Boolean enterpriseRole,
        @Nullable BigInteger enterpriseRoleDatabaseId,
        @Nullable Boolean organizationAdmin,
        @Nullable Integer repositoryRoleDatabaseId) {

    public RepositoryRulesetBypassActorInput {
        requireNonNull(bypassMode, "bypassMode");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.actorId != null) {
            variable.put("actorId", this.actorId);
        }
        variable.put("bypassMode", this.bypassMode.wireValue());
        if (this.deployKey != null) {
            variable.put("deployKey", this.deployKey);
        }
        if (this.enterpriseOwner != null) {
            variable.put("enterpriseOwner", this.enterpriseOwner);
        }
        if (this.enterpriseRole != null) {
            variable.put("enterpriseRole", this.enterpriseRole);
        }
        if (this.enterpriseRoleDatabaseId != null) {
            variable.put("enterpriseRoleDatabaseId", this.enterpriseRoleDatabaseId.toString());
        }
        if (this.organizationAdmin != null) {
            variable.put("organizationAdmin", this.organizationAdmin);
        }
        if (this.repositoryRoleDatabaseId != null) {
            variable.put("repositoryRoleDatabaseId", this.repositoryRoleDatabaseId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
