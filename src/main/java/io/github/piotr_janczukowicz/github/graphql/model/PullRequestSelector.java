package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequest}. */
public interface PullRequestSelector {

    @Nullable LockReason activeLockReason();

    int additions();

    <R> Page<R> assignedActors(Paging paging, Function<AssigneeSelector, R> selection);

    <R> Page<R> assignees(Paging paging, Function<UserSelector, R> selection);

    <R> @Nullable R author(Function<ActorSelector, R> selection);

    CommentAuthorAssociation authorAssociation();

    <R> @Nullable R autoMergeRequest(Function<AutoMergeRequestSelector, R> selection);

    <R> @Nullable R baseRef(Function<RefSelector, R> selection);

    String baseRefName();

    String baseRefOid();

    <R> @Nullable R baseRepository(Function<RepositorySelector, R> selection);

    String body();

    String bodyHTML();

    String bodyText();

    boolean canBeRebased();

    int changedFiles();

    String checksResourcePath();

    String checksUrl();

    boolean closed();

    @Nullable Instant closedAt();

    <R> Page<R> closingIssuesReferences(
            Paging paging, PullRequestClosingIssuesReferencesFilter arguments, Function<IssueSelector, R> selection);

    <R> Page<R> closingIssuesReferences(Paging paging, Function<IssueSelector, R> selection);

    <R> Page<R> comments(
            Paging paging, PullRequestCommentsFilter arguments, Function<IssueCommentSelector, R> selection);

    <R> Page<R> comments(Paging paging, Function<IssueCommentSelector, R> selection);

    <R> Page<R> commits(Paging paging, Function<PullRequestCommitSelector, R> selection);

    Instant createdAt();

    boolean createdViaEmail();

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2024-07-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    int deletions();

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    <R> Page<R> files(Paging paging, Function<PullRequestChangedFileSelector, R> selection);

    @Nullable BigInteger fullDatabaseId();

    <R> @Nullable R headRef(Function<RefSelector, R> selection);

    String headRefName();

    String headRefOid();

    <R> @Nullable R headRepository(Function<RepositorySelector, R> selection);

    <R> @Nullable R headRepositoryOwner(Function<RepositoryOwnerSelector, R> selection);

    <R> R hovercard(PullRequestHovercardFilter arguments, Function<HovercardSelector, R> selection);

    <R> R hovercard(Function<HovercardSelector, R> selection);

    String id();

    boolean includesCreatedEdit();

    boolean isCrossRepository();

    boolean isDraft();

    boolean isInMergeQueue();

    boolean isMergeQueueEnabled();

    @Nullable Boolean isReadByViewer();

    <R> Page<R> labels(Paging paging, PullRequestLabelsFilter arguments, Function<LabelSelector, R> selection);

    <R> Page<R> labels(Paging paging, Function<LabelSelector, R> selection);

    @Nullable Instant lastEditedAt();

    <R> Page<R> latestOpinionatedReviews(
            Paging paging,
            PullRequestLatestOpinionatedReviewsFilter arguments,
            Function<PullRequestReviewSelector, R> selection);

    <R> Page<R> latestOpinionatedReviews(Paging paging, Function<PullRequestReviewSelector, R> selection);

    <R> Page<R> latestReviews(Paging paging, Function<PullRequestReviewSelector, R> selection);

    boolean locked();

    boolean maintainerCanModify();

    <R> @Nullable R mergeCommit(Function<CommitSelector, R> selection);

    <R> @Nullable R mergeQueue(Function<MergeQueueSelector, R> selection);

    <R> @Nullable R mergeQueueEntry(Function<MergeQueueEntrySelector, R> selection);

    MergeStateStatus mergeStateStatus();

    MergeableState mergeable();

    boolean merged();

    @Nullable Instant mergedAt();

    <R> @Nullable R mergedBy(Function<ActorSelector, R> selection);

    <R> @Nullable R milestone(Function<MilestoneSelector, R> selection);

    int number();

    <R> Page<R> participants(Paging paging, Function<UserSelector, R> selection);

    String permalink();

