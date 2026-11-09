package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The optional arguments of {@code EnterpriseOwnerInfo.pendingMemberInvitations}; an argument left {@code null} is not
 * sent.
 */
@RecordBuilder
public record EnterpriseOwnerInfoPendingMemberInvitationsFilter(
        @Nullable OrganizationInvitationSource invitationSource,
        @Nullable List<String> organizationLogins,
        @Nullable String query) {

    public EnterpriseOwnerInfoPendingMemberInvitationsFilter {
        organizationLogins = ListUtils.copyOrNull(organizationLogins);
    }
}
