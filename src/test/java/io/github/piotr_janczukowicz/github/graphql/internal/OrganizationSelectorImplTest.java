package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AnnouncementBannerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AuditLogOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionState;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListForInstalledAppsEnabledSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeColor;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.MannequinOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.MannequinOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.MannequinSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MembersCanDeleteReposClearAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MigrationState;
import io.github.piotr_janczukowicz.github.graphql.model.NotificationRestrictionSettingValue;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrgEnterpriseOwnerOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrgEnterpriseOwnerOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAnyPinnableItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAuditLogFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationDomainsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationEnterpriseOwnersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInnersourceVulnerabilitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIpAllowListEntriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIssueFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIssueTypesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationLifetimeReceivedSponsorshipValuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMannequinsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMemberStatusesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPackagesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPinnableItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPinnedItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationProjectsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryDiscussionCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryDiscussionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRepositoryMigrationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRulesetFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationRulesetsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsoringFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorsActivitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipForViewerAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipForViewerAsSponsorableFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipNewslettersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipsAsMaintainerFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSponsorshipsAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationTeamsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationTotalSponsorshipAmountAsSponsorInCentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PackageOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageType;
import io.github.piotr_janczukowicz.github.graphql.model.PinnableItemType;
import io.github.piotr_janczukowicz.github.graphql.model.ProfileItemShowcaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectState;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2PermissionLevel;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryAffiliation;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionAbilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMigrationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMigrationOrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMigrationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMigrationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetTarget;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibility;
import io.github.piotr_janczukowicz.github.graphql.model.RoleInOrganization;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryEcosystem;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisorySeverity;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilityOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilityOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityAction;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityPeriod;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamNotificationSetting;
import io.github.piotr_janczukowicz.github.graphql.model.TeamOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.TeamPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.TeamRole;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.UserStatusSelector;
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
class OrganizationSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"announcementBanner\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}"
            + "," + "\"anyPinnableItems\":true" + "," + "\"archivedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"auditLog\":{\"nodes\": [{\"__typename\": \"MembersCanDeleteReposClearAuditEntry\", \"enterpriseResourcePath\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"avatarUrl\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1"
            + "," + "\"description\":\"x\"" + "," + "\"descriptionHTML\":\"x\"" + ","
            + "\"domains\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"email\":\"x\"" + ","
            + "\"enterpriseOwners\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"estimatedNextSponsorsPayoutInCents\":1" + "," + "\"hasSponsorsListing\":true" + ","
            + "\"id\":\"x\"" + ","
            + "\"innersourceVulnerabilities\":{\"nodes\": [{\"severity\": \"CRITICAL\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"interactionAbility\":{\"expiresAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"ipAllowListEnabledSetting\":\"DISABLED\"" + ","
            + "\"ipAllowListEntries\":{\"nodes\": [{\"allowListValue\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"ipAllowListForInstalledAppsEnabledSetting\":\"DISABLED\"" + "," + "\"isSponsoredBy\":true" + ","
            + "\"isSponsoringViewer\":true" + "," + "\"isVerified\":true" + ","
            + "\"issueFields\":{\"nodes\": [{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"issueTypes\":{\"nodes\": [{\"color\": \"BLUE\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"itemShowcase\":{\"hasPinnedItems\": true}" + ","
            + "\"lifetimeReceivedSponsorshipValues\":{\"nodes\": [{\"amountInCents\": 1}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"location\":\"x\"" + "," + "\"login\":\"x\"" + ","
            + "\"mannequins\":{\"nodes\": [{\"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"memberStatuses\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"membersCanForkPrivateRepositories\":true" + ","
            + "\"membersWithRole\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"monthlyEstimatedSponsorsIncomeInCents\":1" + "," + "\"name\":\"x\"" + ","
            + "\"newTeamResourcePath\":\"x\"" + "," + "\"newTeamUrl\":\"x\"" + ","
            + "\"notificationDeliveryRestrictionEnabledSetting\":\"DISABLED\"" + ","
            + "\"organizationBillingEmail\":\"x\"" + ","
            + "\"packages\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pendingMembers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pinnableItems\":{\"nodes\": [{\"__typename\": \"Gist\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pinnedIssueFields\":{\"nodes\": [{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pinnedItems\":{\"nodes\": [{\"__typename\": \"Gist\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"pinnedItemsRemaining\":1" + "," + "\"project\":{\"closed\": true}" + ","
            + "\"projectV2\":{\"closed\": true}" + ","
            + "\"projects\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"projectsResourcePath\":\"x\"" + "," + "\"projectsUrl\":\"x\"" + ","
            + "\"projectsV2\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"recentProjects\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"repositories\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + ","
            + "\"repositoryCustomProperties\":{\"nodes\": [{\"allowedValues\": [\"x\"]}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repositoryCustomProperty\":{\"allowedValues\": [\"x\"]}" + ","
            + "\"repositoryDiscussionComments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"repositoryDiscussions\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"repositoryMigrations\":{\"nodes\": [{\"continueOnError\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"requiresTwoFactorAuthentication\":true" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"ruleset\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"rulesets\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"samlIdentityProvider\":{\"digestMethod\": \"x\"}" + ","
            + "\"sponsoring\":{\"nodes\": [{\"__typename\": \"Organization\", \"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsors\":{\"nodes\": [{\"__typename\": \"Organization\", \"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorsActivities\":{\"nodes\": [{\"action\": \"CANCELLED_SPONSORSHIP\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"sponsorsListing\":{\"billingCountryOrRegion\": \"x\"}" + ","
            + "\"sponsorshipForViewerAsSponsor\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"sponsorshipForViewerAsSponsorable\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"sponsorshipNewsletters\":{\"nodes\": [{\"body\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorshipsAsMaintainer\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorshipsAsSponsor\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"team\":{\"avatarUrl\": \"x\"}" + ","
            + "\"teams\":{\"nodes\": [{\"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"teamsResourcePath\":\"x\"" + "," + "\"teamsUrl\":\"x\"" + ","
            + "\"totalSponsorshipAmountAsSponsorInCents\":1" + "," + "\"twitterUsername\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "," + "\"viewerCanAdminister\":true"
            + "," + "\"viewerCanChangePinnedItems\":true" + "," + "\"viewerCanCreateProjects\":true" + ","
            + "\"viewerCanCreateRepositories\":true" + "," + "\"viewerCanCreateTeams\":true" + ","
            + "\"viewerCanSponsor\":true" + "," + "\"viewerIsAMember\":true" + "," + "\"viewerIsFollowing\":true" + ","
            + "\"viewerIsSponsoring\":true" + "," + "\"webCommitSignoffRequired\":true" + "," + "\"websiteUrl\":\"x\""
            + "}";

    private static List<Object> readWithArguments(final OrganizationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.announcementBanner(AnnouncementBannerSelector::createdAt));
        values.add(selector.anyPinnableItems(OrganizationAnyPinnableItemsFilterBuilder.builder()
                .type(PinnableItemType.GIST)
                .build()));
        values.add(selector.archivedAt());
        values.add(selector.auditLog(
                Paging.first(1),
                OrganizationAuditLogFilterBuilder.builder()
                        .orderBy(AuditLogOrderBuilder.builder().build())
                        .query("x")
                        .build(),
                child -> child.on(
                        MembersCanDeleteReposClearAuditEntrySelector.class,
                        MembersCanDeleteReposClearAuditEntrySelector::enterpriseResourcePath)));
        values.add(selector.avatarUrl(
                OrganizationAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.description());
        values.add(selector.descriptionHTML());
        values.add(selector.domains(
                Paging.first(1),
                OrganizationDomainsFilterBuilder.builder()
                        .isApproved(true)
                        .isVerified(true)
                        .orderBy(VerifiableDomainOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(VerifiableDomainOrderField.CREATED_AT)
                                .build())
                        .build(),
                VerifiableDomainSelector::createdAt));
        values.add(selector.email());
        values.add(selector.enterpriseOwners(
                Paging.first(1),
                OrganizationEnterpriseOwnersFilterBuilder.builder()
                        .orderBy(OrgEnterpriseOwnerOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrgEnterpriseOwnerOrderField.LOGIN)
                                .build())
                        .organizationRole(RoleInOrganization.DIRECT_MEMBER)
                        .query("x")
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.estimatedNextSponsorsPayoutInCents());
        values.add(selector.hasSponsorsListing());
        values.add(selector.id());
        values.add(selector.innersourceVulnerabilities(
                Paging.first(1),
                OrganizationInnersourceVulnerabilitiesFilterBuilder.builder()
                        .ecosystem(SecurityAdvisoryEcosystem.ACTIONS)
                        .orderBy(SecurityVulnerabilityOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SecurityVulnerabilityOrderField.UPDATED_AT)
                                .build())
                        .packageValue("x")
                        .severities(List.of(SecurityAdvisorySeverity.CRITICAL))
                        .build(),
                SecurityVulnerabilitySelector::severity));
        values.add(selector.interactionAbility(RepositoryInteractionAbilitySelector::expiresAt));
        values.add(selector.ipAllowListEnabledSetting());
        values.add(selector.ipAllowListEntries(
                Paging.first(1),
                OrganizationIpAllowListEntriesFilterBuilder.builder()
                        .orderBy(IpAllowListEntryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IpAllowListEntryOrderField.ALLOW_LIST_VALUE)
                                .build())
                        .build(),
                IpAllowListEntrySelector::allowListValue));
        values.add(selector.ipAllowListForInstalledAppsEnabledSetting());
        values.add(selector.isSponsoredBy("x"));
        values.add(selector.isSponsoringViewer());
        values.add(selector.isVerified());
        values.add(selector.issueFields(
                Paging.first(1),
                OrganizationIssueFieldsFilterBuilder.builder()
                        .orderBy(IssueFieldOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueFieldOrderField.CREATED_AT)
                                .build())
                        .build(),
                child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.issueTypes(
                Paging.first(1),
                OrganizationIssueTypesFilterBuilder.builder()
                        .orderBy(IssueTypeOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueTypeOrderField.CREATED_AT)
                                .build())
                        .build(),
                IssueTypeSelector::color));
        values.add(selector.itemShowcase(ProfileItemShowcaseSelector::hasPinnedItems));
        values.add(selector.lifetimeReceivedSponsorshipValues(
                Paging.first(1),
                OrganizationLifetimeReceivedSponsorshipValuesFilterBuilder.builder()
                        .orderBy(SponsorAndLifetimeValueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorAndLifetimeValueOrderField.LIFETIME_VALUE)
                                .build())
                        .build(),
                SponsorAndLifetimeValueSelector::amountInCents));
        values.add(selector.location());
        values.add(selector.login());
        values.add(selector.mannequins(
                Paging.first(1),
                OrganizationMannequinsFilterBuilder.builder()
                        .login("x")
                        .orderBy(MannequinOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(MannequinOrderField.CREATED_AT)
                                .build())
                        .build(),
                MannequinSelector::avatarUrl));
        values.add(selector.memberStatuses(
                Paging.first(1),
                OrganizationMemberStatusesFilterBuilder.builder()
                        .orderBy(UserStatusOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(UserStatusOrderField.UPDATED_AT)
                                .build())
                        .build(),
                UserStatusSelector::createdAt));
        values.add(selector.membersCanForkPrivateRepositories());
        values.add(selector.membersWithRole(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.monthlyEstimatedSponsorsIncomeInCents());
        values.add(selector.name());
        values.add(selector.newTeamResourcePath());
        values.add(selector.newTeamUrl());
        values.add(selector.notificationDeliveryRestrictionEnabledSetting());
        values.add(selector.organizationBillingEmail());
        values.add(selector.packages(
                Paging.first(1),
                OrganizationPackagesFilterBuilder.builder()
                        .names(List.of("x"))
                        .orderBy(PackageOrderBuilder.builder().build())
                        .packageType(PackageType.DEBIAN)
                        .repositoryId("x")
                        .build(),
                PackageSelector::id));
        values.add(selector.pendingMembers(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.pinnableItems(
                Paging.first(1),
                OrganizationPinnableItemsFilterBuilder.builder()
                        .types(List.of(PinnableItemType.GIST))
                        .build(),
                child -> child.on(GistSelector.class, GistSelector::createdAt)));
        values.add(selector.pinnedIssueFields(
                Paging.first(1), child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.pinnedItems(
                Paging.first(1),
                OrganizationPinnedItemsFilterBuilder.builder()
                        .types(List.of(PinnableItemType.GIST))
                        .build(),
                child -> child.on(GistSelector.class, GistSelector::createdAt)));
        values.add(selector.pinnedItemsRemaining());
        values.add(selector.project(1, ProjectSelector::closed));
        values.add(selector.projectV2(1, ProjectV2Selector::closed));
        values.add(selector.projects(
                Paging.first(1),
                OrganizationProjectsFilterBuilder.builder()
                        .orderBy(ProjectOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectOrderField.CREATED_AT)
                                .build())
                        .search("x")
                        .states(List.of(ProjectState.CLOSED))
                        .build(),
                ProjectSelector::closed));
        values.add(selector.projectsResourcePath());
        values.add(selector.projectsUrl());
        values.add(selector.projectsV2(
                Paging.first(1),
                OrganizationProjectsV2FilterBuilder.builder()
                        .minPermissionLevel(ProjectV2PermissionLevel.ADMIN)
                        .orderBy(ProjectV2OrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2OrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                ProjectV2Selector::closed));
        values.add(selector.recentProjects(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.repositories(
                Paging.first(1),
                OrganizationRepositoriesFilterBuilder.builder()
                        .affiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .hasIssuesEnabled(true)
                        .isArchived(true)
                        .isFork(true)
                        .isLocked(true)
                        .orderBy(RepositoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryOrderField.CREATED_AT)
                                .build())
                        .ownerAffiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .privacy(RepositoryPrivacy.PRIVATE)
                        .visibility(RepositoryVisibility.INTERNAL)
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.repository(
                "x",
                OrganizationRepositoryFilterBuilder.builder()
                        .followRenames(true)
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(
                selector.repositoryCustomProperties(Paging.first(1), RepositoryCustomPropertySelector::allowedValues));
        values.add(selector.repositoryCustomProperty("x", RepositoryCustomPropertySelector::allowedValues));
        values.add(selector.repositoryDiscussionComments(
                Paging.first(1),
                OrganizationRepositoryDiscussionCommentsFilterBuilder.builder()
                        .onlyAnswers(true)
                        .repositoryId("x")
                        .build(),
                DiscussionCommentSelector::authorAssociation));
        values.add(selector.repositoryDiscussions(
                Paging.first(1),
                OrganizationRepositoryDiscussionsFilterBuilder.builder()
                        .answered(true)
                        .orderBy(DiscussionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(DiscussionOrderField.CREATED_AT)
                                .build())
                        .repositoryId("x")
                        .states(List.of(DiscussionState.CLOSED))
                        .build(),
                DiscussionSelector::activeLockReason));
        values.add(selector.repositoryMigrations(
                Paging.first(1),
                OrganizationRepositoryMigrationsFilterBuilder.builder()
                        .orderBy(RepositoryMigrationOrderBuilder.builder()
                                .direction(RepositoryMigrationOrderDirection.ASC)
                                .field(RepositoryMigrationOrderField.CREATED_AT)
                                .build())
                        .repositoryName("x")
                        .state(MigrationState.FAILED)
                        .build(),
                RepositoryMigrationSelector::continueOnError));
        values.add(selector.requiresTwoFactorAuthentication());
        values.add(selector.resourcePath());
        values.add(selector.ruleset(
                1,
                OrganizationRulesetFilterBuilder.builder().includeParents(true).build(),
                RepositoryRulesetSelector::createdAt));
        values.add(selector.rulesets(
                Paging.first(1),
                OrganizationRulesetsFilterBuilder.builder()
                        .includeParents(true)
                        .targets(List.of(RepositoryRulesetTarget.BRANCH))
                        .build(),
                RepositoryRulesetSelector::createdAt));
        values.add(selector.samlIdentityProvider(OrganizationIdentityProviderSelector::digestMethod));
        values.add(selector.sponsoring(
                Paging.first(1),
                OrganizationSponsoringFilterBuilder.builder()
                        .orderBy(SponsorOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorOrderField.LOGIN)
                                .build())
                        .build(),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsors(
                Paging.first(1),
                OrganizationSponsorsFilterBuilder.builder()
                        .orderBy(SponsorOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorOrderField.LOGIN)
                                .build())
                        .tierId("x")
                        .build(),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsorsActivities(
                Paging.first(1),
                OrganizationSponsorsActivitiesFilterBuilder.builder()
                        .actions(List.of(SponsorsActivityAction.CANCELLED_SPONSORSHIP))
                        .includeAsSponsor(true)
                        .includePrivate(true)
                        .orderBy(SponsorsActivityOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorsActivityOrderField.TIMESTAMP)
                                .build())
                        .period(SponsorsActivityPeriod.ALL)
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .until(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build(),
                SponsorsActivitySelector::action));
        values.add(selector.sponsorsListing(SponsorsListingSelector::billingCountryOrRegion));
        values.add(selector.sponsorshipForViewerAsSponsor(
                OrganizationSponsorshipForViewerAsSponsorFilterBuilder.builder()
                        .activeOnly(true)
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipForViewerAsSponsorable(
                OrganizationSponsorshipForViewerAsSponsorableFilterBuilder.builder()
                        .activeOnly(true)
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipNewsletters(
                Paging.first(1),
                OrganizationSponsorshipNewslettersFilterBuilder.builder()
                        .orderBy(SponsorshipNewsletterOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipNewsletterOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipNewsletterSelector::body));
        values.add(selector.sponsorshipsAsMaintainer(
                Paging.first(1),
                OrganizationSponsorshipsAsMaintainerFilterBuilder.builder()
                        .activeOnly(true)
                        .includePrivate(true)
                        .orderBy(SponsorshipOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipsAsSponsor(
                Paging.first(1),
                OrganizationSponsorshipsAsSponsorFilterBuilder.builder()
                        .activeOnly(true)
                        .maintainerLogins(List.of("x"))
                        .orderBy(SponsorshipOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.team("x", TeamSelector::avatarUrl));
        values.add(selector.teams(
                Paging.first(1),
                OrganizationTeamsFilterBuilder.builder()
                        .ldapMapped(true)
                        .notificationSetting(TeamNotificationSetting.NOTIFICATIONS_DISABLED)
                        .orderBy(TeamOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(TeamOrderField.NAME)
                                .build())
                        .privacy(TeamPrivacy.SECRET)
                        .query("x")
                        .role(TeamRole.ADMIN)
                        .rootTeamsOnly(true)
                        .userLogins(List.of("x"))
                        .build(),
                TeamSelector::avatarUrl));
        values.add(selector.teamsResourcePath());
        values.add(selector.teamsUrl());
        values.add(selector.totalSponsorshipAmountAsSponsorInCents(
                OrganizationTotalSponsorshipAmountAsSponsorInCentsFilterBuilder.builder()
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .sponsorableLogins(List.of("x"))
                        .until(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build()));
        values.add(selector.twitterUsername());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.viewerCanAdminister());
        values.add(selector.viewerCanChangePinnedItems());
        values.add(selector.viewerCanCreateProjects());
        values.add(selector.viewerCanCreateRepositories());
        values.add(selector.viewerCanCreateTeams());
        values.add(selector.viewerCanSponsor());
        values.add(selector.viewerIsAMember());
        values.add(selector.viewerIsFollowing());
        values.add(selector.viewerIsSponsoring());
        values.add(selector.webCommitSignoffRequired());
        values.add(selector.websiteUrl());
        return values;
    }

    private static List<Object> readWithoutArguments(final OrganizationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.anyPinnableItems());
        values.add(selector.auditLog(
                Paging.first(1),
                child -> child.on(
                        MembersCanDeleteReposClearAuditEntrySelector.class,
                        MembersCanDeleteReposClearAuditEntrySelector::enterpriseResourcePath)));
        values.add(selector.avatarUrl());
        values.add(selector.domains(Paging.first(1), VerifiableDomainSelector::createdAt));
        values.add(selector.enterpriseOwners(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.innersourceVulnerabilities(Paging.first(1), SecurityVulnerabilitySelector::severity));
        values.add(selector.ipAllowListEntries(Paging.first(1), IpAllowListEntrySelector::allowListValue));
        values.add(selector.issueFields(
                Paging.first(1), child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.issueTypes(Paging.first(1), IssueTypeSelector::color));
        values.add(selector.lifetimeReceivedSponsorshipValues(
                Paging.first(1), SponsorAndLifetimeValueSelector::amountInCents));
        values.add(selector.mannequins(Paging.first(1), MannequinSelector::avatarUrl));
        values.add(selector.memberStatuses(Paging.first(1), UserStatusSelector::createdAt));
        values.add(selector.packages(Paging.first(1), PackageSelector::id));
        values.add(selector.pinnableItems(
                Paging.first(1), child -> child.on(GistSelector.class, GistSelector::createdAt)));
        values.add(
                selector.pinnedItems(Paging.first(1), child -> child.on(GistSelector.class, GistSelector::createdAt)));
        values.add(selector.projects(Paging.first(1), ProjectSelector::closed));
        values.add(selector.projectsV2(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.repositories(Paging.first(1), RepositorySelector::allowUpdateBranch));
        values.add(selector.repository("x", RepositorySelector::allowUpdateBranch));
        values.add(
                selector.repositoryDiscussionComments(Paging.first(1), DiscussionCommentSelector::authorAssociation));
        values.add(selector.repositoryDiscussions(Paging.first(1), DiscussionSelector::activeLockReason));
        values.add(selector.repositoryMigrations(Paging.first(1), RepositoryMigrationSelector::continueOnError));
        values.add(selector.ruleset(1, RepositoryRulesetSelector::createdAt));
        values.add(selector.rulesets(Paging.first(1), RepositoryRulesetSelector::createdAt));
        values.add(selector.sponsoring(
                Paging.first(1),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsors(
                Paging.first(1),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsorsActivities(Paging.first(1), SponsorsActivitySelector::action));
        values.add(selector.sponsorshipForViewerAsSponsor(SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipForViewerAsSponsorable(SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipNewsletters(Paging.first(1), SponsorshipNewsletterSelector::body));
        values.add(selector.sponsorshipsAsMaintainer(Paging.first(1), SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipsAsSponsor(Paging.first(1), SponsorshipSelector::createdAt));
        values.add(selector.teams(Paging.first(1), TeamSelector::avatarUrl));
        values.add(selector.totalSponsorshipAmountAsSponsorInCents());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrganizationSelectorImpl(new RecordingCursor(root)));
        final OrganizationSelectorImpl selector =
                new OrganizationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of("x"), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        new Page<>(List.of(true), false, null),
                        1,
                        true,
                        "x",
                        new Page<>(List.of(SecurityAdvisorySeverity.CRITICAL), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        IpAllowListEnabledSettingValue.DISABLED,
                        new Page<>(List.of("x"), false, null),
                        IpAllowListForInstalledAppsEnabledSettingValue.DISABLED,
                        true,
                        true,
                        true,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(IssueTypeColor.BLUE), false, null),
                        true,
                        new Page<>(List.of(1), false, null),
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        true,
                        new Page<>(List.of(true), false, null),
                        1,
                        "x",
                        "x",
                        "x",
                        NotificationRestrictionSettingValue.DISABLED,
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        1,
                        true,
                        true,
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        true,
                        new Page<>(List.of(List.of("x")), false, null),
                        List.of("x"),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(true), false, null),
                        true,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(SponsorsActivityAction.CANCELLED_SPONSORSHIP), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        1,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new OrganizationSelectorImpl(new RecordingCursor(root)));
        final OrganizationSelectorImpl selector =
                new OrganizationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        new Page<>(List.of("x"), false, null),
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(SecurityAdvisorySeverity.CRITICAL), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(IssueTypeColor.BLUE), false, null),
                        new Page<>(List.of(1), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        true,
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(true), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(SponsorsActivityAction.CANCELLED_SPONSORSHIP), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of("x"), false, null),
                        1);
    }
}
