package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DefaultRepositoryPermissionField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAllowPrivateRepositoryForkingPolicyValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseDefaultRepositoryPermissionSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseDisallowedMethodsSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseEnabledDisabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMembersCanCreateRepositoriesSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMembersCanMakePurchasesSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoAdminsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoAdminsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoAllowPrivateRepositoryForkingSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoAllowPrivateRepositoryForkingSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoDefaultRepositoryPermissionSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoDefaultRepositoryPermissionSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoDomainsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoDomainsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoEnterpriseServerInstallationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoEnterpriseServerInstallationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoFailedInvitationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoFailedInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoIpAllowListEntriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoIpAllowListEntriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanChangeRepositoryVisibilitySettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanChangeRepositoryVisibilitySettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanCreateRepositoriesSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanCreateRepositoriesSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanDeleteIssuesSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanDeleteIssuesSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanDeleteRepositoriesSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanDeleteRepositoriesSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanInviteCollaboratorsSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanInviteCollaboratorsSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanUpdateProtectedBranchesSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanUpdateProtectedBranchesSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanViewDependencyInsightsSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanViewDependencyInsightsSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoOrganizationProjectsSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoOrganizationProjectsSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoOutsideCollaboratorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoOutsideCollaboratorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingAdminInvitationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingAdminInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingCollaboratorInvitationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingCollaboratorInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingMemberInvitationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingMemberInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingUnaffiliatedMemberInvitationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingUnaffiliatedMemberInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoRepositoryDeployKeySettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoRepositoryDeployKeySettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoRepositoryProjectsSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoRepositoryProjectsSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoSamlIdentityProviderSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoSamlIdentityProviderSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoSupportEntitlementsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoSupportEntitlementsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoTwoFactorRequiredSettingOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoTwoFactorRequiredSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IdentityProviderConfigurationState;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListForInstalledAppsEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListUserLevelEnforcementEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.NotificationRestrictionSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.OIDCProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMembersCanCreateRepositoriesSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code EnterpriseOwnerInfo}; used by the generated selection code only. */
final class EnterpriseOwnerInfoSelectorImpl implements EnterpriseOwnerInfoSelector {

    private static final String PAGING = "paging";

    private static final String ARGUMENTS = "arguments";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String BOOLEAN = "Boolean";

    private static final String ORDER_BY = "orderBy";

    private static final String ENTERPRISE_MEMBER_ORDER = "EnterpriseMemberOrder";

    private static final String ORGANIZATION_LOGINS = "organizationLogins";

    private static final String STRING_2 = "[String!]";

    private static final String QUERY = "query";

    private static final String ORGANIZATION_ORDER = "OrganizationOrder";

    private static final String VALUE = "value";

    private static final String BOOLEAN_2 = "Boolean!";

    private final Cursor cursor;

    EnterpriseOwnerInfoSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> admins(
            final Paging paging,
            final EnterpriseOwnerInfoAdminsFilter arguments,
            final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "admins",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("hasTwoFactorEnabled", BOOLEAN, arguments.hasTwoFactorEnabled()),
                Argument.of(
                        ORDER_BY,
                        ENTERPRISE_MEMBER_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(ORGANIZATION_LOGINS, STRING_2, arguments.organizationLogins()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of("role", "EnterpriseAdministratorRole", arguments.role()),
                Argument.of(
                        "twoFactorMethodSecurity",
                        "TwoFactorCredentialSecurityType",
                        arguments.twoFactorMethodSecurity()));
    }

    @Override
    public <R> Page<R> admins(final Paging paging, final Function<UserSelector, R> selection) {
        return admins(paging, EnterpriseOwnerInfoAdminsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> affiliatedUsersWithTwoFactorDisabled(
            final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "affiliatedUsersWithTwoFactorDisabled",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public boolean affiliatedUsersWithTwoFactorDisabledExist() {
        return cursor.getRequired("affiliatedUsersWithTwoFactorDisabledExist", ScalarType.BOOLEAN);
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue allowPrivateRepositoryForkingSetting() {
        return cursor.getRequired(
                "allowPrivateRepositoryForkingSetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> allowPrivateRepositoryForkingSettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoAllowPrivateRepositoryForkingSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "allowPrivateRepositoryForkingSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> allowPrivateRepositoryForkingSettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return allowPrivateRepositoryForkingSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoAllowPrivateRepositoryForkingSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public @Nullable EnterpriseAllowPrivateRepositoryForkingPolicyValue
            allowPrivateRepositoryForkingSettingPolicyValue() {
        return cursor.get(
                "allowPrivateRepositoryForkingSettingPolicyValue",
                ScalarType.enumeration(
                        EnterpriseAllowPrivateRepositoryForkingPolicyValue::fromWire,
                        EnterpriseAllowPrivateRepositoryForkingPolicyValue.ENTERPRISE_ORGANIZATIONS));
    }

    @Override
    public EnterpriseDefaultRepositoryPermissionSettingValue defaultRepositoryPermissionSetting() {
        return cursor.getRequired(
                "defaultRepositoryPermissionSetting",
                ScalarType.enumeration(
                        EnterpriseDefaultRepositoryPermissionSettingValue::fromWire,
                        EnterpriseDefaultRepositoryPermissionSettingValue.ADMIN));
    }

    @Override
    public <R> Page<R> defaultRepositoryPermissionSettingOrganizations(
            final DefaultRepositoryPermissionField value,
            final Paging paging,
            final EnterpriseOwnerInfoDefaultRepositoryPermissionSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(value, VALUE);
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "defaultRepositoryPermissionSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, "DefaultRepositoryPermissionField!", value));
    }

    @Override
    public <R> Page<R> defaultRepositoryPermissionSettingOrganizations(
            final DefaultRepositoryPermissionField value,
            final Paging paging,
            final Function<OrganizationSelector, R> selection) {
        return defaultRepositoryPermissionSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoDefaultRepositoryPermissionSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> domains(
            final Paging paging,
            final EnterpriseOwnerInfoDomainsFilter arguments,
            final Function<VerifiableDomainSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "domains",
                child -> selection.apply(new VerifiableDomainSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("isApproved", BOOLEAN, arguments.isApproved()),
                Argument.of("isVerified", BOOLEAN, arguments.isVerified()),
                Argument.of(
                        ORDER_BY,
                        "VerifiableDomainOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> domains(final Paging paging, final Function<VerifiableDomainSelector, R> selection) {
        return domains(paging, EnterpriseOwnerInfoDomainsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> enterpriseServerInstallations(
            final Paging paging,
            final EnterpriseOwnerInfoEnterpriseServerInstallationsFilter arguments,
            final Function<EnterpriseServerInstallationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "enterpriseServerInstallations",
                child -> selection.apply(new EnterpriseServerInstallationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("connectedOnly", BOOLEAN, arguments.connectedOnly()),
                Argument.of(
                        ORDER_BY,
                        "EnterpriseServerInstallationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> enterpriseServerInstallations(
            final Paging paging, final Function<EnterpriseServerInstallationSelector, R> selection) {
        return enterpriseServerInstallations(
                paging,
                EnterpriseOwnerInfoEnterpriseServerInstallationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> failedInvitations(
            final Paging paging,
            final EnterpriseOwnerInfoFailedInvitationsFilter arguments,
            final Function<OrganizationInvitationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "failedInvitations",
                child -> selection.apply(new OrganizationInvitationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> failedInvitations(
            final Paging paging, final Function<OrganizationInvitationSelector, R> selection) {
        return failedInvitations(
                paging,
                EnterpriseOwnerInfoFailedInvitationsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public IpAllowListEnabledSettingValue ipAllowListEnabledSetting() {
        return cursor.getRequired(
                "ipAllowListEnabledSetting",
                ScalarType.enumeration(
                        IpAllowListEnabledSettingValue::fromWire, IpAllowListEnabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> ipAllowListEntries(
            final Paging paging,
            final EnterpriseOwnerInfoIpAllowListEntriesFilter arguments,
            final Function<IpAllowListEntrySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "ipAllowListEntries",
                child -> selection.apply(new IpAllowListEntrySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IpAllowListEntryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> ipAllowListEntries(final Paging paging, final Function<IpAllowListEntrySelector, R> selection) {
        return ipAllowListEntries(
                paging,
                EnterpriseOwnerInfoIpAllowListEntriesFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public IpAllowListForInstalledAppsEnabledSettingValue ipAllowListForInstalledAppsEnabledSetting() {
        return cursor.getRequired(
                "ipAllowListForInstalledAppsEnabledSetting",
                ScalarType.enumeration(
                        IpAllowListForInstalledAppsEnabledSettingValue::fromWire,
                        IpAllowListForInstalledAppsEnabledSettingValue.DISABLED));
    }

    @Override
    public IpAllowListUserLevelEnforcementEnabledSettingValue ipAllowListUserLevelEnforcementEnabledSetting() {
        return cursor.getRequired(
                "ipAllowListUserLevelEnforcementEnabledSetting",
                ScalarType.enumeration(
                        IpAllowListUserLevelEnforcementEnabledSettingValue::fromWire,
                        IpAllowListUserLevelEnforcementEnabledSettingValue.DISABLED));
    }

    @Override
    public boolean isUpdatingDefaultRepositoryPermission() {
        return cursor.getRequired("isUpdatingDefaultRepositoryPermission", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isUpdatingTwoFactorRequirement() {
        return cursor.getRequired("isUpdatingTwoFactorRequirement", ScalarType.BOOLEAN);
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue membersCanChangeRepositoryVisibilitySetting() {
        return cursor.getRequired(
                "membersCanChangeRepositoryVisibilitySetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> membersCanChangeRepositoryVisibilitySettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoMembersCanChangeRepositoryVisibilitySettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "membersCanChangeRepositoryVisibilitySettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> membersCanChangeRepositoryVisibilitySettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return membersCanChangeRepositoryVisibilitySettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoMembersCanChangeRepositoryVisibilitySettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public @Nullable Boolean membersCanCreateInternalRepositoriesSetting() {
        return cursor.get("membersCanCreateInternalRepositoriesSetting", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean membersCanCreatePrivateRepositoriesSetting() {
        return cursor.get("membersCanCreatePrivateRepositoriesSetting", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean membersCanCreatePublicRepositoriesSetting() {
        return cursor.get("membersCanCreatePublicRepositoriesSetting", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable EnterpriseMembersCanCreateRepositoriesSettingValue membersCanCreateRepositoriesSetting() {
        return cursor.get(
                "membersCanCreateRepositoriesSetting",
                ScalarType.enumeration(
                        EnterpriseMembersCanCreateRepositoriesSettingValue::fromWire,
                        EnterpriseMembersCanCreateRepositoriesSettingValue.ALL));
    }

    @Override
    public <R> Page<R> membersCanCreateRepositoriesSettingOrganizations(
            final OrganizationMembersCanCreateRepositoriesSettingValue value,
            final Paging paging,
            final EnterpriseOwnerInfoMembersCanCreateRepositoriesSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(value, VALUE);
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "membersCanCreateRepositoriesSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, "OrganizationMembersCanCreateRepositoriesSettingValue!", value));
    }

    @Override
    public <R> Page<R> membersCanCreateRepositoriesSettingOrganizations(
            final OrganizationMembersCanCreateRepositoriesSettingValue value,
            final Paging paging,
            final Function<OrganizationSelector, R> selection) {
        return membersCanCreateRepositoriesSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoMembersCanCreateRepositoriesSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue membersCanDeleteIssuesSetting() {
        return cursor.getRequired(
                "membersCanDeleteIssuesSetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> membersCanDeleteIssuesSettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoMembersCanDeleteIssuesSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "membersCanDeleteIssuesSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> membersCanDeleteIssuesSettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return membersCanDeleteIssuesSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoMembersCanDeleteIssuesSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue membersCanDeleteRepositoriesSetting() {
        return cursor.getRequired(
                "membersCanDeleteRepositoriesSetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> membersCanDeleteRepositoriesSettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoMembersCanDeleteRepositoriesSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "membersCanDeleteRepositoriesSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> membersCanDeleteRepositoriesSettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return membersCanDeleteRepositoriesSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoMembersCanDeleteRepositoriesSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue membersCanInviteCollaboratorsSetting() {
        return cursor.getRequired(
                "membersCanInviteCollaboratorsSetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> membersCanInviteCollaboratorsSettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoMembersCanInviteCollaboratorsSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "membersCanInviteCollaboratorsSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> membersCanInviteCollaboratorsSettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return membersCanInviteCollaboratorsSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoMembersCanInviteCollaboratorsSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public EnterpriseMembersCanMakePurchasesSettingValue membersCanMakePurchasesSetting() {
        return cursor.getRequired(
                "membersCanMakePurchasesSetting",
                ScalarType.enumeration(
                        EnterpriseMembersCanMakePurchasesSettingValue::fromWire,
                        EnterpriseMembersCanMakePurchasesSettingValue.DISABLED));
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue membersCanUpdateProtectedBranchesSetting() {
        return cursor.getRequired(
                "membersCanUpdateProtectedBranchesSetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> membersCanUpdateProtectedBranchesSettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoMembersCanUpdateProtectedBranchesSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "membersCanUpdateProtectedBranchesSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> membersCanUpdateProtectedBranchesSettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return membersCanUpdateProtectedBranchesSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoMembersCanUpdateProtectedBranchesSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue membersCanViewDependencyInsightsSetting() {
        return cursor.getRequired(
                "membersCanViewDependencyInsightsSetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> membersCanViewDependencyInsightsSettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoMembersCanViewDependencyInsightsSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "membersCanViewDependencyInsightsSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> membersCanViewDependencyInsightsSettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return membersCanViewDependencyInsightsSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoMembersCanViewDependencyInsightsSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public NotificationRestrictionSettingValue notificationDeliveryRestrictionEnabledSetting() {
        return cursor.getRequired(
                "notificationDeliveryRestrictionEnabledSetting",
                ScalarType.enumeration(
                        NotificationRestrictionSettingValue::fromWire, NotificationRestrictionSettingValue.DISABLED));
    }

    @Override
    public <R> @Nullable R oidcProvider(final Function<OIDCProviderSelector, R> selection) {
        return cursor.object("oidcProvider", child -> selection.apply(new OIDCProviderSelectorImpl(child)));
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue organizationProjectsSetting() {
        return cursor.getRequired(
                "organizationProjectsSetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> organizationProjectsSettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoOrganizationProjectsSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "organizationProjectsSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> organizationProjectsSettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return organizationProjectsSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoOrganizationProjectsSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> outsideCollaborators(
            final Paging paging,
            final EnterpriseOwnerInfoOutsideCollaboratorsFilter arguments,
            final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "outsideCollaborators",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("hasTwoFactorEnabled", BOOLEAN, arguments.hasTwoFactorEnabled()),
                Argument.of("login", STRING, arguments.login()),
                Argument.of(
                        ORDER_BY,
                        ENTERPRISE_MEMBER_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(ORGANIZATION_LOGINS, STRING_2, arguments.organizationLogins()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of(
                        "twoFactorMethodSecurity",
                        "TwoFactorCredentialSecurityType",
                        arguments.twoFactorMethodSecurity()),
                Argument.of("visibility", "RepositoryVisibility", arguments.visibility()));
    }

    @Override
    public <R> Page<R> outsideCollaborators(final Paging paging, final Function<UserSelector, R> selection) {
        return outsideCollaborators(
                paging,
                EnterpriseOwnerInfoOutsideCollaboratorsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> pendingAdminInvitations(
            final Paging paging,
            final EnterpriseOwnerInfoPendingAdminInvitationsFilter arguments,
            final Function<EnterpriseAdministratorInvitationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pendingAdminInvitations",
                child -> selection.apply(new EnterpriseAdministratorInvitationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "EnterpriseAdministratorInvitationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of("role", "EnterpriseAdministratorRole", arguments.role()));
    }

    @Override
    public <R> Page<R> pendingAdminInvitations(
            final Paging paging, final Function<EnterpriseAdministratorInvitationSelector, R> selection) {
        return pendingAdminInvitations(
                paging,
                EnterpriseOwnerInfoPendingAdminInvitationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> pendingCollaboratorInvitations(
            final Paging paging,
            final EnterpriseOwnerInfoPendingCollaboratorInvitationsFilter arguments,
            final Function<RepositoryInvitationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pendingCollaboratorInvitations",
                child -> selection.apply(new RepositoryInvitationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "RepositoryInvitationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> pendingCollaboratorInvitations(
            final Paging paging, final Function<RepositoryInvitationSelector, R> selection) {
        return pendingCollaboratorInvitations(
                paging,
                EnterpriseOwnerInfoPendingCollaboratorInvitationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> pendingMemberInvitations(
            final Paging paging,
            final EnterpriseOwnerInfoPendingMemberInvitationsFilter arguments,
            final Function<OrganizationInvitationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pendingMemberInvitations",
                child -> selection.apply(new OrganizationInvitationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("invitationSource", "OrganizationInvitationSource", arguments.invitationSource()),
                Argument.of(ORGANIZATION_LOGINS, STRING_2, arguments.organizationLogins()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> pendingMemberInvitations(
            final Paging paging, final Function<OrganizationInvitationSelector, R> selection) {
        return pendingMemberInvitations(
                paging,
                EnterpriseOwnerInfoPendingMemberInvitationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> pendingUnaffiliatedMemberInvitations(
            final Paging paging,
            final EnterpriseOwnerInfoPendingUnaffiliatedMemberInvitationsFilter arguments,
            final Function<EnterpriseMemberInvitationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pendingUnaffiliatedMemberInvitations",
                child -> selection.apply(new EnterpriseMemberInvitationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "EnterpriseMemberInvitationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> pendingUnaffiliatedMemberInvitations(
            final Paging paging, final Function<EnterpriseMemberInvitationSelector, R> selection) {
        return pendingUnaffiliatedMemberInvitations(
                paging,
                EnterpriseOwnerInfoPendingUnaffiliatedMemberInvitationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue repositoryDeployKeySetting() {
        return cursor.getRequired(
                "repositoryDeployKeySetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> repositoryDeployKeySettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoRepositoryDeployKeySettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositoryDeployKeySettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> repositoryDeployKeySettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return repositoryDeployKeySettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoRepositoryDeployKeySettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public EnterpriseEnabledDisabledSettingValue repositoryProjectsSetting() {
        return cursor.getRequired(
                "repositoryProjectsSetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public <R> Page<R> repositoryProjectsSettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoRepositoryProjectsSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositoryProjectsSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> repositoryProjectsSettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return repositoryProjectsSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoRepositoryProjectsSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> @Nullable R samlIdentityProvider(final Function<EnterpriseIdentityProviderSelector, R> selection) {
        return cursor.object(
                "samlIdentityProvider", child -> selection.apply(new EnterpriseIdentityProviderSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> samlIdentityProviderSettingOrganizations(
            final IdentityProviderConfigurationState value,
            final Paging paging,
            final EnterpriseOwnerInfoSamlIdentityProviderSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(value, VALUE);
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "samlIdentityProviderSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, "IdentityProviderConfigurationState!", value));
    }

    @Override
    public <R> Page<R> samlIdentityProviderSettingOrganizations(
            final IdentityProviderConfigurationState value,
            final Paging paging,
            final Function<OrganizationSelector, R> selection) {
        return samlIdentityProviderSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoSamlIdentityProviderSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> supportEntitlements(
            final Paging paging,
            final EnterpriseOwnerInfoSupportEntitlementsFilter arguments,
            final Function<EnterpriseMemberSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "supportEntitlements",
                child -> selection.apply(new EnterpriseMemberSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ENTERPRISE_MEMBER_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> supportEntitlements(final Paging paging, final Function<EnterpriseMemberSelector, R> selection) {
        return supportEntitlements(
                paging,
                EnterpriseOwnerInfoSupportEntitlementsFilterBuilder.builder().build(),
                selection);
    }

    /**
     * @deprecated The Team Discussions feature is deprecated in favor of Organization Discussions. Follow the guide at
     *     https://github.blog/changelog/2023-02-08-sunset-notice-team-discussions/ to find a suitable replacement.
     *     Removal on 2024-07-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public EnterpriseEnabledDisabledSettingValue teamDiscussionsSetting() {
        return cursor.getRequired(
                "teamDiscussionsSetting",
                ScalarType.enumeration(
                        EnterpriseEnabledDisabledSettingValue::fromWire,
                        EnterpriseEnabledDisabledSettingValue.DISABLED));
    }

    @Override
    public EnterpriseDisallowedMethodsSettingValue twoFactorDisallowedMethodsSetting() {
        return cursor.getRequired(
                "twoFactorDisallowedMethodsSetting",
                ScalarType.enumeration(
                        EnterpriseDisallowedMethodsSettingValue::fromWire,
                        EnterpriseDisallowedMethodsSettingValue.INSECURE));
    }

    @Override
    public EnterpriseEnabledSettingValue twoFactorRequiredSetting() {
        return cursor.getRequired(
                "twoFactorRequiredSetting",
                ScalarType.enumeration(EnterpriseEnabledSettingValue::fromWire, EnterpriseEnabledSettingValue.ENABLED));
    }

    @Override
    public <R> Page<R> twoFactorRequiredSettingOrganizations(
            final boolean value,
            final Paging paging,
            final EnterpriseOwnerInfoTwoFactorRequiredSettingOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "twoFactorRequiredSettingOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        ORGANIZATION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(VALUE, BOOLEAN_2, value));
    }

    @Override
    public <R> Page<R> twoFactorRequiredSettingOrganizations(
            final boolean value, final Paging paging, final Function<OrganizationSelector, R> selection) {
        return twoFactorRequiredSettingOrganizations(
                value,
                paging,
                EnterpriseOwnerInfoTwoFactorRequiredSettingOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }
}
