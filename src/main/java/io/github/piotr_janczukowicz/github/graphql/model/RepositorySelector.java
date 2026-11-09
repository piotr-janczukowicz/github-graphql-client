package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Repository}. */
public interface RepositorySelector {

    boolean allowUpdateBranch();

    @Nullable Instant archivedAt();

    <R> Page<R> assignableUsers(
            Paging paging, RepositoryAssignableUsersFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> assignableUsers(Paging paging, Function<UserSelector, R> selection);

    boolean autoMergeAllowed();

    <R> Page<R> branchProtectionRules(Paging paging, Function<BranchProtectionRuleSelector, R> selection);

    <R> @Nullable R codeOfConduct(Function<CodeOfConductSelector, R> selection);

    <R> @Nullable R codeowners(
            RepositoryCodeownersFilter arguments, Function<RepositoryCodeownersSelector, R> selection);

    <R> @Nullable R codeowners(Function<RepositoryCodeownersSelector, R> selection);

    <R> Page<R> collaborators(
            Paging paging, RepositoryCollaboratorsFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> collaborators(Paging paging, Function<UserSelector, R> selection);

    <R> Page<R> commitComments(Paging paging, Function<CommitCommentSelector, R> selection);

    <R> List<R> contactLinks(Function<RepositoryContactLinkSelector, R> selection);

    <R> @Nullable R contributingGuidelines(Function<ContributingGuidelinesSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    <R> @Nullable R defaultBranchRef(Function<RefSelector, R> selection);

    boolean deleteBranchOnMerge();

    <R> Page<R> dependencyGraphManifests(
            Paging paging,
            RepositoryDependencyGraphManifestsFilter arguments,
            Function<DependencyGraphManifestSelector, R> selection);

    <R> Page<R> dependencyGraphManifests(Paging paging, Function<DependencyGraphManifestSelector, R> selection);

    <R> Page<R> deployKeys(Paging paging, Function<DeployKeySelector, R> selection);

    <R> Page<R> deployments(
            Paging paging, RepositoryDeploymentsFilter arguments, Function<DeploymentSelector, R> selection);

    <R> Page<R> deployments(Paging paging, Function<DeploymentSelector, R> selection);

    @Nullable String description();

    String descriptionHTML();

    <R> @Nullable R discussion(int number, Function<DiscussionSelector, R> selection);

    <R> Page<R> discussionCategories(
            Paging paging,
            RepositoryDiscussionCategoriesFilter arguments,
            Function<DiscussionCategorySelector, R> selection);

    <R> Page<R> discussionCategories(Paging paging, Function<DiscussionCategorySelector, R> selection);

    <R> @Nullable R discussionCategory(String slug, Function<DiscussionCategorySelector, R> selection);

    <R> Page<R> discussions(
            Paging paging, RepositoryDiscussionsFilter arguments, Function<DiscussionSelector, R> selection);

    <R> Page<R> discussions(Paging paging, Function<DiscussionSelector, R> selection);

    @Nullable Integer diskUsage();

    <R> @Nullable R environment(String name, Function<EnvironmentSelector, R> selection);

    <R> Page<R> environments(
            Paging paging, RepositoryEnvironmentsFilter arguments, Function<EnvironmentSelector, R> selection);

    <R> Page<R> environments(Paging paging, Function<EnvironmentSelector, R> selection);

    int forkCount();

    boolean forkingAllowed();

    <R> Page<R> forks(Paging paging, RepositoryForksFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> forks(Paging paging, Function<RepositorySelector, R> selection);

    @Nullable BigInteger fullDatabaseId();

    <R> List<R> fundingLinks(Function<FundingLinkSelector, R> selection);

    boolean hasDiscussionsEnabled();

    boolean hasIssuesEnabled();

    boolean hasProjectsEnabled();

    boolean hasPullRequestsEnabled();

    boolean hasSponsorshipsEnabled();

    boolean hasVulnerabilityAlertsEnabled();

    boolean hasWikiEnabled();

    @Nullable String homepageUrl();

    String id();

    <R> @Nullable R interactionAbility(Function<RepositoryInteractionAbilitySelector, R> selection);

    boolean isArchived();

    boolean isBlankIssuesEnabled();

    boolean isDisabled();

    boolean isEmpty();

    boolean isFork();

    boolean isInOrganization();

    boolean isLocked();

    boolean isMirror();

    boolean isPrivate();

    @Nullable Boolean isSecurityPolicyEnabled();

    boolean isTemplate();

    boolean isUserConfigurationRepository();

    <R> @Nullable R issue(int number, Function<IssueSelector, R> selection);

    @Nullable IssueCreationPolicy issueCreationPolicy();

    <R> Page<R> issueFields(
            Paging paging, RepositoryIssueFieldsFilter arguments, Function<IssueFieldsSelector, R> selection);

    <R> Page<R> issueFields(Paging paging, Function<IssueFieldsSelector, R> selection);

    <R> @Nullable R issueOrPullRequest(int number, Function<IssueOrPullRequestSelector, R> selection);

    <R> List<R> issueTemplates(Function<IssueTemplateSelector, R> selection);

    <R> @Nullable R issueType(String name, Function<IssueTypeSelector, R> selection);

    <R> Page<R> issueTypes(
            Paging paging, RepositoryIssueTypesFilter arguments, Function<IssueTypeSelector, R> selection);

    <R> Page<R> issueTypes(Paging paging, Function<IssueTypeSelector, R> selection);

    <R> Page<R> issues(Paging paging, RepositoryIssuesFilter arguments, Function<IssueSelector, R> selection);

    <R> Page<R> issues(Paging paging, Function<IssueSelector, R> selection);

    <R> @Nullable R label(String name, Function<LabelSelector, R> selection);

    <R> Page<R> labels(Paging paging, RepositoryLabelsFilter arguments, Function<LabelSelector, R> selection);

    <R> Page<R> labels(Paging paging, Function<LabelSelector, R> selection);

    <R> Page<R> languages(Paging paging, RepositoryLanguagesFilter arguments, Function<LanguageSelector, R> selection);

    <R> Page<R> languages(Paging paging, Function<LanguageSelector, R> selection);

    <R> @Nullable R latestRelease(Function<ReleaseSelector, R> selection);

    <R> @Nullable R licenseInfo(Function<LicenseSelector, R> selection);

    @Nullable RepositoryLockReason lockReason();

    <R> Page<R> mentionableUsers(
            Paging paging, RepositoryMentionableUsersFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> mentionableUsers(Paging paging, Function<UserSelector, R> selection);

    boolean mergeCommitAllowed();

    MergeCommitMessage mergeCommitMessage();

    MergeCommitTitle mergeCommitTitle();

    <R> @Nullable R mergeQueue(RepositoryMergeQueueFilter arguments, Function<MergeQueueSelector, R> selection);

    <R> @Nullable R mergeQueue(Function<MergeQueueSelector, R> selection);

    <R> @Nullable R milestone(int number, Function<MilestoneSelector, R> selection);

    <R> Page<R> milestones(
            Paging paging, RepositoryMilestonesFilter arguments, Function<MilestoneSelector, R> selection);

    <R> Page<R> milestones(Paging paging, Function<MilestoneSelector, R> selection);

    @Nullable String mirrorUrl();

    String name();

    String nameWithOwner();

    <R> @Nullable R object(RepositoryObjectFilter arguments, Function<GitObjectSelector, R> selection);

    <R> @Nullable R object(Function<GitObjectSelector, R> selection);

    String openGraphImageUrl();

    <R> R owner(Function<RepositoryOwnerSelector, R> selection);

    <R> Page<R> packages(Paging paging, RepositoryPackagesFilter arguments, Function<PackageSelector, R> selection);

    <R> Page<R> packages(Paging paging, Function<PackageSelector, R> selection);

    <R> @Nullable R parent(Function<RepositorySelector, R> selection);

    <R> Page<R> pinnedDiscussions(Paging paging, Function<PinnedDiscussionSelector, R> selection);

    <R> Page<R> pinnedEnvironments(
            Paging paging,
            RepositoryPinnedEnvironmentsFilter arguments,
            Function<PinnedEnvironmentSelector, R> selection);

    <R> Page<R> pinnedEnvironments(Paging paging, Function<PinnedEnvironmentSelector, R> selection);

    <R> Page<R> pinnedIssues(Paging paging, Function<PinnedIssueSelector, R> selection);

    <R> R planFeatures(Function<RepositoryPlanFeaturesSelector, R> selection);

    <R> @Nullable R primaryLanguage(Function<LanguageSelector, R> selection);

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
    <R> Page<R> projects(Paging paging, RepositoryProjectsFilter arguments, Function<ProjectSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> projects(Paging paging, Function<ProjectSelector, R> selection);

    String projectsResourcePath();

    String projectsUrl();

    <R> Page<R> projectsV2(
            Paging paging, RepositoryProjectsV2Filter arguments, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(Paging paging, Function<ProjectV2Selector, R> selection);

    <R> @Nullable R pullRequest(int number, Function<PullRequestSelector, R> selection);

    <R> @Nullable R pullRequestCreationCapConfig(Function<PullRequestCreationCapConfigSelector, R> selection);

    @Nullable PullRequestCreationPolicy pullRequestCreationPolicy();

    <R> List<R> pullRequestTemplates(Function<PullRequestTemplateSelector, R> selection);

    <R> Page<R> pullRequests(
            Paging paging, RepositoryPullRequestsFilter arguments, Function<PullRequestSelector, R> selection);

    <R> Page<R> pullRequests(Paging paging, Function<PullRequestSelector, R> selection);

    @Nullable Instant pushedAt();

    boolean rebaseMergeAllowed();

    <R> Page<R> recentProjects(Paging paging, Function<ProjectV2Selector, R> selection);

    <R> @Nullable R ref(String qualifiedName, Function<RefSelector, R> selection);

    <R> Page<R> refs(
            String refPrefix, Paging paging, RepositoryRefsFilter arguments, Function<RefSelector, R> selection);

    <R> Page<R> refs(String refPrefix, Paging paging, Function<RefSelector, R> selection);

    <R> @Nullable R release(String tagName, Function<ReleaseSelector, R> selection);

    <R> Page<R> releases(Paging paging, RepositoryReleasesFilter arguments, Function<ReleaseSelector, R> selection);

    <R> Page<R> releases(Paging paging, Function<ReleaseSelector, R> selection);

    <R> @Nullable R repositoryCustomPropertyValue(
            String propertyName, Function<RepositoryCustomPropertyValueSelector, R> selection);

    <R> Page<R> repositoryCustomPropertyValues(
            Paging paging, Function<RepositoryCustomPropertyValueSelector, R> selection);

    <R> Page<R> repositoryTopics(Paging paging, Function<RepositoryTopicSelector, R> selection);

    String resourcePath();

    <R> @Nullable R ruleset(
            int databaseId, RepositoryRulesetFilter arguments, Function<RepositoryRulesetSelector, R> selection);

    <R> @Nullable R ruleset(int databaseId, Function<RepositoryRulesetSelector, R> selection);

    <R> Page<R> rulesets(
            Paging paging, RepositoryRulesetsFilter arguments, Function<RepositoryRulesetSelector, R> selection);

    <R> Page<R> rulesets(Paging paging, Function<RepositoryRulesetSelector, R> selection);

    @Nullable String securityPolicyUrl();

    String shortDescriptionHTML(RepositoryShortDescriptionHTMLFilter arguments);

    String shortDescriptionHTML();

    boolean squashMergeAllowed();

    SquashMergeCommitMessage squashMergeCommitMessage();

    SquashMergeCommitTitle squashMergeCommitTitle();

    /**
     * @deprecated `squashPrTitleUsedAsDefault` will be removed. Use `Repository.squashMergeCommitTitle` instead.
     *     Removal on 2023-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    boolean squashPrTitleUsedAsDefault();

    String sshUrl();

    int stargazerCount();

    <R> Page<R> stargazers(Paging paging, RepositoryStargazersFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> stargazers(Paging paging, Function<UserSelector, R> selection);

    <R> Page<R> submodules(Paging paging, Function<SubmoduleSelector, R> selection);

    <R> Page<R> suggestedActors(
            List<RepositorySuggestedActorFilter> capabilities,
            Paging paging,
            RepositorySuggestedActorsFilter arguments,
            Function<ActorSelector, R> selection);

    <R> Page<R> suggestedActors(
            List<RepositorySuggestedActorFilter> capabilities, Paging paging, Function<ActorSelector, R> selection);

    @Nullable String tempCloneToken();

    <R> @Nullable R templateRepository(Function<RepositorySelector, R> selection);

    Instant updatedAt();

    String url();

    boolean usesCustomOpenGraphImage();

    boolean viewerCanAdminister();

    boolean viewerCanCreateIssues();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    boolean viewerCanCreateProjects();

    boolean viewerCanSeeIssueFields();

    boolean viewerCanSubscribe();

    boolean viewerCanUpdateTopics();

    <R> @Nullable R viewerContentWarning(Function<ContentWarningSelector, R> selection);

    @Nullable String viewerDefaultCommitEmail();

    PullRequestMergeMethod viewerDefaultMergeMethod();

    boolean viewerHasStarred();

    @Nullable RepositoryPermission viewerPermission();

    List<String> viewerPossibleCommitEmails();

    @Nullable SubscriptionState viewerSubscription();

    RepositoryVisibility visibility();

    <R> @Nullable R vulnerabilityAlert(int number, Function<RepositoryVulnerabilityAlertSelector, R> selection);

    <R> Page<R> vulnerabilityAlerts(
            Paging paging,
            RepositoryVulnerabilityAlertsFilter arguments,
            Function<RepositoryVulnerabilityAlertSelector, R> selection);

    <R> Page<R> vulnerabilityAlerts(Paging paging, Function<RepositoryVulnerabilityAlertSelector, R> selection);

    <R> Page<R> watchers(Paging paging, Function<UserSelector, R> selection);

    boolean webCommitSignoffRequired();
}
