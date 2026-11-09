package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Organization}. */
public interface OrganizationSelector {

    <R> @Nullable R announcementBanner(Function<AnnouncementBannerSelector, R> selection);

    boolean anyPinnableItems(OrganizationAnyPinnableItemsFilter arguments);

    boolean anyPinnableItems();

    @Nullable Instant archivedAt();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> Page<R> auditLog(
            Paging paging, OrganizationAuditLogFilter arguments, Function<OrganizationAuditEntrySelector, R> selection);

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> Page<R> auditLog(Paging paging, Function<OrganizationAuditEntrySelector, R> selection);

    String avatarUrl(OrganizationAvatarUrlFilter arguments);

    String avatarUrl();

    Instant createdAt();

    @Nullable Integer databaseId();

    @Nullable String description();

    @Nullable String descriptionHTML();

    <R> Page<R> domains(
            Paging paging, OrganizationDomainsFilter arguments, Function<VerifiableDomainSelector, R> selection);

    <R> Page<R> domains(Paging paging, Function<VerifiableDomainSelector, R> selection);

    @Nullable String email();

    <R> Page<R> enterpriseOwners(
            Paging paging, OrganizationEnterpriseOwnersFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> enterpriseOwners(Paging paging, Function<UserSelector, R> selection);

    int estimatedNextSponsorsPayoutInCents();

    boolean hasSponsorsListing();

    String id();

    <R> Page<R> innersourceVulnerabilities(
            Paging paging,
            OrganizationInnersourceVulnerabilitiesFilter arguments,
            Function<SecurityVulnerabilitySelector, R> selection);

    <R> Page<R> innersourceVulnerabilities(Paging paging, Function<SecurityVulnerabilitySelector, R> selection);

    <R> @Nullable R interactionAbility(Function<RepositoryInteractionAbilitySelector, R> selection);

    IpAllowListEnabledSettingValue ipAllowListEnabledSetting();

    <R> Page<R> ipAllowListEntries(
            Paging paging,
            OrganizationIpAllowListEntriesFilter arguments,
            Function<IpAllowListEntrySelector, R> selection);

    <R> Page<R> ipAllowListEntries(Paging paging, Function<IpAllowListEntrySelector, R> selection);

    IpAllowListForInstalledAppsEnabledSettingValue ipAllowListForInstalledAppsEnabledSetting();

    boolean isSponsoredBy(String accountLogin);

    boolean isSponsoringViewer();

    boolean isVerified();

    <R> Page<R> issueFields(
            Paging paging, OrganizationIssueFieldsFilter arguments, Function<IssueFieldsSelector, R> selection);

    <R> Page<R> issueFields(Paging paging, Function<IssueFieldsSelector, R> selection);

    <R> Page<R> issueTypes(
            Paging paging, OrganizationIssueTypesFilter arguments, Function<IssueTypeSelector, R> selection);

    <R> Page<R> issueTypes(Paging paging, Function<IssueTypeSelector, R> selection);

    <R> R itemShowcase(Function<ProfileItemShowcaseSelector, R> selection);

    <R> Page<R> lifetimeReceivedSponsorshipValues(
            Paging paging,
            OrganizationLifetimeReceivedSponsorshipValuesFilter arguments,
            Function<SponsorAndLifetimeValueSelector, R> selection);

    <R> Page<R> lifetimeReceivedSponsorshipValues(
            Paging paging, Function<SponsorAndLifetimeValueSelector, R> selection);

    @Nullable String location();

    String login();

    <R> Page<R> mannequins(
            Paging paging, OrganizationMannequinsFilter arguments, Function<MannequinSelector, R> selection);

    <R> Page<R> mannequins(Paging paging, Function<MannequinSelector, R> selection);

    <R> Page<R> memberStatuses(
            Paging paging, OrganizationMemberStatusesFilter arguments, Function<UserStatusSelector, R> selection);

    <R> Page<R> memberStatuses(Paging paging, Function<UserStatusSelector, R> selection);

    boolean membersCanForkPrivateRepositories();

    <R> Page<R> membersWithRole(Paging paging, Function<UserSelector, R> selection);

    int monthlyEstimatedSponsorsIncomeInCents();

    @Nullable String name();

    String newTeamResourcePath();

    String newTeamUrl();

    NotificationRestrictionSettingValue notificationDeliveryRestrictionEnabledSetting();

    @Nullable String organizationBillingEmail();

    <R> Page<R> packages(Paging paging, OrganizationPackagesFilter arguments, Function<PackageSelector, R> selection);

    <R> Page<R> packages(Paging paging, Function<PackageSelector, R> selection);

    <R> Page<R> pendingMembers(Paging paging, Function<UserSelector, R> selection);

    <R> Page<R> pinnableItems(
            Paging paging, OrganizationPinnableItemsFilter arguments, Function<PinnableItemSelector, R> selection);

    <R> Page<R> pinnableItems(Paging paging, Function<PinnableItemSelector, R> selection);

    <R> Page<R> pinnedIssueFields(Paging paging, Function<IssueFieldsSelector, R> selection);

    <R> Page<R> pinnedItems(
            Paging paging, OrganizationPinnedItemsFilter arguments, Function<PinnableItemSelector, R> selection);

    <R> Page<R> pinnedItems(Paging paging, Function<PinnableItemSelector, R> selection);

    int pinnedItemsRemaining();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R project(int number, Function<ProjectSelector, R> selection);

    <R> @Nullable R projectV2(int number, Function<ProjectV2Selector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> projects(Paging paging, OrganizationProjectsFilter arguments, Function<ProjectSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> projects(Paging paging, Function<ProjectSelector, R> selection);

    String projectsResourcePath();

    String projectsUrl();

    <R> Page<R> projectsV2(
            Paging paging, OrganizationProjectsV2Filter arguments, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(Paging paging, Function<ProjectV2Selector, R> selection);

    <R> Page<R> recentProjects(Paging paging, Function<ProjectV2Selector, R> selection);

    <R> Page<R> repositories(
            Paging paging, OrganizationRepositoriesFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> repositories(Paging paging, Function<RepositorySelector, R> selection);

    <R> @Nullable R repository(
            String name, OrganizationRepositoryFilter arguments, Function<RepositorySelector, R> selection);

    <R> @Nullable R repository(String name, Function<RepositorySelector, R> selection);

    <R> Page<R> repositoryCustomProperties(Paging paging, Function<RepositoryCustomPropertySelector, R> selection);

    <R> @Nullable R repositoryCustomProperty(
            String propertyName, Function<RepositoryCustomPropertySelector, R> selection);

    <R> Page<R> repositoryDiscussionComments(
            Paging paging,
            OrganizationRepositoryDiscussionCommentsFilter arguments,
            Function<DiscussionCommentSelector, R> selection);

    <R> Page<R> repositoryDiscussionComments(Paging paging, Function<DiscussionCommentSelector, R> selection);

    <R> Page<R> repositoryDiscussions(
            Paging paging,
            OrganizationRepositoryDiscussionsFilter arguments,
            Function<DiscussionSelector, R> selection);

    <R> Page<R> repositoryDiscussions(Paging paging, Function<DiscussionSelector, R> selection);

    <R> Page<R> repositoryMigrations(
            Paging paging,
            OrganizationRepositoryMigrationsFilter arguments,
            Function<RepositoryMigrationSelector, R> selection);

    <R> Page<R> repositoryMigrations(Paging paging, Function<RepositoryMigrationSelector, R> selection);

    @Nullable Boolean requiresTwoFactorAuthentication();

    String resourcePath();

    <R> @Nullable R ruleset(
            int databaseId, OrganizationRulesetFilter arguments, Function<RepositoryRulesetSelector, R> selection);

    <R> @Nullable R ruleset(int databaseId, Function<RepositoryRulesetSelector, R> selection);

    <R> Page<R> rulesets(
            Paging paging, OrganizationRulesetsFilter arguments, Function<RepositoryRulesetSelector, R> selection);

    <R> Page<R> rulesets(Paging paging, Function<RepositoryRulesetSelector, R> selection);

    <R> @Nullable R samlIdentityProvider(Function<OrganizationIdentityProviderSelector, R> selection);

    <R> Page<R> sponsoring(
            Paging paging, OrganizationSponsoringFilter arguments, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsoring(Paging paging, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsors(Paging paging, OrganizationSponsorsFilter arguments, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsors(Paging paging, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsorsActivities(
            Paging paging,
            OrganizationSponsorsActivitiesFilter arguments,
            Function<SponsorsActivitySelector, R> selection);

    <R> Page<R> sponsorsActivities(Paging paging, Function<SponsorsActivitySelector, R> selection);

    <R> @Nullable R sponsorsListing(Function<SponsorsListingSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsor(
            OrganizationSponsorshipForViewerAsSponsorFilter arguments, Function<SponsorshipSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsor(Function<SponsorshipSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsorable(
            OrganizationSponsorshipForViewerAsSponsorableFilter arguments, Function<SponsorshipSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsorable(Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipNewsletters(
            Paging paging,
            OrganizationSponsorshipNewslettersFilter arguments,
            Function<SponsorshipNewsletterSelector, R> selection);

    <R> Page<R> sponsorshipNewsletters(Paging paging, Function<SponsorshipNewsletterSelector, R> selection);

    <R> Page<R> sponsorshipsAsMaintainer(
            Paging paging,
            OrganizationSponsorshipsAsMaintainerFilter arguments,
            Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipsAsMaintainer(Paging paging, Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipsAsSponsor(
            Paging paging,
            OrganizationSponsorshipsAsSponsorFilter arguments,
            Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipsAsSponsor(Paging paging, Function<SponsorshipSelector, R> selection);

    <R> @Nullable R team(String slug, Function<TeamSelector, R> selection);

    <R> Page<R> teams(Paging paging, OrganizationTeamsFilter arguments, Function<TeamSelector, R> selection);

    <R> Page<R> teams(Paging paging, Function<TeamSelector, R> selection);

    String teamsResourcePath();

    String teamsUrl();

    @Nullable Integer totalSponsorshipAmountAsSponsorInCents(OrganizationTotalSponsorshipAmountAsSponsorInCentsFilter arguments);

    @Nullable Integer totalSponsorshipAmountAsSponsorInCents();

    @Nullable String twitterUsername();

    Instant updatedAt();

    String url();

    boolean viewerCanAdminister();

    boolean viewerCanChangePinnedItems();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    boolean viewerCanCreateProjects();

    boolean viewerCanCreateRepositories();

    boolean viewerCanCreateTeams();

    boolean viewerCanSponsor();

    boolean viewerIsAMember();

    boolean viewerIsFollowing();

    boolean viewerIsSponsoring();

    boolean webCommitSignoffRequired();

    @Nullable String websiteUrl();
}
