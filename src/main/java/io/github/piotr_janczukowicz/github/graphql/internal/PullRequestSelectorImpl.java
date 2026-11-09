package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssigneeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutoMergeRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.HovercardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeStateStatus;
import io.github.piotr_janczukowicz.github.graphql.model.MergeableState;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestChangedFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestClosingIssuesReferencesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestClosingIssuesReferencesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestHovercardFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestHovercardFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestLabelsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestLatestOpinionatedReviewsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestLatestOpinionatedReviewsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestProjectCardsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestProjectCardsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestProjectItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestProjectItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestProjectsV2Filter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReactionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewDecision;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewThreadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSuggestedActorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSuggestedActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSuggestedReviewerActorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSuggestedReviewerActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestViewerMergeBodyTextFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestViewerMergeBodyTextFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestViewerMergeHeadlineTextFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestViewerMergeHeadlineTextFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusCheckRollupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.SuggestedReviewerActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SuggestedReviewerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequest}; used by the generated selection code only. */
final class PullRequestSelectorImpl implements PullRequestSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ARGUMENTS = "arguments";

    private static final String BOOLEAN = "Boolean";

    private static final String ORDER_BY = "orderBy";

    private static final String REMOVAL = "removal";

    private static final String QUERY = "query";

    private final Cursor cursor;

    PullRequestSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable LockReason activeLockReason() {
        return cursor.get("activeLockReason", ScalarType.enumeration(LockReason::fromWire, LockReason.OFF_TOPIC));
    }

    @Override
    public int additions() {
        return cursor.getRequired("additions", ScalarType.INT);
    }

    @Override
    public <R> Page<R> assignedActors(final Paging paging, final Function<AssigneeSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "assignedActors",
                child -> selection.apply(new AssigneeSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> assignees(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "assignees",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R author(final Function<ActorSelector, R> selection) {
        return cursor.object("author", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public CommentAuthorAssociation authorAssociation() {
        return cursor.getRequired(
                "authorAssociation",
                ScalarType.enumeration(CommentAuthorAssociation::fromWire, CommentAuthorAssociation.COLLABORATOR));
    }

    @Override
    public <R> @Nullable R autoMergeRequest(final Function<AutoMergeRequestSelector, R> selection) {
        return cursor.object("autoMergeRequest", child -> selection.apply(new AutoMergeRequestSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R baseRef(final Function<RefSelector, R> selection) {
        return cursor.object("baseRef", child -> selection.apply(new RefSelectorImpl(child)));
    }

    @Override
    public String baseRefName() {
        return cursor.getRequired("baseRefName", ScalarType.STRING);
    }

    @Override
    public String baseRefOid() {
        return cursor.getRequired("baseRefOid", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R baseRepository(final Function<RepositorySelector, R> selection) {
        return cursor.object("baseRepository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String body() {
        return cursor.getRequired("body", ScalarType.STRING);
    }

    @Override
    public String bodyHTML() {
        return cursor.getRequired("bodyHTML", ScalarType.STRING);
    }

    @Override
    public String bodyText() {
        return cursor.getRequired("bodyText", ScalarType.STRING);
    }

    @Override
    public boolean canBeRebased() {
        return cursor.getRequired("canBeRebased", ScalarType.BOOLEAN);
    }

    @Override
    public int changedFiles() {
        return cursor.getRequired("changedFiles", ScalarType.INT);
    }

    @Override
    public String checksResourcePath() {
        return cursor.getRequired("checksResourcePath", ScalarType.STRING);
    }

    @Override
    public String checksUrl() {
        return cursor.getRequired("checksUrl", ScalarType.STRING);
    }

    @Override
    public boolean closed() {
        return cursor.getRequired("closed", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Instant closedAt() {
        return cursor.get("closedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> closingIssuesReferences(
            final Paging paging,
            final PullRequestClosingIssuesReferencesFilter arguments,
            final Function<IssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "closingIssuesReferences",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("excludeUserLinked", BOOLEAN, arguments.excludeUserLinked()),
                Argument.of(
                        ORDER_BY,
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("userLinkedOnly", BOOLEAN, arguments.userLinkedOnly()));
    }

    @Override
    public <R> Page<R> closingIssuesReferences(final Paging paging, final Function<IssueSelector, R> selection) {
        return closingIssuesReferences(
                paging,
                PullRequestClosingIssuesReferencesFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> comments(
            final Paging paging,
            final PullRequestCommentsFilter arguments,
            final Function<IssueCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "comments",
                child -> selection.apply(new IssueCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueCommentOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> comments(final Paging paging, final Function<IssueCommentSelector, R> selection) {
        return comments(paging, PullRequestCommentsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> commits(final Paging paging, final Function<PullRequestCommitSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "commits",
                child -> selection.apply(new PullRequestCommitSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public boolean createdViaEmail() {
        return cursor.getRequired("createdViaEmail", ScalarType.BOOLEAN);
    }

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2024-07-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public int deletions() {
        return cursor.getRequired("deletions", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R editor(final Function<ActorSelector, R> selection) {
        return cursor.object("editor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> files(final Paging paging, final Function<PullRequestChangedFileSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "files",
                child -> selection.apply(new PullRequestChangedFileSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public <R> @Nullable R headRef(final Function<RefSelector, R> selection) {
        return cursor.object("headRef", child -> selection.apply(new RefSelectorImpl(child)));
    }

    @Override
    public String headRefName() {
        return cursor.getRequired("headRefName", ScalarType.STRING);
    }

    @Override
    public String headRefOid() {
        return cursor.getRequired("headRefOid", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R headRepository(final Function<RepositorySelector, R> selection) {
        return cursor.object("headRepository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R headRepositoryOwner(final Function<RepositoryOwnerSelector, R> selection) {
        return cursor.object("headRepositoryOwner", child -> selection.apply(new RepositoryOwnerSelectorImpl(child)));
    }

    @Override
    public <R> R hovercard(final PullRequestHovercardFilter arguments, final Function<HovercardSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.objectRequired(
                "hovercard",
                child -> selection.apply(new HovercardSelectorImpl(child)),
                Argument.of("includeNotificationContexts", BOOLEAN, arguments.includeNotificationContexts()));
    }

    @Override
    public <R> R hovercard(final Function<HovercardSelector, R> selection) {
        return hovercard(PullRequestHovercardFilterBuilder.builder().build(), selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean includesCreatedEdit() {
        return cursor.getRequired("includesCreatedEdit", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isCrossRepository() {
        return cursor.getRequired("isCrossRepository", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isDraft() {
        return cursor.getRequired("isDraft", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isInMergeQueue() {
        return cursor.getRequired("isInMergeQueue", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isMergeQueueEnabled() {
        return cursor.getRequired("isMergeQueueEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean isReadByViewer() {
        return cursor.get("isReadByViewer", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> labels(
            final Paging paging, final PullRequestLabelsFilter arguments, final Function<LabelSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "labels",
                child -> selection.apply(new LabelSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "LabelOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> labels(final Paging paging, final Function<LabelSelector, R> selection) {
        return labels(paging, PullRequestLabelsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Instant lastEditedAt() {
        return cursor.get("lastEditedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> latestOpinionatedReviews(
            final Paging paging,
            final PullRequestLatestOpinionatedReviewsFilter arguments,
            final Function<PullRequestReviewSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "latestOpinionatedReviews",
                child -> selection.apply(new PullRequestReviewSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("writersOnly", BOOLEAN, arguments.writersOnly()));
    }

    @Override
    public <R> Page<R> latestOpinionatedReviews(
            final Paging paging, final Function<PullRequestReviewSelector, R> selection) {
        return latestOpinionatedReviews(
                paging,
                PullRequestLatestOpinionatedReviewsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> latestReviews(final Paging paging, final Function<PullRequestReviewSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "latestReviews",
                child -> selection.apply(new PullRequestReviewSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public boolean locked() {
        return cursor.getRequired("locked", ScalarType.BOOLEAN);
    }

    @Override
    public boolean maintainerCanModify() {
        return cursor.getRequired("maintainerCanModify", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R mergeCommit(final Function<CommitSelector, R> selection) {
        return cursor.object("mergeCommit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R mergeQueue(final Function<MergeQueueSelector, R> selection) {
        return cursor.object("mergeQueue", child -> selection.apply(new MergeQueueSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R mergeQueueEntry(final Function<MergeQueueEntrySelector, R> selection) {
        return cursor.object("mergeQueueEntry", child -> selection.apply(new MergeQueueEntrySelectorImpl(child)));
    }

    @Override
    public MergeStateStatus mergeStateStatus() {
        return cursor.getRequired(
                "mergeStateStatus", ScalarType.enumeration(MergeStateStatus::fromWire, MergeStateStatus.BEHIND));
    }

    @Override
    public MergeableState mergeable() {
        return cursor.getRequired(
                "mergeable", ScalarType.enumeration(MergeableState::fromWire, MergeableState.CONFLICTING));
    }

    @Override
    public boolean merged() {
        return cursor.getRequired("merged", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Instant mergedAt() {
        return cursor.get("mergedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R mergedBy(final Function<ActorSelector, R> selection) {
        return cursor.object("mergedBy", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R milestone(final Function<MilestoneSelector, R> selection) {
        return cursor.object("milestone", child -> selection.apply(new MilestoneSelectorImpl(child)));
    }

    @Override
    public int number() {
        return cursor.getRequired("number", ScalarType.INT);
    }

    @Override
    public <R> Page<R> participants(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "participants",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public String permalink() {
        return cursor.getRequired("permalink", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R potentialMergeCommit(final Function<CommitSelector, R> selection) {
        return cursor.object("potentialMergeCommit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> projectCards(
            final Paging paging,
            final PullRequestProjectCardsFilter arguments,
            final Function<ProjectCardSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projectCards",
                child -> selection.apply(new ProjectCardSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("archivedStates", "[ProjectCardArchivedState]", arguments.archivedStates()));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> projectCards(final Paging paging, final Function<ProjectCardSelector, R> selection) {
        return projectCards(
                paging, PullRequestProjectCardsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> projectItems(
            final Paging paging,
            final PullRequestProjectItemsFilter arguments,
            final Function<ProjectV2ItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "projectItems",
                child -> selection.apply(new ProjectV2ItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("includeArchived", BOOLEAN, arguments.includeArchived()));
    }

    @Override
    public <R> Page<R> projectItems(final Paging paging, final Function<ProjectV2ItemSelector, R> selection) {
        return projectItems(
                paging, PullRequestProjectItemsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R projectV2(final int number, final Function<ProjectV2Selector, R> selection) {
        return cursor.object(
                "projectV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of("number", INT, number));
    }

    @Override
    public <R> Page<R> projectsV2(
            final Paging paging,
            final PullRequestProjectsV2Filter arguments,
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
        return projectsV2(paging, PullRequestProjectsV2FilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Instant publishedAt() {
        return cursor.get("publishedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> List<R> reactionGroups(final Function<ReactionGroupSelector, R> selection) {
        return cursor.list("reactionGroups", child -> selection.apply(new ReactionGroupSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> reactions(
            final Paging paging,
            final PullRequestReactionsFilter arguments,
            final Function<ReactionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "reactions",
                child -> selection.apply(new ReactionSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("content", "ReactionContent", arguments.content()),
                Argument.of(
                        ORDER_BY,
                        "ReactionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> reactions(final Paging paging, final Function<ReactionSelector, R> selection) {
        return reactions(paging, PullRequestReactionsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public String revertResourcePath() {
        return cursor.getRequired("revertResourcePath", ScalarType.STRING);
    }

    @Override
    public String revertUrl() {
        return cursor.getRequired("revertUrl", ScalarType.STRING);
    }

    @Override
    public @Nullable PullRequestReviewDecision reviewDecision() {
        return cursor.get(
                "reviewDecision",
                ScalarType.enumeration(PullRequestReviewDecision::fromWire, PullRequestReviewDecision.APPROVED));
    }

    @Override
    public <R> Page<R> reviewRequests(final Paging paging, final Function<ReviewRequestSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "reviewRequests",
                child -> selection.apply(new ReviewRequestSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> reviewThreads(
            final Paging paging, final Function<PullRequestReviewThreadSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "reviewThreads",
                child -> selection.apply(new PullRequestReviewThreadSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> reviews(
            final Paging paging,
            final PullRequestReviewsFilter arguments,
            final Function<PullRequestReviewSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "reviews",
                child -> selection.apply(new PullRequestReviewSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("author", STRING, arguments.author()),
                Argument.of("states", "[PullRequestReviewState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> reviews(final Paging paging, final Function<PullRequestReviewSelector, R> selection) {
        return reviews(paging, PullRequestReviewsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R stack(final Function<PullRequestStackSelector, R> selection) {
        return cursor.object("stack", child -> selection.apply(new PullRequestStackSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R stackEntry(final Function<PullRequestStackEntrySelector, R> selection) {
        return cursor.object("stackEntry", child -> selection.apply(new PullRequestStackEntrySelectorImpl(child)));
    }

    @Override
    public PullRequestState state() {
        return cursor.getRequired("state", ScalarType.enumeration(PullRequestState::fromWire, PullRequestState.CLOSED));
    }

    @Override
    public <R> @Nullable R statusCheckRollup(final Function<StatusCheckRollupSelector, R> selection) {
        return cursor.object("statusCheckRollup", child -> selection.apply(new StatusCheckRollupSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> suggestedActors(
            final Paging paging,
            final PullRequestSuggestedActorsFilter arguments,
            final Function<AssigneeSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "suggestedActors",
                child -> selection.apply(new AssigneeSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> suggestedActors(final Paging paging, final Function<AssigneeSelector, R> selection) {
        return suggestedActors(
                paging, PullRequestSuggestedActorsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> suggestedReviewerActors(
            final Paging paging,
            final PullRequestSuggestedReviewerActorsFilter arguments,
            final Function<SuggestedReviewerActorSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "suggestedReviewerActors",
                child -> selection.apply(new SuggestedReviewerActorSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(QUERY, STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> suggestedReviewerActors(
            final Paging paging, final Function<SuggestedReviewerActorSelector, R> selection) {
        return suggestedReviewerActors(
                paging,
                PullRequestSuggestedReviewerActorsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> List<R> suggestedReviewers(final Function<SuggestedReviewerSelector, R> selection) {
        return cursor.listRequired(
                "suggestedReviewers", child -> selection.apply(new SuggestedReviewerSelectorImpl(child)));
    }

    /** @deprecated `timeline` will be removed Use PullRequest.timelineItems instead. Removal on 2020-10-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> timeline(
            final Paging paging,
            final PullRequestTimelineFilter arguments,
            final Function<PullRequestTimelineItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "timeline",
                child -> selection.apply(new PullRequestTimelineItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("since", "DateTime", arguments.since()));
    }

    /** @deprecated `timeline` will be removed Use PullRequest.timelineItems instead. Removal on 2020-10-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> timeline(final Paging paging, final Function<PullRequestTimelineItemSelector, R> selection) {
        return timeline(paging, PullRequestTimelineFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> timelineItems(
            final Paging paging,
            final PullRequestTimelineItemsFilter arguments,
            final Function<PullRequestTimelineItemsSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "timelineItems",
                child -> selection.apply(new PullRequestTimelineItemsSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("itemTypes", "[PullRequestTimelineItemsItemType!]", arguments.itemTypes()),
                Argument.of("since", "DateTime", arguments.since()),
                Argument.of("skip", "Int", arguments.skip()));
    }

    @Override
    public <R> Page<R> timelineItems(
            final Paging paging, final Function<PullRequestTimelineItemsSelector, R> selection) {
        return timelineItems(
                paging, PullRequestTimelineItemsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }

    @Override
    public String titleHTML() {
        return cursor.getRequired("titleHTML", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer totalCommentsCount() {
        return cursor.get("totalCommentsCount", ScalarType.INT);
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
    public <R> Page<R> userContentEdits(final Paging paging, final Function<UserContentEditSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "userContentEdits",
                child -> selection.apply(new UserContentEditSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public boolean viewerCanApplySuggestion() {
        return cursor.getRequired("viewerCanApplySuggestion", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanAssign() {
        return cursor.getRequired("viewerCanAssign", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanClose() {
        return cursor.getRequired("viewerCanClose", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanDeleteHeadRef() {
        return cursor.getRequired("viewerCanDeleteHeadRef", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanDisableAutoMerge() {
        return cursor.getRequired("viewerCanDisableAutoMerge", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanEditFiles() {
        return cursor.getRequired("viewerCanEditFiles", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanEnableAutoMerge() {
        return cursor.getRequired("viewerCanEnableAutoMerge", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanLabel() {
        return cursor.getRequired("viewerCanLabel", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanMergeAsAdmin() {
        return cursor.getRequired("viewerCanMergeAsAdmin", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReact() {
        return cursor.getRequired("viewerCanReact", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReopen() {
        return cursor.getRequired("viewerCanReopen", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanSubscribe() {
        return cursor.getRequired("viewerCanSubscribe", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanUpdate() {
        return cursor.getRequired("viewerCanUpdate", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanUpdateBranch() {
        return cursor.getRequired("viewerCanUpdateBranch", ScalarType.BOOLEAN);
    }

    @Override
    public List<CommentCannotUpdateReason> viewerCannotUpdateReasons() {
        return cursor.scalarListRequired(
                "viewerCannotUpdateReasons",
                ScalarType.enumeration(CommentCannotUpdateReason::fromWire, CommentCannotUpdateReason.ARCHIVED));
    }

    @Override
    public boolean viewerDidAuthor() {
        return cursor.getRequired("viewerDidAuthor", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R viewerLatestReview(final Function<PullRequestReviewSelector, R> selection) {
        return cursor.object("viewerLatestReview", child -> selection.apply(new PullRequestReviewSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R viewerLatestReviewRequest(final Function<ReviewRequestSelector, R> selection) {
        return cursor.object(
                "viewerLatestReviewRequest", child -> selection.apply(new ReviewRequestSelectorImpl(child)));
    }

    @Override
    public String viewerMergeBodyText(final PullRequestViewerMergeBodyTextFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "viewerMergeBodyText",
                ScalarType.STRING,
                Argument.of("mergeType", "PullRequestMergeMethod", arguments.mergeType()));
    }

    @Override
    public String viewerMergeBodyText() {
        return viewerMergeBodyText(
                PullRequestViewerMergeBodyTextFilterBuilder.builder().build());
    }

    @Override
    public String viewerMergeHeadlineText(final PullRequestViewerMergeHeadlineTextFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "viewerMergeHeadlineText",
                ScalarType.STRING,
                Argument.of("mergeType", "PullRequestMergeMethod", arguments.mergeType()));
    }

    @Override
    public String viewerMergeHeadlineText() {
        return viewerMergeHeadlineText(
                PullRequestViewerMergeHeadlineTextFilterBuilder.builder().build());
    }

    @Override
    public @Nullable SubscriptionState viewerSubscription() {
        return cursor.get(
                "viewerSubscription", ScalarType.enumeration(SubscriptionState::fromWire, SubscriptionState.IGNORED));
    }
}
