package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Enterprise.members}; an argument left {@code null} is not sent. */
@RecordBuilder
public record EnterpriseMembersFilter(
        @Nullable EnterpriseUserDeployment deployment,
        @Nullable Boolean hasTwoFactorEnabled,
        @Nullable EnterpriseMemberOrder orderBy,
        @Nullable List<String> organizationLogins,
        @Nullable String query,
        @Nullable EnterpriseUserAccountMembershipRole role,
        @Nullable TwoFactorCredentialSecurityType twoFactorMethodSecurity) {

    public EnterpriseMembersFilter {
        organizationLogins = ListUtils.copyOrNull(organizationLogins);
    }
}
