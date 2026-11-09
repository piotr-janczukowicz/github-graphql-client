package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CodeOfConductSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContentWarningSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributingGuidelinesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DependencyGraphManifestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeployKeySelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.FundingLinkSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCreationPolicy;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrPullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTemplateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LanguageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LicenseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeCommitMessage;
import io.github.piotr_janczukowicz.github.graphql.model.MergeCommitTitle;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedDiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedEnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedIssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCreationCapConfigSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCreationPolicy;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestMergeMethod;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTemplateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryAssignableUsersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryAssignableUsersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCodeownersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCodeownersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCodeownersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCollaboratorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCollaboratorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryContactLinkSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertyValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDependencyGraphManifestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDependencyGraphManifestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDeploymentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDeploymentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDiscussionCategoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDiscussionCategoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDiscussionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryDiscussionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryEnvironmentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryEnvironmentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryForksFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryForksFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionAbilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssueFieldsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssueFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssueTypesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssueTypesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLabelsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLanguagesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLanguagesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLockReason;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMentionableUsersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMentionableUsersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMergeQueueFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMergeQueueFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMilestonesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMilestonesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryObjectFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryObjectFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPackagesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPackagesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPermission;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPinnedEnvironmentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPinnedEnvironmentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPlanFeaturesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryProjectsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryProjectsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryProjectsV2Filter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPullRequestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRefsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRefsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryReleasesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryReleasesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryShortDescriptionHTMLFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryShortDescriptionHTMLFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryStargazersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryStargazersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySuggestedActorFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySuggestedActorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySuggestedActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryTopicSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibility;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVulnerabilityAlertSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVulnerabilityAlertsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVulnerabilityAlertsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SquashMergeCommitMessage;
import io.github.piotr_janczukowicz.github.graphql.model.SquashMergeCommitTitle;
import io.github.piotr_janczukowicz.github.graphql.model.SubmoduleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Repository}; used by the generated selection code only. */
final class RepositorySelectorImpl implements RepositorySelector {

    private static final String PAGING = "paging";

    private static final String ARGUMENTS = "arguments";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String QUERY = "query";

    private static final String BOOLEAN = "Boolean";

    private static final String STRING_2 = "[String!]";

    private static final String ORDER_BY = "orderBy";

    private static final String NUMBER = "number";

    private static final String STRING_3 = "String!";

    private static final String STATES = "states";

    private static final String NAME = "name";

    private static final String LABELS = "labels";

    private static final String REMOVAL = "removal";

    private final Cursor cursor;

    RepositorySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean allowUpdateBranch() {
        return cursor.getRequired("allowUpdateBranch", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Instant archivedAt() {
        return cursor.get("archivedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> assignableUsers(
            final Paging paging,
            final RepositoryAssignableUsersFilter arguments,
            final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "assignableUsers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> assignableUsers(final Paging paging, final Function<UserSelector, R> selection) {
        return assignableUsers(
                paging, RepositoryAssignableUsersFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean autoMergeAllowed() {
        return cursor.getRequired("autoMergeAllowed", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> branchProtectionRules(
            final Paging paging, final Function<BranchProtectionRuleSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "branchProtectionRules",
                child -> selection.apply(new BranchProtectionRuleSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R codeOfConduct(final Function<CodeOfConductSelector, R> selection) {
        return cursor.object("codeOfConduct", child -> selection.apply(new CodeOfConductSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R codeowners(
            final RepositoryCodeownersFilter arguments, final Function<RepositoryCodeownersSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "codeowners",
                child -> selection.apply(new RepositoryCodeownersSelectorImpl(child)),
                Argument.of("refName", STRING, arguments.refName()));
    }

    @Override
    public <R> @Nullable R codeowners(final Function<RepositoryCodeownersSelector, R> selection) {
        return codeowners(RepositoryCodeownersFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> collaborators(
            final Paging paging,
            final RepositoryCollaboratorsFilter arguments,
            final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "collaborators",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("affiliation", "CollaboratorAffiliation", arguments.affiliation()),
                Argument.of("login", STRING, arguments.login()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> collaborators(final Paging paging, final Function<UserSelector, R> selection) {
        return collaborators(
                paging, RepositoryCollaboratorsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> commitComments(final Paging paging, final Function<CommitCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "commitComments",
                child -> selection.apply(new CommitCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> List<R> contactLinks(final Function<RepositoryContactLinkSelector, R> selection) {
        return cursor.list("contactLinks", child -> selection.apply(new RepositoryContactLinkSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R contributingGuidelines(final Function<ContributingGuidelinesSelector, R> selection) {
        return cursor.object(
                "contributingGuidelines", child -> selection.apply(new ContributingGuidelinesSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R defaultBranchRef(final Function<RefSelector, R> selection) {
        return cursor.object("defaultBranchRef", child -> selection.apply(new RefSelectorImpl(child)));
    }

    @Override
    public boolean deleteBranchOnMerge() {
        return cursor.getRequired("deleteBranchOnMerge", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> dependencyGraphManifests(
            final Paging paging,
            final RepositoryDependencyGraphManifestsFilter arguments,
            final Function<DependencyGraphManifestSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "dependencyGraphManifests",
                child -> selection.apply(new DependencyGraphManifestSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("dependenciesAfter", STRING, arguments.dependenciesAfter()),
                Argument.of("dependenciesFirst", "Int", arguments.dependenciesFirst()),
                Argument.of("withDependencies", BOOLEAN, arguments.withDependencies()));
    }

    @Override
    public <R> Page<R> dependencyGraphManifests(
            final Paging paging, final Function<DependencyGraphManifestSelector, R> selection) {
        return dependencyGraphManifests(
                paging,
                RepositoryDependencyGraphManifestsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> deployKeys(final Paging paging, final Function<DeployKeySelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "deployKeys",
                child -> selection.apply(new DeployKeySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> deployments(
            final Paging paging,
            final RepositoryDeploymentsFilter arguments,
            final Function<DeploymentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "deployments",
                child -> selection.apply(new DeploymentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("environments", STRING_2, arguments.environments()),
                Argument.of(
                        ORDER_BY,
                        "DeploymentOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> deployments(final Paging paging, final Function<DeploymentSelector, R> selection) {
        return deployments(paging, RepositoryDeploymentsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public String descriptionHTML() {
        return cursor.getRequired("descriptionHTML", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R discussion(final int number, final Function<DiscussionSelector, R> selection) {
        return cursor.object(
                "discussion",
                child -> selection.apply(new DiscussionSelectorImpl(child)),
                Argument.of(NUMBER, INT, number));
    }

    @Override
    public <R> Page<R> discussionCategories(
            final Paging paging,
            final RepositoryDiscussionCategoriesFilter arguments,
            final Function<DiscussionCategorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "discussionCategories",
                child -> selection.apply(new DiscussionCategorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("filterByAssignable", BOOLEAN, arguments.filterByAssignable()));
    }

    @Override
    public <R> Page<R> discussionCategories(
            final Paging paging, final Function<DiscussionCategorySelector, R> selection) {
        return discussionCategories(
                paging, RepositoryDiscussionCategoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R discussionCategory(
            final String slug, final Function<DiscussionCategorySelector, R> selection) {
        requireNonNull(slug, "slug");
        return cursor.object(
                "discussionCategory",
                child -> selection.apply(new DiscussionCategorySelectorImpl(child)),
                Argument.of("slug", STRING_3, slug));
    }

    @Override
    public <R> Page<R> discussions(
            final Paging paging,
            final RepositoryDiscussionsFilter arguments,
            final Function<DiscussionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "discussions",
                child -> selection.apply(new DiscussionSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("answered", BOOLEAN, arguments.answered()),
                Argument.of("categoryId", "ID", arguments.categoryId()),
                Argument.of(
                        ORDER_BY,
                        "DiscussionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(STATES, "[DiscussionState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> discussions(final Paging paging, final Function<DiscussionSelector, R> selection) {
        return discussions(paging, RepositoryDiscussionsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Integer diskUsage() {
        return cursor.get("diskUsage", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R environment(final String name, final Function<EnvironmentSelector, R> selection) {
        requireNonNull(name, NAME);
        return cursor.object(
                "environment",
                child -> selection.apply(new EnvironmentSelectorImpl(child)),
                Argument.of(NAME, STRING_3, name));
    }

    @Override
    public <R> Page<R> environments(
            final Paging paging,
            final RepositoryEnvironmentsFilter arguments,
            final Function<EnvironmentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "environments",
                child -> selection.apply(new EnvironmentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("names", STRING_2, arguments.names()),
                Argument.of(
                        ORDER_BY,
                        "Environments",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(
                        "pinnedEnvironmentFilter",
                        "EnvironmentPinnedFilterField",
                        arguments.pinnedEnvironmentFilter()));
    }

    @Override
    public <R> Page<R> environments(final Paging paging, final Function<EnvironmentSelector, R> selection) {
        return environments(
                paging, RepositoryEnvironmentsFilterBuilder.builder().build(), selection);
    }

    @Override
    public int forkCount() {
        return cursor.getRequired("forkCount", ScalarType.INT);
    }

    @Override
    public boolean forkingAllowed() {
        return cursor.getRequired("forkingAllowed", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> forks(
            final Paging paging,
            final RepositoryForksFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "forks",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("affiliations", "[RepositoryAffiliation]", arguments.affiliations()),
                Argument.of("hasIssuesEnabled", BOOLEAN, arguments.hasIssuesEnabled()),
                Argument.of("isLocked", BOOLEAN, arguments.isLocked()),
                Argument.of(
                        ORDER_BY,
                        "RepositoryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("ownerAffiliations", "[RepositoryAffiliation]", arguments.ownerAffiliations()),
                Argument.of("privacy", "RepositoryPrivacy", arguments.privacy()),
                Argument.of("visibility", "RepositoryVisibility", arguments.visibility()));
    }

    @Override
    public <R> Page<R> forks(final Paging paging, final Function<RepositorySelector, R> selection) {
        return forks(paging, RepositoryForksFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public <R> List<R> fundingLinks(final Function<FundingLinkSelector, R> selection) {
        return cursor.listRequired("fundingLinks", child -> selection.apply(new FundingLinkSelectorImpl(child)));
    }

    @Override
    public boolean hasDiscussionsEnabled() {
        return cursor.getRequired("hasDiscussionsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasIssuesEnabled() {
        return cursor.getRequired("hasIssuesEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasProjectsEnabled() {
        return cursor.getRequired("hasProjectsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasPullRequestsEnabled() {
        return cursor.getRequired("hasPullRequestsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasSponsorshipsEnabled() {
        return cursor.getRequired("hasSponsorshipsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasVulnerabilityAlertsEnabled() {
        return cursor.getRequired("hasVulnerabilityAlertsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasWikiEnabled() {
        return cursor.getRequired("hasWikiEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String homepageUrl() {
        return cursor.get("homepageUrl", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R interactionAbility(final Function<RepositoryInteractionAbilitySelector, R> selection) {
        return cursor.object(
                "interactionAbility", child -> selection.apply(new RepositoryInteractionAbilitySelectorImpl(child)));
    }

    @Override
    public boolean isArchived() {
        return cursor.getRequired("isArchived", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isBlankIssuesEnabled() {
        return cursor.getRequired("isBlankIssuesEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isDisabled() {
        return cursor.getRequired("isDisabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isEmpty() {
        return cursor.getRequired("isEmpty", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isFork() {
        return cursor.getRequired("isFork", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isInOrganization() {
        return cursor.getRequired("isInOrganization", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isLocked() {
        return cursor.getRequired("isLocked", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isMirror() {
        return cursor.getRequired("isMirror", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isPrivate() {
        return cursor.getRequired("isPrivate", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean isSecurityPolicyEnabled() {
        return cursor.get("isSecurityPolicyEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isTemplate() {
        return cursor.getRequired("isTemplate", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isUserConfigurationRepository() {
        return cursor.getRequired("isUserConfigurationRepository", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R issue(final int number, final Function<IssueSelector, R> selection) {
        return cursor.object(
                "issue", child -> selection.apply(new IssueSelectorImpl(child)), Argument.of(NUMBER, INT, number));
    }

    @Override
    public @Nullable IssueCreationPolicy issueCreationPolicy() {
        return cursor.get(
                "issueCreationPolicy", ScalarType.enumeration(IssueCreationPolicy::fromWire, IssueCreationPolicy.ALL));
    }

    @Override
    public <R> Page<R> issueFields(
            final Paging paging,
            final RepositoryIssueFieldsFilter arguments,
            final Function<IssueFieldsSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "issueFields",
                child -> selection.apply(new IssueFieldsSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueFieldOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> issueFields(final Paging paging, final Function<IssueFieldsSelector, R> selection) {
        return issueFields(paging, RepositoryIssueFieldsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R issueOrPullRequest(
            final int number, final Function<IssueOrPullRequestSelector, R> selection) {
        return cursor.object(
                "issueOrPullRequest",
                child -> selection.apply(new IssueOrPullRequestSelectorImpl(child)),
                Argument.of(NUMBER, INT, number));
    }

    @Override
    public <R> List<R> issueTemplates(final Function<IssueTemplateSelector, R> selection) {
        return cursor.list("issueTemplates", child -> selection.apply(new IssueTemplateSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R issueType(final String name, final Function<IssueTypeSelector, R> selection) {
        requireNonNull(name, NAME);
        return cursor.object(
                "issueType",
                child -> selection.apply(new IssueTypeSelectorImpl(child)),
                Argument.of(NAME, STRING_3, name));
    }

    @Override
    public <R> Page<R> issueTypes(
            final Paging paging,
            final RepositoryIssueTypesFilter arguments,
            final Function<IssueTypeSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "issueTypes",
                child -> selection.apply(new IssueTypeSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueTypeOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> issueTypes(final Paging paging, final Function<IssueTypeSelector, R> selection) {
        return issueTypes(paging, RepositoryIssueTypesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> issues(
            final Paging paging, final RepositoryIssuesFilter arguments, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "issues",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        "filterBy",
                        "IssueFilters",
                        arguments.filterBy() == null
                                ? null
                                : arguments.filterBy().toVariable()),
                Argument.of(LABELS, STRING_2, arguments.labels()),
                Argument.of(
                        ORDER_BY,
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(STATES, "[IssueState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> issues(final Paging paging, final Function<IssueSelector, R> selection) {
        return issues(paging, RepositoryIssuesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R label(final String name, final Function<LabelSelector, R> selection) {
        requireNonNull(name, NAME);
        return cursor.object(
                "label", child -> selection.apply(new LabelSelectorImpl(child)), Argument.of(NAME, STRING_3, name));
    }

    @Override
    public <R> Page<R> labels(
            final Paging paging, final RepositoryLabelsFilter arguments, final Function<LabelSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                LABELS,
                child -> selection.apply(new LabelSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "LabelOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> labels(final Paging paging, final Function<LabelSelector, R> selection) {
        return labels(paging, RepositoryLabelsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> languages(
            final Paging paging,
            final RepositoryLanguagesFilter arguments,
            final Function<LanguageSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "languages",
                child -> selection.apply(new LanguageSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "LanguageOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> languages(final Paging paging, final Function<LanguageSelector, R> selection) {
        return languages(paging, RepositoryLanguagesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R latestRelease(final Function<ReleaseSelector, R> selection) {
        return cursor.object("latestRelease", child -> selection.apply(new ReleaseSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R licenseInfo(final Function<LicenseSelector, R> selection) {
        return cursor.object("licenseInfo", child -> selection.apply(new LicenseSelectorImpl(child)));
    }

    @Override
    public @Nullable RepositoryLockReason lockReason() {
        return cursor.get(
                "lockReason", ScalarType.enumeration(RepositoryLockReason::fromWire, RepositoryLockReason.BILLING));
    }

    @Override
    public <R> Page<R> mentionableUsers(
            final Paging paging,
            final RepositoryMentionableUsersFilter arguments,
            final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "mentionableUsers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> mentionableUsers(final Paging paging, final Function<UserSelector, R> selection) {
        return mentionableUsers(
                paging, RepositoryMentionableUsersFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean mergeCommitAllowed() {
        return cursor.getRequired("mergeCommitAllowed", ScalarType.BOOLEAN);
    }

    @Override
    public MergeCommitMessage mergeCommitMessage() {
        return cursor.getRequired(
                "mergeCommitMessage", ScalarType.enumeration(MergeCommitMessage::fromWire, MergeCommitMessage.BLANK));
    }

    @Override
    public MergeCommitTitle mergeCommitTitle() {
        return cursor.getRequired(
                "mergeCommitTitle", ScalarType.enumeration(MergeCommitTitle::fromWire, MergeCommitTitle.MERGE_MESSAGE));
    }

    @Override
    public <R> @Nullable R mergeQueue(
            final RepositoryMergeQueueFilter arguments, final Function<MergeQueueSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "mergeQueue",
                child -> selection.apply(new MergeQueueSelectorImpl(child)),
                Argument.of("branch", STRING, arguments.branch()));
    }

    @Override
    public <R> @Nullable R mergeQueue(final Function<MergeQueueSelector, R> selection) {
        return mergeQueue(RepositoryMergeQueueFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R milestone(final int number, final Function<MilestoneSelector, R> selection) {
        return cursor.object(
                "milestone",
                child -> selection.apply(new MilestoneSelectorImpl(child)),
                Argument.of(NUMBER, INT, number));
    }

    @Override
    public <R> Page<R> milestones(
            final Paging paging,
            final RepositoryMilestonesFilter arguments,
            final Function<MilestoneSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "milestones",
                child -> selection.apply(new MilestoneSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "MilestoneOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of(STATES, "[MilestoneState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> milestones(final Paging paging, final Function<MilestoneSelector, R> selection) {
        return milestones(paging, RepositoryMilestonesFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable String mirrorUrl() {
        return cursor.get("mirrorUrl", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired(NAME, ScalarType.STRING);
    }

    @Override
    public String nameWithOwner() {
        return cursor.getRequired("nameWithOwner", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R object(
            final RepositoryObjectFilter arguments, final Function<GitObjectSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "object",
                child -> selection.apply(new GitObjectSelectorImpl(child)),
                Argument.of("expression", STRING, arguments.expression()),
                Argument.of("oid", "GitObjectID", arguments.oid()));
    }

    @Override
    public <R> @Nullable R object(final Function<GitObjectSelector, R> selection) {
        return object(RepositoryObjectFilterBuilder.builder().build(), selection);
    }

    @Override
    public String openGraphImageUrl() {
        return cursor.getRequired("openGraphImageUrl", ScalarType.STRING);
    }

    @Override
    public <R> R owner(final Function<RepositoryOwnerSelector, R> selection) {
        return cursor.objectRequired("owner", child -> selection.apply(new RepositoryOwnerSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> packages(
            final Paging paging,
            final RepositoryPackagesFilter arguments,
            final Function<PackageSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "packages",
                child -> selection.apply(new PackageSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("names", "[String]", arguments.names()),
                Argument.of(
                        ORDER_BY,
                        "PackageOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("packageType", "PackageType", arguments.packageType()),
                Argument.of("repositoryId", "ID", arguments.repositoryId()));
    }

    @Override
    public <R> Page<R> packages(final Paging paging, final Function<PackageSelector, R> selection) {
        return packages(paging, RepositoryPackagesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R parent(final Function<RepositorySelector, R> selection) {
        return cursor.object("parent", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public <R> Page<R> pinnedDiscussions(final Paging paging, final Function<PinnedDiscussionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "pinnedDiscussions",
                child -> selection.apply(new PinnedDiscussionSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> pinnedEnvironments(
            final Paging paging,
            final RepositoryPinnedEnvironmentsFilter arguments,
            final Function<PinnedEnvironmentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "pinnedEnvironments",
                child -> selection.apply(new PinnedEnvironmentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "PinnedEnvironmentOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> pinnedEnvironments(final Paging paging, final Function<PinnedEnvironmentSelector, R> selection) {
        return pinnedEnvironments(
                paging, RepositoryPinnedEnvironmentsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> pinnedIssues(final Paging paging, final Function<PinnedIssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "pinnedIssues",
                child -> selection.apply(new PinnedIssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> R planFeatures(final Function<RepositoryPlanFeaturesSelector, R> selection) {
        return cursor.objectRequired(
                "planFeatures", child -> selection.apply(new RepositoryPlanFeaturesSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R primaryLanguage(final Function<LanguageSelector, R> selection) {
        return cursor.object("primaryLanguage", child -> selection.apply(new LanguageSelectorImpl(child)));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> @Nullable R project(final int number, final Function<ProjectSelector, R> selection) {
        return cursor.object(
                "project", child -> selection.apply(new ProjectSelectorImpl(child)), Argument.of(NUMBER, INT, number));
    }

    @Override
    public <R> @Nullable R projectV2(final int number, final Function<ProjectV2Selector, R> selection) {
        return cursor.object(
                "projectV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(NUMBER, INT, number));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> projects(
            final Paging paging,
            final RepositoryProjectsFilter arguments,
            final Function<ProjectSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projects",
                child -> selection.apply(new ProjectSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "ProjectOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("search", STRING, arguments.search()),
                Argument.of(STATES, "[ProjectState!]", arguments.states()));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> projects(final Paging paging, final Function<ProjectSelector, R> selection) {
        return projects(paging, RepositoryProjectsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String projectsResourcePath() {
        return cursor.getRequired("projectsResourcePath", ScalarType.STRING);
    }

    @Override
    public String projectsUrl() {
        return cursor.getRequired("projectsUrl", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> projectsV2(
            final Paging paging,
            final RepositoryProjectsV2Filter arguments,
            final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projectsV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("minPermissionLevel", "ProjectV2PermissionLevel", arguments.minPermissionLevel()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2Order",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> projectsV2(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        return projectsV2(paging, RepositoryProjectsV2FilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R pullRequest(final int number, final Function<PullRequestSelector, R> selection) {
        return cursor.object(
                "pullRequest",
                child -> selection.apply(new PullRequestSelectorImpl(child)),
                Argument.of(NUMBER, INT, number));
    }

    @Override
    public <R> @Nullable R pullRequestCreationCapConfig(
            final Function<PullRequestCreationCapConfigSelector, R> selection) {
        return cursor.object(
                "pullRequestCreationCapConfig",
                child -> selection.apply(new PullRequestCreationCapConfigSelectorImpl(child)));
    }

    @Override
    public @Nullable PullRequestCreationPolicy pullRequestCreationPolicy() {
        return cursor.get(
                "pullRequestCreationPolicy",
                ScalarType.enumeration(PullRequestCreationPolicy::fromWire, PullRequestCreationPolicy.ALL));
    }

    @Override
    public <R> List<R> pullRequestTemplates(final Function<PullRequestTemplateSelector, R> selection) {
        return cursor.list(
                "pullRequestTemplates", child -> selection.apply(new PullRequestTemplateSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> pullRequests(
            final Paging paging,
            final RepositoryPullRequestsFilter arguments,
            final Function<PullRequestSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pullRequests",
                child -> selection.apply(new PullRequestSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("baseRefName", STRING, arguments.baseRefName()),
                Argument.of("headRefName", STRING, arguments.headRefName()),
                Argument.of(LABELS, STRING_2, arguments.labels()),
                Argument.of(
                        ORDER_BY,
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(STATES, "[PullRequestState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> pullRequests(final Paging paging, final Function<PullRequestSelector, R> selection) {
        return pullRequests(
                paging, RepositoryPullRequestsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Instant pushedAt() {
        return cursor.get("pushedAt", ScalarType.INSTANT);
    }

    @Override
    public boolean rebaseMergeAllowed() {
        return cursor.getRequired("rebaseMergeAllowed", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> recentProjects(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "recentProjects",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R ref(final String qualifiedName, final Function<RefSelector, R> selection) {
        requireNonNull(qualifiedName, "qualifiedName");
        return cursor.object(
                "ref",
                child -> selection.apply(new RefSelectorImpl(child)),
                Argument.of("qualifiedName", STRING_3, qualifiedName));
    }

    @Override
    public <R> Page<R> refs(
            final String refPrefix,
            final Paging paging,
            final RepositoryRefsFilter arguments,
            final Function<RefSelector, R> selection) {
        requireNonNull(refPrefix, "refPrefix");
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "refs",
                child -> selection.apply(new RefSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("direction", "OrderDirection", arguments.direction()),
                Argument.of(
                        ORDER_BY,
                        "RefOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of(QUERY, STRING, arguments.query()),
                Argument.of("refPrefix", STRING_3, refPrefix));
    }

    @Override
    public <R> Page<R> refs(final String refPrefix, final Paging paging, final Function<RefSelector, R> selection) {
        return refs(refPrefix, paging, RepositoryRefsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R release(final String tagName, final Function<ReleaseSelector, R> selection) {
        requireNonNull(tagName, "tagName");
        return cursor.object(
                "release",
                child -> selection.apply(new ReleaseSelectorImpl(child)),
                Argument.of("tagName", STRING_3, tagName));
    }

    @Override
    public <R> Page<R> releases(
            final Paging paging,
            final RepositoryReleasesFilter arguments,
            final Function<ReleaseSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "releases",
                child -> selection.apply(new ReleaseSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "ReleaseOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> releases(final Paging paging, final Function<ReleaseSelector, R> selection) {
        return releases(paging, RepositoryReleasesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R repositoryCustomPropertyValue(
            final String propertyName, final Function<RepositoryCustomPropertyValueSelector, R> selection) {
        requireNonNull(propertyName, "propertyName");
        return cursor.object(
                "repositoryCustomPropertyValue",
                child -> selection.apply(new RepositoryCustomPropertyValueSelectorImpl(child)),
                Argument.of("propertyName", STRING_3, propertyName));
    }

    @Override
    public <R> Page<R> repositoryCustomPropertyValues(
            final Paging paging, final Function<RepositoryCustomPropertyValueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "repositoryCustomPropertyValues",
                child -> selection.apply(new RepositoryCustomPropertyValueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> repositoryTopics(final Paging paging, final Function<RepositoryTopicSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "repositoryTopics",
                child -> selection.apply(new RepositoryTopicSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R ruleset(
            final int databaseId,
            final RepositoryRulesetFilter arguments,
            final Function<RepositoryRulesetSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "ruleset",
                child -> selection.apply(new RepositoryRulesetSelectorImpl(child)),
                Argument.of("databaseId", INT, databaseId),
                Argument.of("includeParents", BOOLEAN, arguments.includeParents()));
    }

    @Override
    public <R> @Nullable R ruleset(final int databaseId, final Function<RepositoryRulesetSelector, R> selection) {
        return ruleset(databaseId, RepositoryRulesetFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> rulesets(
            final Paging paging,
            final RepositoryRulesetsFilter arguments,
            final Function<RepositoryRulesetSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "rulesets",
                child -> selection.apply(new RepositoryRulesetSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("includeParents", BOOLEAN, arguments.includeParents()),
                Argument.of("targets", "[RepositoryRulesetTarget!]", arguments.targets()));
    }

    @Override
    public <R> Page<R> rulesets(final Paging paging, final Function<RepositoryRulesetSelector, R> selection) {
        return rulesets(paging, RepositoryRulesetsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable String securityPolicyUrl() {
        return cursor.get("securityPolicyUrl", ScalarType.STRING);
    }

    @Override
    public String shortDescriptionHTML(final RepositoryShortDescriptionHTMLFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "shortDescriptionHTML", ScalarType.STRING, Argument.of("limit", "Int", arguments.limit()));
    }

    @Override
    public String shortDescriptionHTML() {
        return shortDescriptionHTML(
                RepositoryShortDescriptionHTMLFilterBuilder.builder().build());
    }

    @Override
    public boolean squashMergeAllowed() {
        return cursor.getRequired("squashMergeAllowed", ScalarType.BOOLEAN);
    }

    @Override
    public SquashMergeCommitMessage squashMergeCommitMessage() {
        return cursor.getRequired(
                "squashMergeCommitMessage",
                ScalarType.enumeration(SquashMergeCommitMessage::fromWire, SquashMergeCommitMessage.BLANK));
    }

    @Override
    public SquashMergeCommitTitle squashMergeCommitTitle() {
        return cursor.getRequired(
                "squashMergeCommitTitle",
                ScalarType.enumeration(SquashMergeCommitTitle::fromWire, SquashMergeCommitTitle.COMMIT_OR_PR_TITLE));
    }

    /**
     * @deprecated `squashPrTitleUsedAsDefault` will be removed. Use `Repository.squashMergeCommitTitle` instead.
     *     Removal on 2023-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public boolean squashPrTitleUsedAsDefault() {
        return cursor.getRequired("squashPrTitleUsedAsDefault", ScalarType.BOOLEAN);
    }

    @Override
    public String sshUrl() {
        return cursor.getRequired("sshUrl", ScalarType.STRING);
    }

    @Override
    public int stargazerCount() {
        return cursor.getRequired("stargazerCount", ScalarType.INT);
    }

    @Override
    public <R> Page<R> stargazers(
            final Paging paging,
            final RepositoryStargazersFilter arguments,
            final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "stargazers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "StarOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> stargazers(final Paging paging, final Function<UserSelector, R> selection) {
        return stargazers(paging, RepositoryStargazersFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> submodules(final Paging paging, final Function<SubmoduleSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "submodules",
                child -> selection.apply(new SubmoduleSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> suggestedActors(
            final List<RepositorySuggestedActorFilter> capabilities,
            final Paging paging,
            final RepositorySuggestedActorsFilter arguments,
            final Function<ActorSelector, R> selection) {
        requireNonNull(capabilities, "capabilities");
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "suggestedActors",
                child -> selection.apply(new ActorSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("capabilities", "[RepositorySuggestedActorFilter!]!", capabilities),
                Argument.of("loginNames", STRING, arguments.loginNames()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> suggestedActors(
            final List<RepositorySuggestedActorFilter> capabilities,
            final Paging paging,
            final Function<ActorSelector, R> selection) {
        return suggestedActors(
                capabilities,
                paging,
                RepositorySuggestedActorsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public @Nullable String tempCloneToken() {
        return cursor.get("tempCloneToken", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R templateRepository(final Function<RepositorySelector, R> selection) {
        return cursor.object("templateRepository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public boolean usesCustomOpenGraphImage() {
        return cursor.getRequired("usesCustomOpenGraphImage", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanAdminister() {
        return cursor.getRequired("viewerCanAdminister", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanCreateIssues() {
        return cursor.getRequired("viewerCanCreateIssues", ScalarType.BOOLEAN);
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public boolean viewerCanCreateProjects() {
        return cursor.getRequired("viewerCanCreateProjects", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanSeeIssueFields() {
        return cursor.getRequired("viewerCanSeeIssueFields", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanSubscribe() {
        return cursor.getRequired("viewerCanSubscribe", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanUpdateTopics() {
        return cursor.getRequired("viewerCanUpdateTopics", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R viewerContentWarning(final Function<ContentWarningSelector, R> selection) {
        return cursor.object("viewerContentWarning", child -> selection.apply(new ContentWarningSelectorImpl(child)));
    }

    @Override
    public @Nullable String viewerDefaultCommitEmail() {
        return cursor.get("viewerDefaultCommitEmail", ScalarType.STRING);
    }

    @Override
    public PullRequestMergeMethod viewerDefaultMergeMethod() {
        return cursor.getRequired(
                "viewerDefaultMergeMethod",
                ScalarType.enumeration(PullRequestMergeMethod::fromWire, PullRequestMergeMethod.MERGE));
    }

    @Override
    public boolean viewerHasStarred() {
        return cursor.getRequired("viewerHasStarred", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable RepositoryPermission viewerPermission() {
        return cursor.get(
                "viewerPermission", ScalarType.enumeration(RepositoryPermission::fromWire, RepositoryPermission.ADMIN));
    }

    @Override
    public List<String> viewerPossibleCommitEmails() {
        return cursor.scalarList("viewerPossibleCommitEmails", ScalarType.STRING);
    }

    @Override
    public @Nullable SubscriptionState viewerSubscription() {
        return cursor.get(
                "viewerSubscription", ScalarType.enumeration(SubscriptionState::fromWire, SubscriptionState.IGNORED));
    }

    @Override
    public RepositoryVisibility visibility() {
        return cursor.getRequired(
                "visibility", ScalarType.enumeration(RepositoryVisibility::fromWire, RepositoryVisibility.INTERNAL));
    }

    @Override
    public <R> @Nullable R vulnerabilityAlert(
            final int number, final Function<RepositoryVulnerabilityAlertSelector, R> selection) {
        return cursor.object(
                "vulnerabilityAlert",
                child -> selection.apply(new RepositoryVulnerabilityAlertSelectorImpl(child)),
                Argument.of(NUMBER, INT, number));
    }

    @Override
    public <R> Page<R> vulnerabilityAlerts(
            final Paging paging,
            final RepositoryVulnerabilityAlertsFilter arguments,
            final Function<RepositoryVulnerabilityAlertSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "vulnerabilityAlerts",
                child -> selection.apply(new RepositoryVulnerabilityAlertSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("classifications", "[SecurityAdvisoryClassification!]", arguments.classifications()),
                Argument.of(
                        "dependencyScopes",
                        "[RepositoryVulnerabilityAlertDependencyScope!]",
                        arguments.dependencyScopes()),
                Argument.of(STATES, "[RepositoryVulnerabilityAlertState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> vulnerabilityAlerts(
            final Paging paging, final Function<RepositoryVulnerabilityAlertSelector, R> selection) {
        return vulnerabilityAlerts(
                paging, RepositoryVulnerabilityAlertsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> watchers(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "watchers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public boolean webCommitSignoffRequired() {
        return cursor.getRequired("webCommitSignoffRequired", ScalarType.BOOLEAN);
    }
}
