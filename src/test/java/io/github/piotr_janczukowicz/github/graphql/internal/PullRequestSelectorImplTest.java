package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AddedToMergeQueueEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssignedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutoMergeRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiffSide;
import io.github.piotr_janczukowicz.github.graphql.model.HovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeStateStatus;
import io.github.piotr_janczukowicz.github.graphql.model.MergeableState;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardArchivedState;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2PermissionLevel;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestChangedFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestClosingIssuesReferencesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestHovercardFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestLatestOpinionatedReviewsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestMergeMethod;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestProjectCardsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestProjectItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewDecision;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewThreadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSuggestedActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSuggestedReviewerActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTimelineItemsItemType;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestViewerMergeBodyTextFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestViewerMergeHeadlineTextFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderField;
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
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class PullRequestSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"activeLockReason\":\"OFF_TOPIC\"" + "," + "\"additions\":1" + ","
            + "\"assignedActors\":{\"nodes\": [{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"assignees\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"author\":{\"avatarUrl\": \"x\"}" + "," + "\"authorAssociation\":\"COLLABORATOR\"" + ","
            + "\"autoMergeRequest\":{\"authorEmail\": \"x\"}" + "," + "\"baseRef\":{\"id\": \"x\"}" + ","
            + "\"baseRefName\":\"x\"" + "," + "\"baseRefOid\":\"x\"" + ","
            + "\"baseRepository\":{\"allowUpdateBranch\": true}" + "," + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\""
            + "," + "\"bodyText\":\"x\"" + "," + "\"canBeRebased\":true" + "," + "\"changedFiles\":1" + ","
            + "\"checksResourcePath\":\"x\"" + "," + "\"checksUrl\":\"x\"" + "," + "\"closed\":true" + ","
            + "\"closedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"closingIssuesReferences\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"comments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"commits\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"createdViaEmail\":true" + ","
            + "\"databaseId\":1" + "," + "\"deletions\":1" + "," + "\"editor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"files\":{\"nodes\": [{\"additions\": 1}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"fullDatabaseId\":\"1\"" + "," + "\"headRef\":{\"id\": \"x\"}" + "," + "\"headRefName\":\"x\""
            + "," + "\"headRefOid\":\"x\"" + "," + "\"headRepository\":{\"allowUpdateBranch\": true}" + ","
            + "\"headRepositoryOwner\":{\"avatarUrl\": \"x\"}" + ","
            + "\"hovercard\":{\"contexts\": [{\"message\": \"x\"}]}" + "," + "\"id\":\"x\"" + ","
            + "\"includesCreatedEdit\":true" + "," + "\"isCrossRepository\":true" + "," + "\"isDraft\":true" + ","
            + "\"isInMergeQueue\":true" + "," + "\"isMergeQueueEnabled\":true" + "," + "\"isReadByViewer\":true" + ","
            + "\"labels\":{\"nodes\": [{\"color\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"lastEditedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"latestOpinionatedReviews\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"latestReviews\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"locked\":true" + "," + "\"maintainerCanModify\":true" + ","
            + "\"mergeCommit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"mergeQueue\":{\"id\": \"x\"}" + ","
            + "\"mergeQueueEntry\":{\"enqueuedAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"mergeStateStatus\":\"BEHIND\""
            + "," + "\"mergeable\":\"CONFLICTING\"" + "," + "\"merged\":true" + ","
            + "\"mergedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"mergedBy\":{\"avatarUrl\": \"x\"}" + ","
            + "\"milestone\":{\"closed\": true}" + "," + "\"number\":1" + ","
            + "\"participants\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"permalink\":\"x\"" + "," + "\"potentialMergeCommit\":{\"abbreviatedOid\": \"x\"}" + ","
            + "\"projectCards\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"projectItems\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"projectV2\":{\"closed\": true}" + ","
            + "\"projectsV2\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"publishedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"reactionGroups\":[{\"content\": \"CONFUSED\"}]" + ","
            + "\"reactions\":{\"nodes\": [{\"content\": \"CONFUSED\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"revertResourcePath\":\"x\"" + "," + "\"revertUrl\":\"x\"" + "," + "\"reviewDecision\":\"APPROVED\""
            + ","
            + "\"reviewRequests\":{\"nodes\": [{\"asCodeOwner\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"reviewThreads\":{\"nodes\": [{\"diffSide\": \"LEFT\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"reviews\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"stack\":{\"baseRefName\": \"x\"}" + "," + "\"stackEntry\":{\"id\": \"x\"}" + ","
            + "\"state\":\"CLOSED\"" + "," + "\"statusCheckRollup\":{\"id\": \"x\"}" + ","
            + "\"suggestedActors\":{\"nodes\": [{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"suggestedReviewerActors\":{\"nodes\": [{\"isAuthor\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"suggestedReviewers\":[{\"isAuthor\": true}]" + ","
            + "\"timeline\":{\"nodes\": [{\"__typename\": \"AssignedEvent\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"timelineItems\":{\"nodes\": [{\"__typename\": \"AddedToMergeQueueEvent\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"title\":\"x\"" + "," + "\"titleHTML\":\"x\"" + "," + "\"totalCommentsCount\":1" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + ","
            + "\"userContentEdits\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanApplySuggestion\":true" + "," + "\"viewerCanAssign\":true" + ","
            + "\"viewerCanClose\":true" + "," + "\"viewerCanDeleteHeadRef\":true" + ","
            + "\"viewerCanDisableAutoMerge\":true" + "," + "\"viewerCanEditFiles\":true" + ","
            + "\"viewerCanEnableAutoMerge\":true" + "," + "\"viewerCanLabel\":true" + ","
            + "\"viewerCanMergeAsAdmin\":true" + "," + "\"viewerCanReact\":true" + "," + "\"viewerCanReopen\":true"
            + "," + "\"viewerCanSubscribe\":true" + "," + "\"viewerCanUpdate\":true" + ","
            + "\"viewerCanUpdateBranch\":true" + "," + "\"viewerCannotUpdateReasons\":[\"ARCHIVED\"]" + ","
            + "\"viewerDidAuthor\":true" + "," + "\"viewerLatestReview\":{\"authorAssociation\": \"COLLABORATOR\"}"
            + "," + "\"viewerLatestReviewRequest\":{\"asCodeOwner\": true}" + "," + "\"viewerMergeBodyText\":\"x\""
            + "," + "\"viewerMergeHeadlineText\":\"x\"" + "," + "\"viewerSubscription\":\"IGNORED\"" + "}";

    private static List<Object> readWithArguments(final PullRequestSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.activeLockReason());
        values.add(selector.additions());
        values.add(
                selector.assignedActors(Paging.first(1), child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.assignees(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.author(ActorSelector::avatarUrl));
        values.add(selector.authorAssociation());
        values.add(selector.autoMergeRequest(AutoMergeRequestSelector::authorEmail));
        values.add(selector.baseRef(RefSelector::id));
        values.add(selector.baseRefName());
        values.add(selector.baseRefOid());
        values.add(selector.baseRepository(RepositorySelector::allowUpdateBranch));
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.bodyText());
        values.add(selector.canBeRebased());
        values.add(selector.changedFiles());
        values.add(selector.checksResourcePath());
        values.add(selector.checksUrl());
        values.add(selector.closed());
        values.add(selector.closedAt());
        values.add(selector.closingIssuesReferences(
                Paging.first(1),
                PullRequestClosingIssuesReferencesFilterBuilder.builder()
                        .excludeUserLinked(true)
                        .orderBy(IssueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueOrderField.COMMENTS)
                                .build())
                        .userLinkedOnly(true)
                        .build(),
                IssueSelector::activeLockReason));
        values.add(selector.comments(
                Paging.first(1),
                PullRequestCommentsFilterBuilder.builder()
                        .orderBy(IssueCommentOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueCommentOrderField.UPDATED_AT)
                                .build())
                        .build(),
                IssueCommentSelector::authorAssociation));
        values.add(selector.commits(Paging.first(1), PullRequestCommitSelector::id));
        values.add(selector.createdAt());
        values.add(selector.createdViaEmail());
        values.add(selector.databaseId());
        values.add(selector.deletions());
        values.add(selector.editor(ActorSelector::avatarUrl));
        values.add(selector.files(Paging.first(1), PullRequestChangedFileSelector::additions));
        values.add(selector.fullDatabaseId());
        values.add(selector.headRef(RefSelector::id));
        values.add(selector.headRefName());
        values.add(selector.headRefOid());
        values.add(selector.headRepository(RepositorySelector::allowUpdateBranch));
        values.add(selector.headRepositoryOwner(RepositoryOwnerSelector::avatarUrl));
        values.add(selector.hovercard(
                PullRequestHovercardFilterBuilder.builder()
                        .includeNotificationContexts(true)
                        .build(),
                child -> child.contexts(HovercardContextSelector::message)));
        values.add(selector.id());
        values.add(selector.includesCreatedEdit());
        values.add(selector.isCrossRepository());
        values.add(selector.isDraft());
        values.add(selector.isInMergeQueue());
        values.add(selector.isMergeQueueEnabled());
        values.add(selector.isReadByViewer());
        values.add(selector.labels(
                Paging.first(1),
                PullRequestLabelsFilterBuilder.builder()
                        .orderBy(LabelOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(LabelOrderField.CREATED_AT)
                                .build())
                        .build(),
                LabelSelector::color));
        values.add(selector.lastEditedAt());
        values.add(selector.latestOpinionatedReviews(
                Paging.first(1),
                PullRequestLatestOpinionatedReviewsFilterBuilder.builder()
                        .writersOnly(true)
                        .build(),
                PullRequestReviewSelector::authorAssociation));
        values.add(selector.latestReviews(Paging.first(1), PullRequestReviewSelector::authorAssociation));
        values.add(selector.locked());
        values.add(selector.maintainerCanModify());
        values.add(selector.mergeCommit(CommitSelector::abbreviatedOid));
        values.add(selector.mergeQueue(MergeQueueSelector::id));
        values.add(selector.mergeQueueEntry(MergeQueueEntrySelector::enqueuedAt));
        values.add(selector.mergeStateStatus());
        values.add(selector.mergeable());
        values.add(selector.merged());
        values.add(selector.mergedAt());
        values.add(selector.mergedBy(ActorSelector::avatarUrl));
        values.add(selector.milestone(MilestoneSelector::closed));
        values.add(selector.number());
        values.add(selector.participants(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.permalink());
        values.add(selector.potentialMergeCommit(CommitSelector::abbreviatedOid));
        values.add(selector.projectCards(
                Paging.first(1),
                PullRequestProjectCardsFilterBuilder.builder()
                        .archivedStates(List.of(ProjectCardArchivedState.ARCHIVED))
                        .build(),
                ProjectCardSelector::createdAt));
        values.add(selector.projectItems(
                Paging.first(1),
                PullRequestProjectItemsFilterBuilder.builder()
                        .includeArchived(true)
                        .build(),
                ProjectV2ItemSelector::createdAt));
        values.add(selector.projectV2(1, ProjectV2Selector::closed));
        values.add(selector.projectsV2(
                Paging.first(1),
                PullRequestProjectsV2FilterBuilder.builder()
                        .minPermissionLevel(ProjectV2PermissionLevel.ADMIN)
                        .orderBy(ProjectV2OrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2OrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                ProjectV2Selector::closed));
        values.add(selector.publishedAt());
        values.add(selector.reactionGroups(ReactionGroupSelector::content));
        values.add(selector.reactions(
                Paging.first(1),
                PullRequestReactionsFilterBuilder.builder()
                        .content(ReactionContent.CONFUSED)
                        .orderBy(ReactionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ReactionOrderField.CREATED_AT)
                                .build())
                        .build(),
                ReactionSelector::content));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.revertResourcePath());
        values.add(selector.revertUrl());
        values.add(selector.reviewDecision());
        values.add(selector.reviewRequests(Paging.first(1), ReviewRequestSelector::asCodeOwner));
        values.add(selector.reviewThreads(Paging.first(1), PullRequestReviewThreadSelector::diffSide));
        values.add(selector.reviews(
                Paging.first(1),
                PullRequestReviewsFilterBuilder.builder()
                        .author("x")
                        .states(List.of(PullRequestReviewState.APPROVED))
                        .build(),
                PullRequestReviewSelector::authorAssociation));
        values.add(selector.stack(PullRequestStackSelector::baseRefName));
        values.add(selector.stackEntry(PullRequestStackEntrySelector::id));
        values.add(selector.state());
        values.add(selector.statusCheckRollup(StatusCheckRollupSelector::id));
        values.add(selector.suggestedActors(
                Paging.first(1),
                PullRequestSuggestedActorsFilterBuilder.builder().query("x").build(),
                child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.suggestedReviewerActors(
                Paging.first(1),
                PullRequestSuggestedReviewerActorsFilterBuilder.builder()
                        .query("x")
                        .build(),
                SuggestedReviewerActorSelector::isAuthor));
        values.add(selector.suggestedReviewers(SuggestedReviewerSelector::isAuthor));
        values.add(selector.timeline(
                Paging.first(1),
                PullRequestTimelineFilterBuilder.builder()
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build(),
                child -> child.on(AssignedEventSelector.class, AssignedEventSelector::createdAt)));
        values.add(selector.timelineItems(
                Paging.first(1),
                PullRequestTimelineItemsFilterBuilder.builder()
                        .itemTypes(List.of(PullRequestTimelineItemsItemType.ADDED_TO_MERGE_QUEUE_EVENT))
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .skip(1)
                        .build(),
                child -> child.on(AddedToMergeQueueEventSelector.class, AddedToMergeQueueEventSelector::createdAt)));
        values.add(selector.title());
        values.add(selector.titleHTML());
        values.add(selector.totalCommentsCount());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.userContentEdits(Paging.first(1), UserContentEditSelector::createdAt));
        values.add(selector.viewerCanApplySuggestion());
        values.add(selector.viewerCanAssign());
        values.add(selector.viewerCanClose());
        values.add(selector.viewerCanDeleteHeadRef());
        values.add(selector.viewerCanDisableAutoMerge());
        values.add(selector.viewerCanEditFiles());
        values.add(selector.viewerCanEnableAutoMerge());
        values.add(selector.viewerCanLabel());
        values.add(selector.viewerCanMergeAsAdmin());
        values.add(selector.viewerCanReact());
        values.add(selector.viewerCanReopen());
        values.add(selector.viewerCanSubscribe());
        values.add(selector.viewerCanUpdate());
        values.add(selector.viewerCanUpdateBranch());
        values.add(selector.viewerCannotUpdateReasons());
        values.add(selector.viewerDidAuthor());
        values.add(selector.viewerLatestReview(PullRequestReviewSelector::authorAssociation));
        values.add(selector.viewerLatestReviewRequest(ReviewRequestSelector::asCodeOwner));
        values.add(selector.viewerMergeBodyText(PullRequestViewerMergeBodyTextFilterBuilder.builder()
                .mergeType(PullRequestMergeMethod.MERGE)
                .build()));
        values.add(selector.viewerMergeHeadlineText(PullRequestViewerMergeHeadlineTextFilterBuilder.builder()
                .mergeType(PullRequestMergeMethod.MERGE)
                .build()));
        values.add(selector.viewerSubscription());
        return values;
    }

    private static List<Object> readWithoutArguments(final PullRequestSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.closingIssuesReferences(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.comments(Paging.first(1), IssueCommentSelector::authorAssociation));
        values.add(selector.hovercard(child -> child.contexts(HovercardContextSelector::message)));
        values.add(selector.labels(Paging.first(1), LabelSelector::color));
        values.add(selector.latestOpinionatedReviews(Paging.first(1), PullRequestReviewSelector::authorAssociation));
        values.add(selector.projectCards(Paging.first(1), ProjectCardSelector::createdAt));
        values.add(selector.projectItems(Paging.first(1), ProjectV2ItemSelector::createdAt));
        values.add(selector.projectsV2(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.reactions(Paging.first(1), ReactionSelector::content));
        values.add(selector.reviews(Paging.first(1), PullRequestReviewSelector::authorAssociation));
        values.add(selector.suggestedActors(
                Paging.first(1), child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.suggestedReviewerActors(Paging.first(1), SuggestedReviewerActorSelector::isAuthor));
        values.add(selector.timeline(
                Paging.first(1), child -> child.on(AssignedEventSelector.class, AssignedEventSelector::createdAt)));
        values.add(selector.timelineItems(
                Paging.first(1),
                child -> child.on(AddedToMergeQueueEventSelector.class, AddedToMergeQueueEventSelector::createdAt)));
        values.add(selector.viewerMergeBodyText());
        values.add(selector.viewerMergeHeadlineText());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PullRequestSelectorImpl(new RecordingCursor(root)));
        final PullRequestSelectorImpl selector =
                new PullRequestSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        LockReason.OFF_TOPIC,
                        1,
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        "x",
                        CommentAuthorAssociation.COLLABORATOR,
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        "x",
                        "x",
                        "x",
                        true,
                        1,
                        "x",
                        "x",
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of("x"), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        1,
                        1,
                        "x",
                        new Page<>(List.of(1), false, null),
                        BigInteger.ONE,
                        "x",
                        "x",
                        "x",
                        true,
                        "x",
                        List.of("x"),
                        "x",
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        new Page<>(List.of("x"), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        true,
                        true,
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        MergeStateStatus.BEHIND,
                        MergeableState.CONFLICTING,
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        1,
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        true,
                        new Page<>(List.of(true), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        List.of(ReactionContent.CONFUSED),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        true,
                        "x",
                        "x",
                        "x",
                        PullRequestReviewDecision.APPROVED,
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(DiffSide.LEFT), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        "x",
                        "x",
                        PullRequestState.CLOSED,
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        List.of(true),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        "x",
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
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
                        true,
                        true,
                        List.of(CommentCannotUpdateReason.ARCHIVED),
                        true,
                        CommentAuthorAssociation.COLLABORATOR,
                        true,
                        "x",
                        "x",
                        SubscriptionState.IGNORED);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new PullRequestSelectorImpl(new RecordingCursor(root)));
        final PullRequestSelectorImpl selector =
                new PullRequestSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        List.of("x"),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        "x");
    }
}
