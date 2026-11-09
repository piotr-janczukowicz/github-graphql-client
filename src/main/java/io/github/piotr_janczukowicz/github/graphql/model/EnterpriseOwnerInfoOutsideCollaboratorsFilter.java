package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The optional arguments of {@code EnterpriseOwnerInfo.outsideCollaborators}; an argument left {@code null} is not
 * sent.
 */
@RecordBuilder
public record EnterpriseOwnerInfoOutsideCollaboratorsFilter(
        @Nullable Boolean hasTwoFactorEnabled,
        @Nullable String login,
        @Nullable EnterpriseMemberOrder orderBy,
        @Nullable List<String> organizationLogins,
        @Nullable String query,
        @Nullable TwoFactorCredentialSecurityType twoFactorMethodSecurity,
        @Nullable RepositoryVisibility visibility) {

    public EnterpriseOwnerInfoOutsideCollaboratorsFilter {
        organizationLogins = ListUtils.copyOrNull(organizationLogins);
    }
}
