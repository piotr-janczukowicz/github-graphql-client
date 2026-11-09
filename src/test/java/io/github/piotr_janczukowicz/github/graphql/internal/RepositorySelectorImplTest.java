package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CodeOfConductSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CollaboratorAffiliation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContentWarningSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributingGuidelinesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DependencyGraphManifestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeployKeySelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionState;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentPinnedFilterField;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentsBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.FundingLinkSelector;
import io.github.piotr_janczukowicz.github.graphql.model.FundingPlatform;
import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCreationPolicy;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFiltersBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTemplateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeColor;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LanguageOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LanguageOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.LanguageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LicenseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.MergeCommitMessage;
import io.github.piotr_janczukowicz.github.graphql.model.MergeCommitTitle;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneState;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.PackageOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageType;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedDiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedEnvironmentOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedEnvironmentOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedEnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedIssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectState;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2PermissionLevel;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCreationPolicy;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestMergeMethod;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTemplateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RefOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryAffiliation;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryAssignableUsersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCodeownersErrorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCodeownersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCollaboratorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryContactLinkSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertyValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDependencyGraphManifestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDeploymentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDiscussionCategoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDiscussionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryEnvironmentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryForksFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionAbilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssueFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssueTypesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLanguagesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLockReason;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMentionableUsersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMergeQueueFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMilestonesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryObjectFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPackagesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPermission;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPinnedEnvironmentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPlanFeaturesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryProjectsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRefsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryReleasesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetTarget;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryShortDescriptionHTMLFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryStargazersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySuggestedActorFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySuggestedActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryTopicSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibility;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVulnerabilityAlertDependencyScope;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVulnerabilityAlertSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVulnerabilityAlertState;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVulnerabilityAlertsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryClassification;
import io.github.piotr_janczukowicz.github.graphql.model.SquashMergeCommitMessage;
import io.github.piotr_janczukowicz.github.graphql.model.SquashMergeCommitTitle;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SubmoduleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class RepositorySelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"allowUpdateBranch\":true" + ","
            + "\"archivedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"assignableUsers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"autoMergeAllowed\":true" + ","
            + "\"branchProtectionRules\":{\"nodes\": [{\"allowsDeletions\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"codeOfConduct\":{\"body\": \"x\"}" + "," + "\"codeowners\":{\"errors\": [{\"column\": 1}]}" + ","
            + "\"collaborators\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"commitComments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"contactLinks\":[{\"about\": \"x\"}]" + "," + "\"contributingGuidelines\":{\"body\": \"x\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + ","
            + "\"defaultBranchRef\":{\"id\": \"x\"}" + "," + "\"deleteBranchOnMerge\":true" + ","
            + "\"dependencyGraphManifests\":{\"nodes\": [{\"blobPath\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"deployKeys\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"deployments\":{\"nodes\": [{\"commitOid\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"description\":\"x\"" + "," + "\"descriptionHTML\":\"x\"" + ","
            + "\"discussion\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"discussionCategories\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"discussionCategory\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"discussions\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"diskUsage\":1" + "," + "\"environment\":{\"databaseId\": 1}" + ","
            + "\"environments\":{\"nodes\": [{\"databaseId\": 1}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"forkCount\":1" + "," + "\"forkingAllowed\":true" + ","
            + "\"forks\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"fullDatabaseId\":\"1\"" + "," + "\"fundingLinks\":[{\"platform\": \"BUY_ME_A_COFFEE\"}]" + ","
            + "\"hasDiscussionsEnabled\":true" + "," + "\"hasIssuesEnabled\":true" + "," + "\"hasProjectsEnabled\":true"
            + "," + "\"hasPullRequestsEnabled\":true" + "," + "\"hasSponsorshipsEnabled\":true" + ","
            + "\"hasVulnerabilityAlertsEnabled\":true" + "," + "\"hasWikiEnabled\":true" + "," + "\"homepageUrl\":\"x\""
            + "," + "\"id\":\"x\"" + "," + "\"interactionAbility\":{\"expiresAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"isArchived\":true" + "," + "\"isBlankIssuesEnabled\":true" + "," + "\"isDisabled\":true" + ","
            + "\"isEmpty\":true" + "," + "\"isFork\":true" + "," + "\"isInOrganization\":true" + ","
            + "\"isLocked\":true" + "," + "\"isMirror\":true" + "," + "\"isPrivate\":true" + ","
            + "\"isSecurityPolicyEnabled\":true" + "," + "\"isTemplate\":true" + ","
            + "\"isUserConfigurationRepository\":true" + "," + "\"issue\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"issueCreationPolicy\":\"ALL\"" + ","
            + "\"issueFields\":{\"nodes\": [{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"issueOrPullRequest\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"issueTemplates\":[{\"about\": \"x\"}]" + "," + "\"issueType\":{\"color\": \"BLUE\"}" + ","
            + "\"issueTypes\":{\"nodes\": [{\"color\": \"BLUE\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"issues\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"label\":{\"color\": \"x\"}" + ","
            + "\"labels\":{\"nodes\": [{\"color\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"languages\":{\"nodes\": [{\"color\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"latestRelease\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"licenseInfo\":{\"body\": \"x\"}" + "," + "\"lockReason\":\"BILLING\"" + ","
            + "\"mentionableUsers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"mergeCommitAllowed\":true" + "," + "\"mergeCommitMessage\":\"BLANK\"" + ","
            + "\"mergeCommitTitle\":\"MERGE_MESSAGE\"" + "," + "\"mergeQueue\":{\"id\": \"x\"}" + ","
            + "\"milestone\":{\"closed\": true}" + ","
            + "\"milestones\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"mirrorUrl\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"nameWithOwner\":\"x\"" + ","
            + "\"object\":{\"abbreviatedOid\": \"x\"}" + "," + "\"openGraphImageUrl\":\"x\"" + ","
            + "\"owner\":{\"avatarUrl\": \"x\"}" + ","
            + "\"packages\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"parent\":{\"allowUpdateBranch\": true}" + ","
            + "\"pinnedDiscussions\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pinnedEnvironments\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pinnedIssues\":{\"nodes\": [{\"databaseId\": 1}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"planFeatures\":{\"codeowners\": true}" + "," + "\"primaryLanguage\":{\"color\": \"x\"}" + ","
            + "\"project\":{\"closed\": true}" + "," + "\"projectV2\":{\"closed\": true}" + ","
            + "\"projects\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"projectsResourcePath\":\"x\"" + "," + "\"projectsUrl\":\"x\"" + ","
            + "\"projectsV2\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"pullRequestCreationCapConfig\":{\"bypassedUsers\": {\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}}"
            + "," + "\"pullRequestCreationPolicy\":\"ALL\"" + "," + "\"pullRequestTemplates\":[{\"body\": \"x\"}]" + ","
            + "\"pullRequests\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"pushedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"rebaseMergeAllowed\":true" + ","
            + "\"recentProjects\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"ref\":{\"id\": \"x\"}" + ","
            + "\"refs\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"release\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"releases\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repositoryCustomPropertyValue\":{\"propertyName\": \"x\"}" + ","
            + "\"repositoryCustomPropertyValues\":{\"nodes\": [{\"propertyName\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"repositoryTopics\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"resourcePath\":\"x\"" + "," + "\"ruleset\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"rulesets\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"securityPolicyUrl\":\"x\"" + "," + "\"shortDescriptionHTML\":\"x\"" + ","
            + "\"squashMergeAllowed\":true" + "," + "\"squashMergeCommitMessage\":\"BLANK\"" + ","
            + "\"squashMergeCommitTitle\":\"COMMIT_OR_PR_TITLE\"" + "," + "\"squashPrTitleUsedAsDefault\":true" + ","
            + "\"sshUrl\":\"x\"" + "," + "\"stargazerCount\":1" + ","
            + "\"stargazers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"submodules\":{\"nodes\": [{\"branch\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"suggestedActors\":{\"nodes\": [{\"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"tempCloneToken\":\"x\"" + "," + "\"templateRepository\":{\"allowUpdateBranch\": true}" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + ","
            + "\"usesCustomOpenGraphImage\":true" + "," + "\"viewerCanAdminister\":true" + ","
            + "\"viewerCanCreateIssues\":true" + "," + "\"viewerCanCreateProjects\":true" + ","
            + "\"viewerCanSeeIssueFields\":true" + "," + "\"viewerCanSubscribe\":true" + ","
            + "\"viewerCanUpdateTopics\":true" + "," + "\"viewerContentWarning\":{\"category\": \"x\"}" + ","
            + "\"viewerDefaultCommitEmail\":\"x\"" + "," + "\"viewerDefaultMergeMethod\":\"MERGE\"" + ","
            + "\"viewerHasStarred\":true" + "," + "\"viewerPermission\":\"ADMIN\"" + ","
            + "\"viewerPossibleCommitEmails\":[\"x\"]" + "," + "\"viewerSubscription\":\"IGNORED\"" + ","
            + "\"visibility\":\"INTERNAL\"" + ","
            + "\"vulnerabilityAlert\":{\"autoDismissedAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"vulnerabilityAlerts\":{\"nodes\": [{\"autoDismissedAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"watchers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"webCommitSignoffRequired\":true" + "}";

    private static List<Object> readWithArguments(final RepositorySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.allowUpdateBranch());
        values.add(selector.archivedAt());
        values.add(selector.assignableUsers(
                Paging.first(1),
                RepositoryAssignableUsersFilterBuilder.builder().query("x").build(),
                UserSelector::anyPinnableItems));
        values.add(selector.autoMergeAllowed());
        values.add(selector.branchProtectionRules(Paging.first(1), BranchProtectionRuleSelector::allowsDeletions));
        values.add(selector.codeOfConduct(CodeOfConductSelector::body));
        values.add(selector.codeowners(
                RepositoryCodeownersFilterBuilder.builder().refName("x").build(),
                child -> child.errors(RepositoryCodeownersErrorSelector::column)));
        values.add(selector.collaborators(
                Paging.first(1),
                RepositoryCollaboratorsFilterBuilder.builder()
                        .affiliation(CollaboratorAffiliation.ALL)
                        .login("x")
                        .query("x")
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.commitComments(Paging.first(1), CommitCommentSelector::authorAssociation));
        values.add(selector.contactLinks(RepositoryContactLinkSelector::about));
        values.add(selector.contributingGuidelines(ContributingGuidelinesSelector::body));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.defaultBranchRef(RefSelector::id));
        values.add(selector.deleteBranchOnMerge());
        values.add(selector.dependencyGraphManifests(
                Paging.first(1),
                RepositoryDependencyGraphManifestsFilterBuilder.builder()
                        .dependenciesAfter("x")
                        .dependenciesFirst(1)
                        .withDependencies(true)
                        .build(),
                DependencyGraphManifestSelector::blobPath));
        values.add(selector.deployKeys(Paging.first(1), DeployKeySelector::createdAt));
        values.add(selector.deployments(
                Paging.first(1),
                RepositoryDeploymentsFilterBuilder.builder()
                        .environments(List.of("x"))
                        .orderBy(DeploymentOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(DeploymentOrderField.CREATED_AT)
                                .build())
                        .build(),
                DeploymentSelector::commitOid));
        values.add(selector.description());
        values.add(selector.descriptionHTML());
        values.add(selector.discussion(1, DiscussionSelector::activeLockReason));
        values.add(selector.discussionCategories(
                Paging.first(1),
                RepositoryDiscussionCategoriesFilterBuilder.builder()
                        .filterByAssignable(true)
                        .build(),
                DiscussionCategorySelector::createdAt));
        values.add(selector.discussionCategory("x", DiscussionCategorySelector::createdAt));
        values.add(selector.discussions(
                Paging.first(1),
                RepositoryDiscussionsFilterBuilder.builder()
                        .answered(true)
                        .categoryId("x")
                        .orderBy(DiscussionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(DiscussionOrderField.CREATED_AT)
                                .build())
                        .states(List.of(DiscussionState.CLOSED))
                        .build(),
                DiscussionSelector::activeLockReason));
        values.add(selector.diskUsage());
        values.add(selector.environment("x", EnvironmentSelector::databaseId));
        values.add(selector.environments(
                Paging.first(1),
                RepositoryEnvironmentsFilterBuilder.builder()
                        .names(List.of("x"))
                        .orderBy(EnvironmentsBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnvironmentOrderField.NAME)
                                .build())
                        .pinnedEnvironmentFilter(EnvironmentPinnedFilterField.ALL)
                        .build(),
                EnvironmentSelector::databaseId));
        values.add(selector.forkCount());
        values.add(selector.forkingAllowed());
        values.add(selector.forks(
                Paging.first(1),
                RepositoryForksFilterBuilder.builder()
                        .affiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .hasIssuesEnabled(true)
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
        values.add(selector.fullDatabaseId());
        values.add(selector.fundingLinks(FundingLinkSelector::platform));
        values.add(selector.hasDiscussionsEnabled());
        values.add(selector.hasIssuesEnabled());
        values.add(selector.hasProjectsEnabled());
        values.add(selector.hasPullRequestsEnabled());
        values.add(selector.hasSponsorshipsEnabled());
        values.add(selector.hasVulnerabilityAlertsEnabled());
        values.add(selector.hasWikiEnabled());
        values.add(selector.homepageUrl());
        values.add(selector.id());
        values.add(selector.interactionAbility(RepositoryInteractionAbilitySelector::expiresAt));
        values.add(selector.isArchived());
        values.add(selector.isBlankIssuesEnabled());
        values.add(selector.isDisabled());
        values.add(selector.isEmpty());
        values.add(selector.isFork());
        values.add(selector.isInOrganization());
        values.add(selector.isLocked());
        values.add(selector.isMirror());
        values.add(selector.isPrivate());
        values.add(selector.isSecurityPolicyEnabled());
        values.add(selector.isTemplate());
        values.add(selector.isUserConfigurationRepository());
        values.add(selector.issue(1, IssueSelector::activeLockReason));
        values.add(selector.issueCreationPolicy());
        values.add(selector.issueFields(
                Paging.first(1),
                RepositoryIssueFieldsFilterBuilder.builder()
                        .orderBy(IssueFieldOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueFieldOrderField.CREATED_AT)
                                .build())
                        .build(),
                child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.issueOrPullRequest(
                1, child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        values.add(selector.issueTemplates(IssueTemplateSelector::about));
        values.add(selector.issueType("x", IssueTypeSelector::color));
        values.add(selector.issueTypes(
                Paging.first(1),
                RepositoryIssueTypesFilterBuilder.builder()
                        .orderBy(IssueTypeOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueTypeOrderField.CREATED_AT)
                                .build())
                        .build(),
                IssueTypeSelector::color));
        values.add(selector.issues(
                Paging.first(1),
                RepositoryIssuesFilterBuilder.builder()
                        .filterBy(IssueFiltersBuilder.builder().build())
                        .labels(List.of("x"))
                        .orderBy(IssueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueOrderField.COMMENTS)
                                .build())
                        .states(List.of(IssueState.CLOSED))
                        .build(),
                IssueSelector::activeLockReason));
        values.add(selector.label("x", LabelSelector::color));
        values.add(selector.labels(
                Paging.first(1),
                RepositoryLabelsFilterBuilder.builder()
                        .orderBy(LabelOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(LabelOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                LabelSelector::color));
        values.add(selector.languages(
                Paging.first(1),
                RepositoryLanguagesFilterBuilder.builder()
                        .orderBy(LanguageOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(LanguageOrderField.SIZE)
                                .build())
                        .build(),
                LanguageSelector::color));
        values.add(selector.latestRelease(ReleaseSelector::createdAt));
        values.add(selector.licenseInfo(LicenseSelector::body));
        values.add(selector.lockReason());
        values.add(selector.mentionableUsers(
                Paging.first(1),
                RepositoryMentionableUsersFilterBuilder.builder().query("x").build(),
                UserSelector::anyPinnableItems));
        values.add(selector.mergeCommitAllowed());
        values.add(selector.mergeCommitMessage());
        values.add(selector.mergeCommitTitle());
        values.add(selector.mergeQueue(
                RepositoryMergeQueueFilterBuilder.builder().branch("x").build(), MergeQueueSelector::id));
        values.add(selector.milestone(1, MilestoneSelector::closed));
        values.add(selector.milestones(
                Paging.first(1),
                RepositoryMilestonesFilterBuilder.builder()
                        .orderBy(MilestoneOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(MilestoneOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .states(List.of(MilestoneState.CLOSED))
                        .build(),
                MilestoneSelector::closed));
        values.add(selector.mirrorUrl());
        values.add(selector.name());
        values.add(selector.nameWithOwner());
        values.add(selector.object(
                RepositoryObjectFilterBuilder.builder().expression("x").oid("x").build(),
                GitObjectSelector::abbreviatedOid));
        values.add(selector.openGraphImageUrl());
        values.add(selector.owner(RepositoryOwnerSelector::avatarUrl));
        values.add(selector.packages(
                Paging.first(1),
                RepositoryPackagesFilterBuilder.builder()
                        .names(List.of("x"))
                        .orderBy(PackageOrderBuilder.builder().build())
                        .packageType(PackageType.DEBIAN)
                        .repositoryId("x")
                        .build(),
                PackageSelector::id));
        values.add(selector.parent(RepositorySelector::allowUpdateBranch));
        values.add(selector.pinnedDiscussions(Paging.first(1), PinnedDiscussionSelector::createdAt));
        values.add(selector.pinnedEnvironments(
                Paging.first(1),
                RepositoryPinnedEnvironmentsFilterBuilder.builder()
                        .orderBy(PinnedEnvironmentOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(PinnedEnvironmentOrderField.POSITION)
                                .build())
                        .build(),
                PinnedEnvironmentSelector::createdAt));
        values.add(selector.pinnedIssues(Paging.first(1), PinnedIssueSelector::databaseId));
        values.add(selector.planFeatures(RepositoryPlanFeaturesSelector::codeowners));
        values.add(selector.primaryLanguage(LanguageSelector::color));
        values.add(selector.project(1, ProjectSelector::closed));
        values.add(selector.projectV2(1, ProjectV2Selector::closed));
        values.add(selector.projects(
                Paging.first(1),
                RepositoryProjectsFilterBuilder.builder()
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
                RepositoryProjectsV2FilterBuilder.builder()
                        .minPermissionLevel(ProjectV2PermissionLevel.ADMIN)
                        .orderBy(ProjectV2OrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2OrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                ProjectV2Selector::closed));
        values.add(selector.pullRequest(1, PullRequestSelector::activeLockReason));
        values.add(selector.pullRequestCreationCapConfig(
                child -> child.bypassedUsers(Paging.first(1), UserSelector::anyPinnableItems)));
        values.add(selector.pullRequestCreationPolicy());
        values.add(selector.pullRequestTemplates(PullRequestTemplateSelector::body));
        values.add(selector.pullRequests(
                Paging.first(1),
                RepositoryPullRequestsFilterBuilder.builder()
                        .baseRefName("x")
                        .headRefName("x")
                        .labels(List.of("x"))
                        .orderBy(IssueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueOrderField.COMMENTS)
                                .build())
                        .states(List.of(PullRequestState.CLOSED))
                        .build(),
                PullRequestSelector::activeLockReason));
        values.add(selector.pushedAt());
        values.add(selector.rebaseMergeAllowed());
        values.add(selector.recentProjects(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.ref("x", RefSelector::id));
        values.add(selector.refs(
                "x",
                Paging.first(1),
                RepositoryRefsFilterBuilder.builder()
                        .direction(OrderDirection.ASC)
                        .orderBy(RefOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RefOrderField.ALPHABETICAL)
                                .build())
                        .query("x")
                        .build(),
                RefSelector::id));
        values.add(selector.release("x", ReleaseSelector::createdAt));
        values.add(selector.releases(
                Paging.first(1),
                RepositoryReleasesFilterBuilder.builder()
                        .orderBy(ReleaseOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ReleaseOrderField.CREATED_AT)
                                .build())
                        .build(),
                ReleaseSelector::createdAt));
        values.add(selector.repositoryCustomPropertyValue("x", RepositoryCustomPropertyValueSelector::propertyName));
        values.add(selector.repositoryCustomPropertyValues(
                Paging.first(1), RepositoryCustomPropertyValueSelector::propertyName));
        values.add(selector.repositoryTopics(Paging.first(1), RepositoryTopicSelector::id));
        values.add(selector.resourcePath());
        values.add(selector.ruleset(
                1,
                RepositoryRulesetFilterBuilder.builder().includeParents(true).build(),
                RepositoryRulesetSelector::createdAt));
        values.add(selector.rulesets(
                Paging.first(1),
                RepositoryRulesetsFilterBuilder.builder()
                        .includeParents(true)
                        .targets(List.of(RepositoryRulesetTarget.BRANCH))
                        .build(),
                RepositoryRulesetSelector::createdAt));
        values.add(selector.securityPolicyUrl());
        values.add(selector.shortDescriptionHTML(
                RepositoryShortDescriptionHTMLFilterBuilder.builder().limit(1).build()));
        values.add(selector.squashMergeAllowed());
        values.add(selector.squashMergeCommitMessage());
        values.add(selector.squashMergeCommitTitle());
        values.add(selector.squashPrTitleUsedAsDefault());
        values.add(selector.sshUrl());
        values.add(selector.stargazerCount());
        values.add(selector.stargazers(
                Paging.first(1),
                RepositoryStargazersFilterBuilder.builder()
                        .orderBy(StarOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(StarOrderField.STARRED_AT)
                                .build())
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.submodules(Paging.first(1), SubmoduleSelector::branch));
        values.add(selector.suggestedActors(
                List.of(RepositorySuggestedActorFilter.CAN_BE_ASSIGNED),
                Paging.first(1),
                RepositorySuggestedActorsFilterBuilder.builder()
                        .loginNames("x")
                        .query("x")
                        .build(),
                ActorSelector::avatarUrl));
        values.add(selector.tempCloneToken());
        values.add(selector.templateRepository(RepositorySelector::allowUpdateBranch));
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.usesCustomOpenGraphImage());
        values.add(selector.viewerCanAdminister());
        values.add(selector.viewerCanCreateIssues());
        values.add(selector.viewerCanCreateProjects());
        values.add(selector.viewerCanSeeIssueFields());
        values.add(selector.viewerCanSubscribe());
        values.add(selector.viewerCanUpdateTopics());
        values.add(selector.viewerContentWarning(ContentWarningSelector::category));
        values.add(selector.viewerDefaultCommitEmail());
        values.add(selector.viewerDefaultMergeMethod());
        values.add(selector.viewerHasStarred());
        values.add(selector.viewerPermission());
        values.add(selector.viewerPossibleCommitEmails());
        values.add(selector.viewerSubscription());
        values.add(selector.visibility());
        values.add(selector.vulnerabilityAlert(1, RepositoryVulnerabilityAlertSelector::autoDismissedAt));
        values.add(selector.vulnerabilityAlerts(
                Paging.first(1),
                RepositoryVulnerabilityAlertsFilterBuilder.builder()
                        .classifications(List.of(SecurityAdvisoryClassification.GENERAL))
                        .dependencyScopes(List.of(RepositoryVulnerabilityAlertDependencyScope.DEVELOPMENT))
                        .states(List.of(RepositoryVulnerabilityAlertState.AUTO_DISMISSED))
                        .build(),
                RepositoryVulnerabilityAlertSelector::autoDismissedAt));
        values.add(selector.watchers(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.webCommitSignoffRequired());
        return values;
    }

    private static List<Object> readWithoutArguments(final RepositorySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.assignableUsers(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.codeowners(child -> child.errors(RepositoryCodeownersErrorSelector::column)));
        values.add(selector.collaborators(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.dependencyGraphManifests(Paging.first(1), DependencyGraphManifestSelector::blobPath));
        values.add(selector.deployments(Paging.first(1), DeploymentSelector::commitOid));
        values.add(selector.discussionCategories(Paging.first(1), DiscussionCategorySelector::createdAt));
        values.add(selector.discussions(Paging.first(1), DiscussionSelector::activeLockReason));
        values.add(selector.environments(Paging.first(1), EnvironmentSelector::databaseId));
        values.add(selector.forks(Paging.first(1), RepositorySelector::allowUpdateBranch));
        values.add(selector.issueFields(
                Paging.first(1), child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.issueTypes(Paging.first(1), IssueTypeSelector::color));
        values.add(selector.issues(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.labels(Paging.first(1), LabelSelector::color));
        values.add(selector.languages(Paging.first(1), LanguageSelector::color));
        values.add(selector.mentionableUsers(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.mergeQueue(MergeQueueSelector::id));
        values.add(selector.milestones(Paging.first(1), MilestoneSelector::closed));
        values.add(selector.object(GitObjectSelector::abbreviatedOid));
        values.add(selector.packages(Paging.first(1), PackageSelector::id));
        values.add(selector.pinnedEnvironments(Paging.first(1), PinnedEnvironmentSelector::createdAt));
        values.add(selector.projects(Paging.first(1), ProjectSelector::closed));
        values.add(selector.projectsV2(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.pullRequests(Paging.first(1), PullRequestSelector::activeLockReason));
        values.add(selector.refs("x", Paging.first(1), RefSelector::id));
        values.add(selector.releases(Paging.first(1), ReleaseSelector::createdAt));
        values.add(selector.ruleset(1, RepositoryRulesetSelector::createdAt));
        values.add(selector.rulesets(Paging.first(1), RepositoryRulesetSelector::createdAt));
        values.add(selector.shortDescriptionHTML());
        values.add(selector.stargazers(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.suggestedActors(
                List.of(RepositorySuggestedActorFilter.CAN_BE_ASSIGNED), Paging.first(1), ActorSelector::avatarUrl));
        values.add(
                selector.vulnerabilityAlerts(Paging.first(1), RepositoryVulnerabilityAlertSelector::autoDismissedAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositorySelectorImpl(new RecordingCursor(root)));
        final RepositorySelectorImpl selector =
                new RepositorySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(true), false, null),
                        true,
                        new Page<>(List.of(true), false, null),
                        "x",
                        List.of(1),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        List.of("x"),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        true,
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        LockReason.OFF_TOPIC,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        1,
                        1,
                        new Page<>(List.of(1), false, null),
                        1,
                        true,
                        new Page<>(List.of(true), false, null),
                        BigInteger.ONE,
                        List.of(FundingPlatform.BUY_ME_A_COFFEE),
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
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
                        true,
                        true,
                        LockReason.OFF_TOPIC,
                        IssueCreationPolicy.ALL,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        LockReason.OFF_TOPIC,
                        List.of("x"),
                        IssueTypeColor.BLUE,
                        new Page<>(List.of(IssueTypeColor.BLUE), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        RepositoryLockReason.BILLING,
                        new Page<>(List.of(true), false, null),
                        true,
                        MergeCommitMessage.BLANK,
                        MergeCommitTitle.MERGE_MESSAGE,
                        "x",
                        true,
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        true,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(1), false, null),
                        true,
                        "x",
                        true,
                        true,
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        new Page<>(List.of(true), false, null),
                        LockReason.OFF_TOPIC,
                        new Page<>(List.of(true), false, null),
                        PullRequestCreationPolicy.ALL,
                        List.of("x"),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        new Page<>(List.of(true), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        "x",
                        true,
                        SquashMergeCommitMessage.BLANK,
                        SquashMergeCommitTitle.COMMIT_OR_PR_TITLE,
                        true,
                        "x",
                        1,
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null),
                        "x",
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "x",
                        "x",
                        PullRequestMergeMethod.MERGE,
                        true,
                        RepositoryPermission.ADMIN,
                        List.of("x"),
                        SubscriptionState.IGNORED,
                        RepositoryVisibility.INTERNAL,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new RepositorySelectorImpl(new RecordingCursor(root)));
        final RepositorySelectorImpl selector =
                new RepositorySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(true), false, null),
                        List.of(1),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(1), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(IssueTypeColor.BLUE), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        "x",
                        new Page<>(List.of(true), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
