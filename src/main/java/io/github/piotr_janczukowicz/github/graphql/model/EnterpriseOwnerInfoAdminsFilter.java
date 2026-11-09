package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code EnterpriseOwnerInfo.admins}; an argument left {@code null} is not sent. */
@RecordBuilder
public record EnterpriseOwnerInfoAdminsFilter(
        @Nullable Boolean hasTwoFactorEnabled,
        @Nullable EnterpriseMemberOrder orderBy,
        @Nullable List<String> organizationLogins,
        @Nullable String query,
        @Nullable EnterpriseAdministratorRole role,
        @Nullable TwoFactorCredentialSecurityType twoFactorMethodSecurity) {

    public EnterpriseOwnerInfoAdminsFilter {
        organizationLogins = ListUtils.copyOrNull(organizationLogins);
    }
}
