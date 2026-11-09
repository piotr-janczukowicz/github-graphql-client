package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Issue}. */
public interface IssueSelector {

    @Nullable LockReason activeLockReason();

    <R> Page<R> assignedActors(Paging paging, Function<AssigneeSelector, R> selection);

    <R> Page<R> assignees(Paging paging, Function<UserSelector, R> selection);

    <R> @Nullable R author(Function<ActorSelector, R> selection);

    CommentAuthorAssociation authorAssociation();

    <R> Page<R> blockedBy(Paging paging, IssueBlockedByFilter arguments, Function<IssueSelector, R> selection);

    <R> Page<R> blockedBy(Paging paging, Function<IssueSelector, R> selection);

    <R> Page<R> blocking(Paging paging, IssueBlockingFilter arguments, Function<IssueSelector, R> selection);

    <R> Page<R> blocking(Paging paging, Function<IssueSelector, R> selection);

    String body();

    String bodyHTML();

    String bodyResourcePath();

    String bodyText();

    String bodyUrl();

    boolean closed();

    @Nullable Instant closedAt();

    <R> Page<R> closedByPullRequestsReferences(
            Paging paging,
            IssueClosedByPullRequestsReferencesFilter arguments,
            Function<PullRequestSelector, R> selection);

    <R> Page<R> closedByPullRequestsReferences(Paging paging, Function<PullRequestSelector, R> selection);

    <R> Page<R> comments(Paging paging, IssueCommentsFilter arguments, Function<IssueCommentSelector, R> selection);

    <R> Page<R> comments(Paging paging, Function<IssueCommentSelector, R> selection);

    Instant createdAt();

    boolean createdViaEmail();

    @Nullable Integer databaseId();

    <R> @Nullable R duplicateOf(Function<IssueSelector, R> selection);

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    @Nullable BigInteger fullDatabaseId();

    <R> R hovercard(IssueHovercardFilter arguments, Function<HovercardSelector, R> selection);

    <R> R hovercard(Function<HovercardSelector, R> selection);

    String id();

    boolean includesCreatedEdit();

    @Nullable Boolean isPinned();

    @Nullable Boolean isReadByViewer();

    <R> R issueDependenciesSummary(Function<IssueDependenciesSummarySelector, R> selection);

    <R> Page<R> issueFieldValues(Paging paging, Function<IssueFieldValueSelector, R> selection);

    <R> @Nullable R issueType(Function<IssueTypeSelector, R> selection);

    <R> Page<R> labels(Paging paging, IssueLabelsFilter arguments, Function<LabelSelector, R> selection);

    <R> Page<R> labels(Paging paging, Function<LabelSelector, R> selection);

    @Nullable Instant lastEditedAt();

    <R> Page<R> linkedBranches(Paging paging, Function<LinkedBranchSelector, R> selection);

    boolean locked();

    <R> @Nullable R milestone(Function<MilestoneSelector, R> selection);

    int number();

    <R> @Nullable R parent(Function<IssueSelector, R> selection);

    <R> Page<R> participants(Paging paging, Function<UserSelector, R> selection);

    <R> List<R> pendingSuggestions(Function<PendingIssueSuggestionSelector, R> selection);

    <R> @Nullable R pinnedIssueComment(Function<PinnedIssueCommentSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> projectCards(
            Paging paging, IssueProjectCardsFilter arguments, Function<ProjectCardSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> projectCards(Paging paging, Function<ProjectCardSelector, R> selection);

    <R> Page<R> projectItems(
            Paging paging, IssueProjectItemsFilter arguments, Function<ProjectV2ItemSelector, R> selection);

    <R> Page<R> projectItems(Paging paging, Function<ProjectV2ItemSelector, R> selection);

    <R> @Nullable R projectV2(int number, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(Paging paging, IssueProjectsV2Filter arguments, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(Paging paging, Function<ProjectV2Selector, R> selection);

    @Nullable Instant publishedAt();

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> Page<R> reactions(Paging paging, IssueReactionsFilter arguments, Function<ReactionSelector, R> selection);

    <R> Page<R> reactions(Paging paging, Function<ReactionSelector, R> selection);

    <R> Page<R> relatesTo(Paging paging, IssueRelatesToFilter arguments, Function<IssueSelector, R> selection);

    <R> Page<R> relatesTo(Paging paging, Function<IssueSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    IssueState state();

    @Nullable IssueStateReason stateReason(IssueStateReasonFilter arguments);

    @Nullable IssueStateReason stateReason();

    <R> Page<R> subIssues(Paging paging, Function<IssueSelector, R> selection);

    <R> R subIssuesSummary(Function<SubIssuesSummarySelector, R> selection);

    <R> Page<R> suggestedActors(
            Paging paging, IssueSuggestedActorsFilter arguments, Function<AssigneeSelector, R> selection);

    <R> Page<R> suggestedActors(Paging paging, Function<AssigneeSelector, R> selection);

    /** @deprecated `timeline` will be removed Use Issue.timelineItems instead. Removal on 2020-10-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> Page<R> timeline(
            Paging paging, IssueTimelineFilter arguments, Function<IssueTimelineItemSelector, R> selection);

    /** @deprecated `timeline` will be removed Use Issue.timelineItems instead. Removal on 2020-10-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> Page<R> timeline(Paging paging, Function<IssueTimelineItemSelector, R> selection);

    <R> Page<R> timelineItems(
            Paging paging, IssueTimelineItemsFilter arguments, Function<IssueTimelineItemsSelector, R> selection);

    <R> Page<R> timelineItems(Paging paging, Function<IssueTimelineItemsSelector, R> selection);

    String title();

    String titleHTML();

    <R> Page<R> trackedInIssues(Paging paging, Function<IssueSelector, R> selection);

    <R> Page<R> trackedIssues(Paging paging, Function<IssueSelector, R> selection);

    int trackedIssuesCount(IssueTrackedIssuesCountFilter arguments);

    int trackedIssuesCount();

    Instant updatedAt();

    String url();

    <R> Page<R> userContentEdits(Paging paging, Function<UserContentEditSelector, R> selection);

    boolean viewerCanAssign();

    boolean viewerCanClose();

    boolean viewerCanDelete();

    boolean viewerCanLabel();

    boolean viewerCanReact();

    boolean viewerCanReopen();

    @Nullable Boolean viewerCanSetFields();

    boolean viewerCanSetMilestone();

    boolean viewerCanSubscribe();

    @Nullable Boolean viewerCanType();

    boolean viewerCanUpdate();

    @Nullable Boolean viewerCanUpdateMetadata();

    List<CommentCannotUpdateReason> viewerCannotUpdateReasons();

    boolean viewerDidAuthor();

    @Nullable SubscriptionState viewerSubscription();

    @Nullable ThreadSubscriptionFormAction viewerThreadSubscriptionFormAction();

    @Nullable ThreadSubscriptionState viewerThreadSubscriptionStatus();
}