    <R> @Nullable R potentialMergeCommit(Function<CommitSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> projectCards(
            Paging paging, PullRequestProjectCardsFilter arguments, Function<ProjectCardSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> projectCards(Paging paging, Function<ProjectCardSelector, R> selection);

    <R> Page<R> projectItems(
            Paging paging, PullRequestProjectItemsFilter arguments, Function<ProjectV2ItemSelector, R> selection);

    <R> Page<R> projectItems(Paging paging, Function<ProjectV2ItemSelector, R> selection);

    <R> @Nullable R projectV2(int number, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(
            Paging paging, PullRequestProjectsV2Filter arguments, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(Paging paging, Function<ProjectV2Selector, R> selection);

    @Nullable Instant publishedAt();

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> Page<R> reactions(Paging paging, PullRequestReactionsFilter arguments, Function<ReactionSelector, R> selection);

    <R> Page<R> reactions(Paging paging, Function<ReactionSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    String revertResourcePath();

    String revertUrl();

    @Nullable PullRequestReviewDecision reviewDecision();

    <R> Page<R> reviewRequests(Paging paging, Function<ReviewRequestSelector, R> selection);

    <R> Page<R> reviewThreads(Paging paging, Function<PullRequestReviewThreadSelector, R> selection);

    <R> Page<R> reviews(
            Paging paging, PullRequestReviewsFilter arguments, Function<PullRequestReviewSelector, R> selection);

    <R> Page<R> reviews(Paging paging, Function<PullRequestReviewSelector, R> selection);

    <R> @Nullable R stack(Function<PullRequestStackSelector, R> selection);

    <R> @Nullable R stackEntry(Function<PullRequestStackEntrySelector, R> selection);

    PullRequestState state();

    <R> @Nullable R statusCheckRollup(Function<StatusCheckRollupSelector, R> selection);

    <R> Page<R> suggestedActors(
            Paging paging, PullRequestSuggestedActorsFilter arguments, Function<AssigneeSelector, R> selection);

    <R> Page<R> suggestedActors(Paging paging, Function<AssigneeSelector, R> selection);

    <R> Page<R> suggestedReviewerActors(
            Paging paging,
            PullRequestSuggestedReviewerActorsFilter arguments,
            Function<SuggestedReviewerActorSelector, R> selection);

    <R> Page<R> suggestedReviewerActors(Paging paging, Function<SuggestedReviewerActorSelector, R> selection);

    <R> List<R> suggestedReviewers(Function<SuggestedReviewerSelector, R> selection);

    /** @deprecated `timeline` will be removed Use PullRequest.timelineItems instead. Removal on 2020-10-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> Page<R> timeline(
            Paging paging, PullRequestTimelineFilter arguments, Function<PullRequestTimelineItemSelector, R> selection);

    /** @deprecated `timeline` will be removed Use PullRequest.timelineItems instead. Removal on 2020-10-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> Page<R> timeline(Paging paging, Function<PullRequestTimelineItemSelector, R> selection);

    <R> Page<R> timelineItems(
            Paging paging,
            PullRequestTimelineItemsFilter arguments,
            Function<PullRequestTimelineItemsSelector, R> selection);

    <R> Page<R> timelineItems(Paging paging, Function<PullRequestTimelineItemsSelector, R> selection);

    String title();

    String titleHTML();

    @Nullable Integer totalCommentsCount();

    Instant updatedAt();

    String url();

    <R> Page<R> userContentEdits(Paging paging, Function<UserContentEditSelector, R> selection);

    boolean viewerCanApplySuggestion();

    boolean viewerCanAssign();

    boolean viewerCanClose();

    boolean viewerCanDeleteHeadRef();

    boolean viewerCanDisableAutoMerge();

    boolean viewerCanEditFiles();

    boolean viewerCanEnableAutoMerge();

    boolean viewerCanLabel();

    boolean viewerCanMergeAsAdmin();

    boolean viewerCanReact();

    boolean viewerCanReopen();

    boolean viewerCanSubscribe();

    boolean viewerCanUpdate();

    boolean viewerCanUpdateBranch();

    List<CommentCannotUpdateReason> viewerCannotUpdateReasons();

    boolean viewerDidAuthor();

    <R> @Nullable R viewerLatestReview(Function<PullRequestReviewSelector, R> selection);

    <R> @Nullable R viewerLatestReviewRequest(Function<ReviewRequestSelector, R> selection);

    String viewerMergeBodyText(PullRequestViewerMergeBodyTextFilter arguments);

    String viewerMergeBodyText();

    String viewerMergeHeadlineText(PullRequestViewerMergeHeadlineTextFilter arguments);

    String viewerMergeHeadlineText();

    @Nullable SubscriptionState viewerSubscription();
}
