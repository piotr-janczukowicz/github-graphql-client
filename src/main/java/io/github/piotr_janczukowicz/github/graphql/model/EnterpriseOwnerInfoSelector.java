package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code EnterpriseOwnerInfo}. */
public interface EnterpriseOwnerInfoSelector {

    <R> Page<R> admins(Paging paging, EnterpriseOwnerInfoAdminsFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> admins(Paging paging, Function<UserSelector, R> selection);

    <R> Page<R> affiliatedUsersWithTwoFactorDisabled(Paging paging, Function<UserSelector, R> selection);

    boolean affiliatedUsersWithTwoFactorDisabledExist();

    EnterpriseEnabledDisabledSettingValue allowPrivateRepositoryForkingSetting();

    <R> Page<R> allowPrivateRepositoryForkingSettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoAllowPrivateRepositoryForkingSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> allowPrivateRepositoryForkingSettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    @Nullable EnterpriseAllowPrivateRepositoryForkingPolicyValue allowPrivateRepositoryForkingSettingPolicyValue();

    EnterpriseDefaultRepositoryPermissionSettingValue defaultRepositoryPermissionSetting();

    <R> Page<R> defaultRepositoryPermissionSettingOrganizations(
            DefaultRepositoryPermissionField value,
            Paging paging,
            EnterpriseOwnerInfoDefaultRepositoryPermissionSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> defaultRepositoryPermissionSettingOrganizations(
            DefaultRepositoryPermissionField value, Paging paging, Function<OrganizationSelector, R> selection);

    <R> Page<R> domains(
            Paging paging, EnterpriseOwnerInfoDomainsFilter arguments, Function<VerifiableDomainSelector, R> selection);

    <R> Page<R> domains(Paging paging, Function<VerifiableDomainSelector, R> selection);

    <R> Page<R> enterpriseServerInstallations(
            Paging paging,
            EnterpriseOwnerInfoEnterpriseServerInstallationsFilter arguments,
            Function<EnterpriseServerInstallationSelector, R> selection);

    <R> Page<R> enterpriseServerInstallations(
            Paging paging, Function<EnterpriseServerInstallationSelector, R> selection);

    <R> Page<R> failedInvitations(
            Paging paging,
            EnterpriseOwnerInfoFailedInvitationsFilter arguments,
            Function<OrganizationInvitationSelector, R> selection);

    <R> Page<R> failedInvitations(Paging paging, Function<OrganizationInvitationSelector, R> selection);

    IpAllowListEnabledSettingValue ipAllowListEnabledSetting();

    <R> Page<R> ipAllowListEntries(
            Paging paging,
            EnterpriseOwnerInfoIpAllowListEntriesFilter arguments,
            Function<IpAllowListEntrySelector, R> selection);

    <R> Page<R> ipAllowListEntries(Paging paging, Function<IpAllowListEntrySelector, R> selection);

    IpAllowListForInstalledAppsEnabledSettingValue ipAllowListForInstalledAppsEnabledSetting();

    IpAllowListUserLevelEnforcementEnabledSettingValue ipAllowListUserLevelEnforcementEnabledSetting();

    boolean isUpdatingDefaultRepositoryPermission();

    boolean isUpdatingTwoFactorRequirement();

    EnterpriseEnabledDisabledSettingValue membersCanChangeRepositoryVisibilitySetting();

    <R> Page<R> membersCanChangeRepositoryVisibilitySettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoMembersCanChangeRepositoryVisibilitySettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> membersCanChangeRepositoryVisibilitySettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    @Nullable Boolean membersCanCreateInternalRepositoriesSetting();

    @Nullable Boolean membersCanCreatePrivateRepositoriesSetting();

    @Nullable Boolean membersCanCreatePublicRepositoriesSetting();

    @Nullable EnterpriseMembersCanCreateRepositoriesSettingValue membersCanCreateRepositoriesSetting();

    <R> Page<R> membersCanCreateRepositoriesSettingOrganizations(
            OrganizationMembersCanCreateRepositoriesSettingValue value,
            Paging paging,
            EnterpriseOwnerInfoMembersCanCreateRepositoriesSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> membersCanCreateRepositoriesSettingOrganizations(
            OrganizationMembersCanCreateRepositoriesSettingValue value,
            Paging paging,
            Function<OrganizationSelector, R> selection);

    EnterpriseEnabledDisabledSettingValue membersCanDeleteIssuesSetting();

    <R> Page<R> membersCanDeleteIssuesSettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoMembersCanDeleteIssuesSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> membersCanDeleteIssuesSettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    EnterpriseEnabledDisabledSettingValue membersCanDeleteRepositoriesSetting();

    <R> Page<R> membersCanDeleteRepositoriesSettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoMembersCanDeleteRepositoriesSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> membersCanDeleteRepositoriesSettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    EnterpriseEnabledDisabledSettingValue membersCanInviteCollaboratorsSetting();

    <R> Page<R> membersCanInviteCollaboratorsSettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoMembersCanInviteCollaboratorsSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> membersCanInviteCollaboratorsSettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    EnterpriseMembersCanMakePurchasesSettingValue membersCanMakePurchasesSetting();

    EnterpriseEnabledDisabledSettingValue membersCanUpdateProtectedBranchesSetting();

    <R> Page<R> membersCanUpdateProtectedBranchesSettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoMembersCanUpdateProtectedBranchesSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> membersCanUpdateProtectedBranchesSettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    EnterpriseEnabledDisabledSettingValue membersCanViewDependencyInsightsSetting();

    <R> Page<R> membersCanViewDependencyInsightsSettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoMembersCanViewDependencyInsightsSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> membersCanViewDependencyInsightsSettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    NotificationRestrictionSettingValue notificationDeliveryRestrictionEnabledSetting();

    <R> @Nullable R oidcProvider(Function<OIDCProviderSelector, R> selection);

    EnterpriseEnabledDisabledSettingValue organizationProjectsSetting();

    <R> Page<R> organizationProjectsSettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoOrganizationProjectsSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> organizationProjectsSettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    <R> Page<R> outsideCollaborators(
            Paging paging,
            EnterpriseOwnerInfoOutsideCollaboratorsFilter arguments,
            Function<UserSelector, R> selection);

    <R> Page<R> outsideCollaborators(Paging paging, Function<UserSelector, R> selection);

    <R> Page<R> pendingAdminInvitations(
            Paging paging,
            EnterpriseOwnerInfoPendingAdminInvitationsFilter arguments,
            Function<EnterpriseAdministratorInvitationSelector, R> selection);

    <R> Page<R> pendingAdminInvitations(
            Paging paging, Function<EnterpriseAdministratorInvitationSelector, R> selection);

    <R> Page<R> pendingCollaboratorInvitations(
            Paging paging,
            EnterpriseOwnerInfoPendingCollaboratorInvitationsFilter arguments,
            Function<RepositoryInvitationSelector, R> selection);

    <R> Page<R> pendingCollaboratorInvitations(Paging paging, Function<RepositoryInvitationSelector, R> selection);

    <R> Page<R> pendingMemberInvitations(
            Paging paging,
            EnterpriseOwnerInfoPendingMemberInvitationsFilter arguments,
            Function<OrganizationInvitationSelector, R> selection);

    <R> Page<R> pendingMemberInvitations(Paging paging, Function<OrganizationInvitationSelector, R> selection);

    <R> Page<R> pendingUnaffiliatedMemberInvitations(
            Paging paging,
            EnterpriseOwnerInfoPendingUnaffiliatedMemberInvitationsFilter arguments,
            Function<EnterpriseMemberInvitationSelector, R> selection);

    <R> Page<R> pendingUnaffiliatedMemberInvitations(
            Paging paging, Function<EnterpriseMemberInvitationSelector, R> selection);

    EnterpriseEnabledDisabledSettingValue repositoryDeployKeySetting();

    <R> Page<R> repositoryDeployKeySettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoRepositoryDeployKeySettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> repositoryDeployKeySettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    EnterpriseEnabledDisabledSettingValue repositoryProjectsSetting();

    <R> Page<R> repositoryProjectsSettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoRepositoryProjectsSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> repositoryProjectsSettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);

    <R> @Nullable R samlIdentityProvider(Function<EnterpriseIdentityProviderSelector, R> selection);

    <R> Page<R> samlIdentityProviderSettingOrganizations(
            IdentityProviderConfigurationState value,
            Paging paging,
            EnterpriseOwnerInfoSamlIdentityProviderSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> samlIdentityProviderSettingOrganizations(
            IdentityProviderConfigurationState value, Paging paging, Function<OrganizationSelector, R> selection);

    <R> Page<R> supportEntitlements(
            Paging paging,
            EnterpriseOwnerInfoSupportEntitlementsFilter arguments,
            Function<EnterpriseMemberSelector, R> selection);

    <R> Page<R> supportEntitlements(Paging paging, Function<EnterpriseMemberSelector, R> selection);

    /**
     * @deprecated The Team Discussions feature is deprecated in favor of Organization Discussions. Follow the guide at
     *     https://github.blog/changelog/2023-02-08-sunset-notice-team-discussions/ to find a suitable replacement.
     *     Removal on 2024-07-01 UTC.
     */
    @Deprecated(forRemoval = true)
    EnterpriseEnabledDisabledSettingValue teamDiscussionsSetting();

    EnterpriseDisallowedMethodsSettingValue twoFactorDisallowedMethodsSetting();

    EnterpriseEnabledSettingValue twoFactorRequiredSetting();

    <R> Page<R> twoFactorRequiredSettingOrganizations(
            boolean value,
            Paging paging,
            EnterpriseOwnerInfoTwoFactorRequiredSettingOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> twoFactorRequiredSettingOrganizations(
            boolean value, Paging paging, Function<OrganizationSelector, R> selection);
}
