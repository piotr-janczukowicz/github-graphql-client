package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DefaultRepositoryPermissionField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorRole;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAllowPrivateRepositoryForkingPolicyValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseDefaultRepositoryPermissionSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseDisallowedMethodsSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseEnabledDisabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberInvitationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberInvitationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMembersCanCreateRepositoriesSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMembersCanMakePurchasesSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoAdminsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoAllowPrivateRepositoryForkingSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoDefaultRepositoryPermissionSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoDomainsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoEnterpriseServerInstallationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoFailedInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoIpAllowListEntriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanChangeRepositoryVisibilitySettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanCreateRepositoriesSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanDeleteIssuesSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanDeleteRepositoriesSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanInviteCollaboratorsSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanUpdateProtectedBranchesSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoMembersCanViewDependencyInsightsSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoOrganizationProjectsSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoOutsideCollaboratorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingAdminInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingCollaboratorInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingMemberInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoPendingUnaffiliatedMemberInvitationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoRepositoryDeployKeySettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoRepositoryProjectsSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoSamlIdentityProviderSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoSupportEntitlementsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseOwnerInfoTwoFactorRequiredSettingOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IdentityProviderConfigurationState;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListForInstalledAppsEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListUserLevelEnforcementEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.NotificationRestrictionSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.OIDCProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSource;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMembersCanCreateRepositoriesSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInvitationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInvitationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibility;
import io.github.piotr_janczukowicz.github.graphql.model.SamlDigestAlgorithm;
import io.github.piotr_janczukowicz.github.graphql.model.TwoFactorCredentialSecurityType;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class EnterpriseOwnerInfoSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"admins\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"affiliatedUsersWithTwoFactorDisabled\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"affiliatedUsersWithTwoFactorDisabledExist\":true" + ","
            + "\"allowPrivateRepositoryForkingSetting\":\"DISABLED\"" + ","
            + "\"allowPrivateRepositoryForkingSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"allowPrivateRepositoryForkingSettingPolicyValue\":\"ENTERPRISE_ORGANIZATIONS\"" + ","
            + "\"defaultRepositoryPermissionSetting\":\"ADMIN\"" + ","
            + "\"defaultRepositoryPermissionSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"domains\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"enterpriseServerInstallations\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"failedInvitations\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"ipAllowListEnabledSetting\":\"DISABLED\"" + ","
            + "\"ipAllowListEntries\":{\"nodes\": [{\"allowListValue\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"ipAllowListForInstalledAppsEnabledSetting\":\"DISABLED\"" + ","
            + "\"ipAllowListUserLevelEnforcementEnabledSetting\":\"DISABLED\"" + ","
            + "\"isUpdatingDefaultRepositoryPermission\":true" + "," + "\"isUpdatingTwoFactorRequirement\":true" + ","
            + "\"membersCanChangeRepositoryVisibilitySetting\":\"DISABLED\"" + ","
            + "\"membersCanChangeRepositoryVisibilitySettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"membersCanCreateInternalRepositoriesSetting\":true" + ","
            + "\"membersCanCreatePrivateRepositoriesSetting\":true" + ","
            + "\"membersCanCreatePublicRepositoriesSetting\":true" + ","
            + "\"membersCanCreateRepositoriesSetting\":\"ALL\"" + ","
            + "\"membersCanCreateRepositoriesSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"membersCanDeleteIssuesSetting\":\"DISABLED\"" + ","
            + "\"membersCanDeleteIssuesSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"membersCanDeleteRepositoriesSetting\":\"DISABLED\"" + ","
            + "\"membersCanDeleteRepositoriesSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"membersCanInviteCollaboratorsSetting\":\"DISABLED\"" + ","
            + "\"membersCanInviteCollaboratorsSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"membersCanMakePurchasesSetting\":\"DISABLED\"" + ","
            + "\"membersCanUpdateProtectedBranchesSetting\":\"DISABLED\"" + ","
            + "\"membersCanUpdateProtectedBranchesSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"membersCanViewDependencyInsightsSetting\":\"DISABLED\"" + ","
            + "\"membersCanViewDependencyInsightsSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"notificationDeliveryRestrictionEnabledSetting\":\"DISABLED\"" + ","
            + "\"oidcProvider\":{\"id\": \"x\"}" + "," + "\"organizationProjectsSetting\":\"DISABLED\"" + ","
            + "\"organizationProjectsSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"outsideCollaborators\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pendingAdminInvitations\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pendingCollaboratorInvitations\":{\"nodes\": [{\"email\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pendingMemberInvitations\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pendingUnaffiliatedMemberInvitations\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repositoryDeployKeySetting\":\"DISABLED\"" + ","
            + "\"repositoryDeployKeySettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repositoryProjectsSetting\":\"DISABLED\"" + ","
            + "\"repositoryProjectsSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"samlIdentityProvider\":{\"digestMethod\": \"SHA1\"}" + ","
            + "\"samlIdentityProviderSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"supportEntitlements\":{\"nodes\": [{\"__typename\": \"EnterpriseUserAccount\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"teamDiscussionsSetting\":\"DISABLED\"" + ","
            + "\"twoFactorDisallowedMethodsSetting\":\"INSECURE\"" + "," + "\"twoFactorRequiredSetting\":\"ENABLED\""
            + ","
            + "\"twoFactorRequiredSettingOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "}";

    private static List<Object> readWithArguments(final EnterpriseOwnerInfoSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.admins(
                Paging.first(1),
                EnterpriseOwnerInfoAdminsFilterBuilder.builder()
                        .hasTwoFactorEnabled(true)
                        .orderBy(EnterpriseMemberOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseMemberOrderField.CREATED_AT)
                                .build())
                        .organizationLogins(List.of("x"))
                        .query("x")
                        .role(EnterpriseAdministratorRole.BILLING_MANAGER)
                        .twoFactorMethodSecurity(TwoFactorCredentialSecurityType.DISABLED)
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.affiliatedUsersWithTwoFactorDisabled(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.affiliatedUsersWithTwoFactorDisabledExist());
        values.add(selector.allowPrivateRepositoryForkingSetting());
        values.add(selector.allowPrivateRepositoryForkingSettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoAllowPrivateRepositoryForkingSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.allowPrivateRepositoryForkingSettingPolicyValue());
        values.add(selector.defaultRepositoryPermissionSetting());
        values.add(selector.defaultRepositoryPermissionSettingOrganizations(
                DefaultRepositoryPermissionField.ADMIN,
                Paging.first(1),
                EnterpriseOwnerInfoDefaultRepositoryPermissionSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.domains(
                Paging.first(1),
                EnterpriseOwnerInfoDomainsFilterBuilder.builder()
                        .isApproved(true)
                        .isVerified(true)
                        .orderBy(VerifiableDomainOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(VerifiableDomainOrderField.CREATED_AT)
                                .build())
                        .build(),
                VerifiableDomainSelector::createdAt));
        values.add(selector.enterpriseServerInstallations(
                Paging.first(1),
                EnterpriseOwnerInfoEnterpriseServerInstallationsFilterBuilder.builder()
                        .connectedOnly(true)
                        .orderBy(EnterpriseServerInstallationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseServerInstallationOrderField.CREATED_AT)
                                .build())
                        .build(),
                EnterpriseServerInstallationSelector::createdAt));
        values.add(selector.failedInvitations(
                Paging.first(1),
                EnterpriseOwnerInfoFailedInvitationsFilterBuilder.builder()
                        .query("x")
                        .build(),
                OrganizationInvitationSelector::createdAt));
        values.add(selector.ipAllowListEnabledSetting());
        values.add(selector.ipAllowListEntries(
                Paging.first(1),
                EnterpriseOwnerInfoIpAllowListEntriesFilterBuilder.builder()
                        .orderBy(IpAllowListEntryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IpAllowListEntryOrderField.ALLOW_LIST_VALUE)
                                .build())
                        .build(),
                IpAllowListEntrySelector::allowListValue));
        values.add(selector.ipAllowListForInstalledAppsEnabledSetting());
        values.add(selector.ipAllowListUserLevelEnforcementEnabledSetting());
        values.add(selector.isUpdatingDefaultRepositoryPermission());
        values.add(selector.isUpdatingTwoFactorRequirement());
        values.add(selector.membersCanChangeRepositoryVisibilitySetting());
        values.add(selector.membersCanChangeRepositoryVisibilitySettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoMembersCanChangeRepositoryVisibilitySettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanCreateInternalRepositoriesSetting());
        values.add(selector.membersCanCreatePrivateRepositoriesSetting());
        values.add(selector.membersCanCreatePublicRepositoriesSetting());
        values.add(selector.membersCanCreateRepositoriesSetting());
        values.add(selector.membersCanCreateRepositoriesSettingOrganizations(
                OrganizationMembersCanCreateRepositoriesSettingValue.ALL,
                Paging.first(1),
                EnterpriseOwnerInfoMembersCanCreateRepositoriesSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanDeleteIssuesSetting());
        values.add(selector.membersCanDeleteIssuesSettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoMembersCanDeleteIssuesSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanDeleteRepositoriesSetting());
        values.add(selector.membersCanDeleteRepositoriesSettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoMembersCanDeleteRepositoriesSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanInviteCollaboratorsSetting());
        values.add(selector.membersCanInviteCollaboratorsSettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoMembersCanInviteCollaboratorsSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanMakePurchasesSetting());
        values.add(selector.membersCanUpdateProtectedBranchesSetting());
        values.add(selector.membersCanUpdateProtectedBranchesSettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoMembersCanUpdateProtectedBranchesSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanViewDependencyInsightsSetting());
        values.add(selector.membersCanViewDependencyInsightsSettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoMembersCanViewDependencyInsightsSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.notificationDeliveryRestrictionEnabledSetting());
        values.add(selector.oidcProvider(OIDCProviderSelector::id));
        values.add(selector.organizationProjectsSetting());
        values.add(selector.organizationProjectsSettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoOrganizationProjectsSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.outsideCollaborators(
                Paging.first(1),
                EnterpriseOwnerInfoOutsideCollaboratorsFilterBuilder.builder()
                        .hasTwoFactorEnabled(true)
                        .login("x")
                        .orderBy(EnterpriseMemberOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseMemberOrderField.CREATED_AT)
                                .build())
                        .organizationLogins(List.of("x"))
                        .query("x")
                        .twoFactorMethodSecurity(TwoFactorCredentialSecurityType.DISABLED)
                        .visibility(RepositoryVisibility.INTERNAL)
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.pendingAdminInvitations(
                Paging.first(1),
                EnterpriseOwnerInfoPendingAdminInvitationsFilterBuilder.builder()
                        .orderBy(EnterpriseAdministratorInvitationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseAdministratorInvitationOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .role(EnterpriseAdministratorRole.BILLING_MANAGER)
                        .build(),
                EnterpriseAdministratorInvitationSelector::createdAt));
        values.add(selector.pendingCollaboratorInvitations(
                Paging.first(1),
                EnterpriseOwnerInfoPendingCollaboratorInvitationsFilterBuilder.builder()
                        .orderBy(RepositoryInvitationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryInvitationOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                RepositoryInvitationSelector::email));
        values.add(selector.pendingMemberInvitations(
                Paging.first(1),
                EnterpriseOwnerInfoPendingMemberInvitationsFilterBuilder.builder()
                        .invitationSource(OrganizationInvitationSource.ENTERPRISE_ORGANIZATION_CREATION)
                        .organizationLogins(List.of("x"))
                        .query("x")
                        .build(),
                OrganizationInvitationSelector::createdAt));
        values.add(selector.pendingUnaffiliatedMemberInvitations(
                Paging.first(1),
                EnterpriseOwnerInfoPendingUnaffiliatedMemberInvitationsFilterBuilder.builder()
                        .orderBy(EnterpriseMemberInvitationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseMemberInvitationOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                EnterpriseMemberInvitationSelector::createdAt));
        values.add(selector.repositoryDeployKeySetting());
        values.add(selector.repositoryDeployKeySettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoRepositoryDeployKeySettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.repositoryProjectsSetting());
        values.add(selector.repositoryProjectsSettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoRepositoryProjectsSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.samlIdentityProvider(EnterpriseIdentityProviderSelector::digestMethod));
        values.add(selector.samlIdentityProviderSettingOrganizations(
                IdentityProviderConfigurationState.CONFIGURED,
                Paging.first(1),
                EnterpriseOwnerInfoSamlIdentityProviderSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.supportEntitlements(
                Paging.first(1),
                EnterpriseOwnerInfoSupportEntitlementsFilterBuilder.builder()
                        .orderBy(EnterpriseMemberOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseMemberOrderField.CREATED_AT)
                                .build())
                        .build(),
                child -> child.on(EnterpriseUserAccountSelector.class, EnterpriseUserAccountSelector::avatarUrl)));
        values.add(selector.teamDiscussionsSetting());
        values.add(selector.twoFactorDisallowedMethodsSetting());
        values.add(selector.twoFactorRequiredSetting());
        values.add(selector.twoFactorRequiredSettingOrganizations(
                true,
                Paging.first(1),
                EnterpriseOwnerInfoTwoFactorRequiredSettingOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        return values;
    }

    private static List<Object> readWithoutArguments(final EnterpriseOwnerInfoSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.admins(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.allowPrivateRepositoryForkingSettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.defaultRepositoryPermissionSettingOrganizations(
                DefaultRepositoryPermissionField.ADMIN, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.domains(Paging.first(1), VerifiableDomainSelector::createdAt));
        values.add(selector.enterpriseServerInstallations(
                Paging.first(1), EnterpriseServerInstallationSelector::createdAt));
        values.add(selector.failedInvitations(Paging.first(1), OrganizationInvitationSelector::createdAt));
        values.add(selector.ipAllowListEntries(Paging.first(1), IpAllowListEntrySelector::allowListValue));
        values.add(selector.membersCanChangeRepositoryVisibilitySettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanCreateRepositoriesSettingOrganizations(
                OrganizationMembersCanCreateRepositoriesSettingValue.ALL,
                Paging.first(1),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanDeleteIssuesSettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanDeleteRepositoriesSettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanInviteCollaboratorsSettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanUpdateProtectedBranchesSettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.membersCanViewDependencyInsightsSettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.organizationProjectsSettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.outsideCollaborators(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.pendingAdminInvitations(
                Paging.first(1), EnterpriseAdministratorInvitationSelector::createdAt));
        values.add(selector.pendingCollaboratorInvitations(Paging.first(1), RepositoryInvitationSelector::email));
        values.add(selector.pendingMemberInvitations(Paging.first(1), OrganizationInvitationSelector::createdAt));
        values.add(selector.pendingUnaffiliatedMemberInvitations(
                Paging.first(1), EnterpriseMemberInvitationSelector::createdAt));
        values.add(selector.repositoryDeployKeySettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.repositoryProjectsSettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        values.add(selector.samlIdentityProviderSettingOrganizations(
                IdentityProviderConfigurationState.CONFIGURED,
                Paging.first(1),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.supportEntitlements(
                Paging.first(1),
                child -> child.on(EnterpriseUserAccountSelector.class, EnterpriseUserAccountSelector::avatarUrl)));
        values.add(selector.twoFactorRequiredSettingOrganizations(
                true, Paging.first(1), OrganizationSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseOwnerInfoSelectorImpl(new RecordingCursor(root)));
        final EnterpriseOwnerInfoSelectorImpl selector =
                new EnterpriseOwnerInfoSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        true,
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        EnterpriseAllowPrivateRepositoryForkingPolicyValue.ENTERPRISE_ORGANIZATIONS,
                        EnterpriseDefaultRepositoryPermissionSettingValue.ADMIN,
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        IpAllowListEnabledSettingValue.DISABLED,
                        new Page<>(List.of("x"), false, null),
                        IpAllowListForInstalledAppsEnabledSettingValue.DISABLED,
                        IpAllowListUserLevelEnforcementEnabledSettingValue.DISABLED,
                        true,
                        true,
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        true,
                        true,
                        true,
                        EnterpriseMembersCanCreateRepositoriesSettingValue.ALL,
                        new Page<>(List.of(true), false, null),
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        EnterpriseMembersCanMakePurchasesSettingValue.DISABLED,
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        NotificationRestrictionSettingValue.DISABLED,
                        "x",
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        new Page<>(List.of(true), false, null),
                        SamlDigestAlgorithm.SHA1,
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        EnterpriseEnabledDisabledSettingValue.DISABLED,
                        EnterpriseDisallowedMethodsSettingValue.INSECURE,
                        EnterpriseEnabledSettingValue.ENABLED,
                        new Page<>(List.of(true), false, null));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new EnterpriseOwnerInfoSelectorImpl(new RecordingCursor(root)));
        final EnterpriseOwnerInfoSelectorImpl selector =
                new EnterpriseOwnerInfoSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null));
    }
}
