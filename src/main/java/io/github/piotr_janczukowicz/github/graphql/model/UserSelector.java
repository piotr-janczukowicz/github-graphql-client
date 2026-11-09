package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code User}. */
public interface UserSelector {

    boolean anyPinnableItems(UserAnyPinnableItemsFilter arguments);

    boolean anyPinnableItems();

    String avatarUrl(UserAvatarUrlFilter arguments);

    String avatarUrl();

    @Nullable String bio();

    String bioHTML();

    boolean canReceiveOrganizationEmailsWhenNotificationsRestricted(String login);

    <R> Page<R> commitComments(Paging paging, Function<CommitCommentSelector, R> selection);

    @Nullable String company();

    String companyHTML();

    <R> R contributionsCollection(
            UserContributionsCollectionFilter arguments, Function<ContributionsCollectionSelector, R> selection);

    <R> R contributionsCollection(Function<ContributionsCollectionSelector, R> selection);

    <R> @Nullable R copilotEndpoints(Function<CopilotEndpointsSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    String email();

    <R> Page<R> enterprises(Paging paging, UserEnterprisesFilter arguments, Function<EnterpriseSelector, R> selection);

    <R> Page<R> enterprises(Paging paging, Function<EnterpriseSelector, R> selection);

    int estimatedNextSponsorsPayoutInCents();

    <R> Page<R> followers(Paging paging, Function<UserSelector, R> selection);

    <R> Page<R> following(Paging paging, Function<UserSelector, R> selection);

    <R> @Nullable R gist(String name, Function<GistSelector, R> selection);

    <R> Page<R> gistComments(Paging paging, Function<GistCommentSelector, R> selection);

    <R> Page<R> gists(Paging paging, UserGistsFilter arguments, Function<GistSelector, R> selection);

    <R> Page<R> gists(Paging paging, Function<GistSelector, R> selection);

    boolean hasSponsorsListing();

    <R> R hovercard(UserHovercardFilter arguments, Function<HovercardSelector, R> selection);

    <R> R hovercard(Function<HovercardSelector, R> selection);

    String id();

    <R> @Nullable R interactionAbility(Function<RepositoryInteractionAbilitySelector, R> selection);

    boolean isBountyHunter();

    boolean isCampusExpert();

    boolean isDeveloperProgramMember();

    boolean isEmployee();

    boolean isFollowingViewer();

    boolean isGitHubStar();

    boolean isHireable();

    boolean isSiteAdmin();

    boolean isSponsoredBy(String accountLogin);

    boolean isSponsoringViewer();

    boolean isViewer();

    <R> Page<R> issueComments(
            Paging paging, UserIssueCommentsFilter arguments, Function<IssueCommentSelector, R> selection);

    <R> Page<R> issueComments(Paging paging, Function<IssueCommentSelector, R> selection);

    <R> Page<R> issues(Paging paging, UserIssuesFilter arguments, Function<IssueSelector, R> selection);

    <R> Page<R> issues(Paging paging, Function<IssueSelector, R> selection);

    <R> R itemShowcase(Function<ProfileItemShowcaseSelector, R> selection);

    <R> Page<R> lifetimeReceivedSponsorshipValues(
            Paging paging,
            UserLifetimeReceivedSponsorshipValuesFilter arguments,
            Function<SponsorAndLifetimeValueSelector, R> selection);

    <R> Page<R> lifetimeReceivedSponsorshipValues(
            Paging paging, Function<SponsorAndLifetimeValueSelector, R> selection);

    <R> Page<R> lists(Paging paging, Function<UserListSelector, R> selection);

    @Nullable String location();

    String login();

    int monthlyEstimatedSponsorsIncomeInCents();

    @Nullable String name();

    <R> @Nullable R organization(String login, Function<OrganizationSelector, R> selection);

    List<String> organizationVerifiedDomainEmails(String login);

    <R> Page<R> organizations(
            Paging paging, UserOrganizationsFilter arguments, Function<OrganizationSelector, R> selection);

    <R> Page<R> organizations(Paging paging, Function<OrganizationSelector, R> selection);

    <R> Page<R> packages(Paging paging, UserPackagesFilter arguments, Function<PackageSelector, R> selection);

    <R> Page<R> packages(Paging paging, Function<PackageSelector, R> selection);

    <R> Page<R> pinnableItems(
            Paging paging, UserPinnableItemsFilter arguments, Function<PinnableItemSelector, R> selection);

    <R> Page<R> pinnableItems(Paging paging, Function<PinnableItemSelector, R> selection);

    <R> Page<R> pinnedItems(
            Paging paging, UserPinnedItemsFilter arguments, Function<PinnableItemSelector, R> selection);

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
    <R> Page<R> projects(Paging paging, UserProjectsFilter arguments, Function<ProjectSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> projects(Paging paging, Function<ProjectSelector, R> selection);

    String projectsResourcePath();

    String projectsUrl();

    <R> Page<R> projectsV2(Paging paging, UserProjectsV2Filter arguments, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(Paging paging, Function<ProjectV2Selector, R> selection);

    @Nullable String pronouns();

    <R> Page<R> publicKeys(Paging paging, Function<PublicKeySelector, R> selection);

    <R> Page<R> pullRequests(
            Paging paging, UserPullRequestsFilter arguments, Function<PullRequestSelector, R> selection);

    <R> Page<R> pullRequests(Paging paging, Function<PullRequestSelector, R> selection);

    <R> Page<R> recentProjects(Paging paging, Function<ProjectV2Selector, R> selection);

    <R> Page<R> repositories(
            Paging paging, UserRepositoriesFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> repositories(Paging paging, Function<RepositorySelector, R> selection);

    <R> Page<R> repositoriesContributedTo(
            Paging paging, UserRepositoriesContributedToFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> repositoriesContributedTo(Paging paging, Function<RepositorySelector, R> selection);

    <R> @Nullable R repository(String name, UserRepositoryFilter arguments, Function<RepositorySelector, R> selection);

    <R> @Nullable R repository(String name, Function<RepositorySelector, R> selection);

    <R> Page<R> repositoryDiscussionComments(
            Paging paging,
            UserRepositoryDiscussionCommentsFilter arguments,
            Function<DiscussionCommentSelector, R> selection);

    <R> Page<R> repositoryDiscussionComments(Paging paging, Function<DiscussionCommentSelector, R> selection);

    <R> Page<R> repositoryDiscussions(
            Paging paging, UserRepositoryDiscussionsFilter arguments, Function<DiscussionSelector, R> selection);

    <R> Page<R> repositoryDiscussions(Paging paging, Function<DiscussionSelector, R> selection);

    String resourcePath();

    <R> Page<R> savedReplies(
            Paging paging, UserSavedRepliesFilter arguments, Function<SavedReplySelector, R> selection);

    <R> Page<R> savedReplies(Paging paging, Function<SavedReplySelector, R> selection);

    <R> Page<R> socialAccounts(Paging paging, Function<SocialAccountSelector, R> selection);

    <R> Page<R> sponsoring(Paging paging, UserSponsoringFilter arguments, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsoring(Paging paging, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsors(Paging paging, UserSponsorsFilter arguments, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsors(Paging paging, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsorsActivities(
            Paging paging, UserSponsorsActivitiesFilter arguments, Function<SponsorsActivitySelector, R> selection);

    <R> Page<R> sponsorsActivities(Paging paging, Function<SponsorsActivitySelector, R> selection);

    <R> @Nullable R sponsorsListing(Function<SponsorsListingSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsor(
            UserSponsorshipForViewerAsSponsorFilter arguments, Function<SponsorshipSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsor(Function<SponsorshipSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsorable(
            UserSponsorshipForViewerAsSponsorableFilter arguments, Function<SponsorshipSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsorable(Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipNewsletters(
            Paging paging,
            UserSponsorshipNewslettersFilter arguments,
            Function<SponsorshipNewsletterSelector, R> selection);

    <R> Page<R> sponsorshipNewsletters(Paging paging, Function<SponsorshipNewsletterSelector, R> selection);

    <R> Page<R> sponsorshipsAsMaintainer(
            Paging paging, UserSponsorshipsAsMaintainerFilter arguments, Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipsAsMaintainer(Paging paging, Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipsAsSponsor(
            Paging paging, UserSponsorshipsAsSponsorFilter arguments, Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipsAsSponsor(Paging paging, Function<SponsorshipSelector, R> selection);

    <R> Page<R> starredRepositories(
            Paging paging, UserStarredRepositoriesFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> starredRepositories(Paging paging, Function<RepositorySelector, R> selection);

    <R> @Nullable R status(Function<UserStatusSelector, R> selection);

    <R> List<R> suggestedListNames(Function<UserListSuggestionSelector, R> selection);

    <R> Page<R> topRepositories(
            RepositoryOrder orderBy,
            Paging paging,
            UserTopRepositoriesFilter arguments,
            Function<RepositorySelector, R> selection);

    <R> Page<R> topRepositories(RepositoryOrder orderBy, Paging paging, Function<RepositorySelector, R> selection);

    @Nullable Integer totalSponsorshipAmountAsSponsorInCents(UserTotalSponsorshipAmountAsSponsorInCentsFilter arguments);

    @Nullable Integer totalSponsorshipAmountAsSponsorInCents();

    @Nullable String twitterUsername();

    Instant updatedAt();

    String url();

    UserViewType userViewType();

    boolean viewerCanChangePinnedItems();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    boolean viewerCanCreateProjects();

    boolean viewerCanFollow();

    boolean viewerCanSponsor();

    @Nullable String viewerCopilotAgentCreatesChannel();

    @Nullable String viewerCopilotAgentLogUpdatesChannel();

    @Nullable String viewerCopilotAgentTaskUpdatesChannel();

    @Nullable String viewerCopilotAgentUpdatesChannel();

    boolean viewerIsFollowing();

    boolean viewerIsSponsoring();

    <R> Page<R> watching(Paging paging, UserWatchingFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> watching(Paging paging, Function<RepositorySelector, R> selection);

    @Nullable String websiteUrl();
}
