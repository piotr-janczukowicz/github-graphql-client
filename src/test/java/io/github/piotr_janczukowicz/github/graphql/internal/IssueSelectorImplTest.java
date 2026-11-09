package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AddedToProjectEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssignedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.HovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueBlockedByFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueBlockingFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueClosedByPullRequestsReferencesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueDependenciesSummarySelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueDependencyOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueDependencyOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueHovercardFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueProjectCardsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueProjectItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueRelatesToFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueRelatesToOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueRelatesToOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReason;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReasonFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSuggestedActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemsItemType;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTrackedIssuesCountFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeColor;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LinkedBranchSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.PendingAssigneeSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedIssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardArchivedState;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2PermissionLevel;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubIssuesSummarySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.ThreadSubscriptionFormAction;
import io.github.piotr_janczukowicz.github.graphql.model.ThreadSubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.TrackedIssueStates;
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
class IssueSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"activeLockReason\":\"OFF_TOPIC\"" + ","
            + "\"assignedActors\":{\"nodes\": [{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"assignees\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"author\":{\"avatarUrl\": \"x\"}" + "," + "\"authorAssociation\":\"COLLABORATOR\"" + ","
            + "\"blockedBy\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"blocking\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + "," + "\"bodyResourcePath\":\"x\"" + ","
            + "\"bodyText\":\"x\"" + "," + "\"bodyUrl\":\"x\"" + "," + "\"closed\":true" + ","
            + "\"closedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"closedByPullRequestsReferences\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"comments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"createdViaEmail\":true" + ","
            + "\"databaseId\":1" + "," + "\"duplicateOf\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"editor\":{\"avatarUrl\": \"x\"}" + "," + "\"fullDatabaseId\":\"1\"" + ","
            + "\"hovercard\":{\"contexts\": [{\"message\": \"x\"}]}" + "," + "\"id\":\"x\"" + ","
            + "\"includesCreatedEdit\":true" + "," + "\"isPinned\":true" + "," + "\"isReadByViewer\":true" + ","
            + "\"issueDependenciesSummary\":{\"blockedBy\": 1}" + ","
            + "\"issueFieldValues\":{\"nodes\": [{\"__typename\": \"IssueFieldDateValue\", \"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"issueType\":{\"color\": \"BLUE\"}" + ","
            + "\"labels\":{\"nodes\": [{\"color\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"lastEditedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"linkedBranches\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"locked\":true" + "," + "\"milestone\":{\"closed\": true}" + "," + "\"number\":1" + ","
            + "\"parent\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"participants\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pendingSuggestions\":[{\"__typename\": \"PendingAssigneeSuggestion\", \"createdAt\": \"2024-05-01T10:15:30Z\"}]"
            + "," + "\"pinnedIssueComment\":{\"databaseId\": 1}" + ","
            + "\"projectCards\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"projectItems\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"projectV2\":{\"closed\": true}" + ","
            + "\"projectsV2\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"publishedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"reactionGroups\":[{\"content\": \"CONFUSED\"}]" + ","
            + "\"reactions\":{\"nodes\": [{\"content\": \"CONFUSED\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"relatesTo\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"state\":\"CLOSED\"" + "," + "\"stateReason\":\"COMPLETED\"" + ","
            + "\"subIssues\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"subIssuesSummary\":{\"completed\": 1}" + ","
            + "\"suggestedActors\":{\"nodes\": [{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"timeline\":{\"nodes\": [{\"__typename\": \"AssignedEvent\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"timelineItems\":{\"nodes\": [{\"__typename\": \"AddedToProjectEvent\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"title\":\"x\"" + "," + "\"titleHTML\":\"x\"" + ","
            + "\"trackedInIssues\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"trackedIssues\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"trackedIssuesCount\":1" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\""
            + ","
            + "\"userContentEdits\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanAssign\":true" + "," + "\"viewerCanClose\":true" + "," + "\"viewerCanDelete\":true"
            + "," + "\"viewerCanLabel\":true" + "," + "\"viewerCanReact\":true" + "," + "\"viewerCanReopen\":true" + ","
            + "\"viewerCanSetFields\":true" + "," + "\"viewerCanSetMilestone\":true" + ","
            + "\"viewerCanSubscribe\":true" + "," + "\"viewerCanType\":true" + "," + "\"viewerCanUpdate\":true" + ","
            + "\"viewerCanUpdateMetadata\":true" + "," + "\"viewerCannotUpdateReasons\":[\"ARCHIVED\"]" + ","
            + "\"viewerDidAuthor\":true" + "," + "\"viewerSubscription\":\"IGNORED\"" + ","
            + "\"viewerThreadSubscriptionFormAction\":\"NONE\"" + ","
            + "\"viewerThreadSubscriptionStatus\":\"DISABLED\"" + "}";

    private static List<Object> readWithArguments(final IssueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.activeLockReason());
        values.add(
                selector.assignedActors(Paging.first(1), child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.assignees(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.author(ActorSelector::avatarUrl));
        values.add(selector.authorAssociation());
        values.add(selector.blockedBy(
                Paging.first(1),
                IssueBlockedByFilterBuilder.builder()
                        .orderBy(IssueDependencyOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueDependencyOrderField.CREATED_AT)
                                .build())
                        .build(),
                IssueSelector::activeLockReason));
        values.add(selector.blocking(
                Paging.first(1),
                IssueBlockingFilterBuilder.builder()
                        .orderBy(IssueDependencyOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueDependencyOrderField.CREATED_AT)
                                .build())
                        .build(),
                IssueSelector::activeLockReason));
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.bodyResourcePath());
        values.add(selector.bodyText());
        values.add(selector.bodyUrl());
        values.add(selector.closed());
        values.add(selector.closedAt());
        values.add(selector.closedByPullRequestsReferences(
                Paging.first(1),
                IssueClosedByPullRequestsReferencesFilterBuilder.builder()
                        .excludeUserLinked(true)
                        .includeClosedPrs(true)
                        .orderByState(true)
                        .userLinkedOnly(true)
                        .build(),
                PullRequestSelector::activeLockReason));
        values.add(selector.comments(
                Paging.first(1),
                IssueCommentsFilterBuilder.builder()
                        .orderBy(IssueCommentOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueCommentOrderField.UPDATED_AT)
                                .build())
                        .build(),
                IssueCommentSelector::authorAssociation));
        values.add(selector.createdAt());
        values.add(selector.createdViaEmail());
        values.add(selector.databaseId());
        values.add(selector.duplicateOf(IssueSelector::activeLockReason));
        values.add(selector.editor(ActorSelector::avatarUrl));
        values.add(selector.fullDatabaseId());
        values.add(selector.hovercard(
                IssueHovercardFilterBuilder.builder()
                        .includeNotificationContexts(true)
                        .build(),
                child -> child.contexts(HovercardContextSelector::message)));
        values.add(selector.id());
        values.add(selector.includesCreatedEdit());
        values.add(selector.isPinned());
        values.add(selector.isReadByViewer());
        values.add(selector.issueDependenciesSummary(IssueDependenciesSummarySelector::blockedBy));
        values.add(selector.issueFieldValues(
                Paging.first(1),
                child -> child.on(IssueFieldDateValueSelector.class, IssueFieldDateValueSelector::id)));
        values.add(selector.issueType(IssueTypeSelector::color));
        values.add(selector.labels(
                Paging.first(1),
                IssueLabelsFilterBuilder.builder()
                        .orderBy(LabelOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(LabelOrderField.CREATED_AT)
                                .build())
                        .build(),
                LabelSelector::color));
        values.add(selector.lastEditedAt());
        values.add(selector.linkedBranches(Paging.first(1), LinkedBranchSelector::id));
        values.add(selector.locked());
        values.add(selector.milestone(MilestoneSelector::closed));
        values.add(selector.number());
        values.add(selector.parent(IssueSelector::activeLockReason));
        values.add(selector.participants(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.pendingSuggestions(child ->
                child.on(PendingAssigneeSuggestionSelector.class, PendingAssigneeSuggestionSelector::createdAt)));
        values.add(selector.pinnedIssueComment(PinnedIssueCommentSelector::databaseId));
        values.add(selector.projectCards(
                Paging.first(1),
                IssueProjectCardsFilterBuilder.builder()
                        .archivedStates(List.of(ProjectCardArchivedState.ARCHIVED))
                        .build(),
                ProjectCardSelector::createdAt));
        values.add(selector.projectItems(
                Paging.first(1),
                IssueProjectItemsFilterBuilder.builder().includeArchived(true).build(),
                ProjectV2ItemSelector::createdAt));
        values.add(selector.projectV2(1, ProjectV2Selector::closed));
        values.add(selector.projectsV2(
                Paging.first(1),
                IssueProjectsV2FilterBuilder.builder()
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
                IssueReactionsFilterBuilder.builder()
                        .content(ReactionContent.CONFUSED)
                        .orderBy(ReactionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ReactionOrderField.CREATED_AT)
                                .build())
                        .build(),
                ReactionSelector::content));
        values.add(selector.relatesTo(
                Paging.first(1),
                IssueRelatesToFilterBuilder.builder()
                        .orderBy(IssueRelatesToOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueRelatesToOrderField.CREATED_AT)
                                .build())
                        .build(),
                IssueSelector::activeLockReason));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.state());
        values.add(selector.stateReason(
                IssueStateReasonFilterBuilder.builder().enableDuplicate(true).build()));
        values.add(selector.subIssues(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.subIssuesSummary(SubIssuesSummarySelector::completed));
        values.add(selector.suggestedActors(
                Paging.first(1),
                IssueSuggestedActorsFilterBuilder.builder().query("x").build(),
                child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.timeline(
                Paging.first(1),
                IssueTimelineFilterBuilder.builder()
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build(),
                child -> child.on(AssignedEventSelector.class, AssignedEventSelector::createdAt)));
        values.add(selector.timelineItems(
                Paging.first(1),
                IssueTimelineItemsFilterBuilder.builder()
                        .itemTypes(List.of(IssueTimelineItemsItemType.ADDED_TO_PROJECT_EVENT))
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .skip(1)
                        .build(),
                child -> child.on(AddedToProjectEventSelector.class, AddedToProjectEventSelector::createdAt)));
        values.add(selector.title());
        values.add(selector.titleHTML());
        values.add(selector.trackedInIssues(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.trackedIssues(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.trackedIssuesCount(IssueTrackedIssuesCountFilterBuilder.builder()
                .states(List.of(TrackedIssueStates.CLOSED))
                .build()));
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.userContentEdits(Paging.first(1), UserContentEditSelector::createdAt));
        values.add(selector.viewerCanAssign());
        values.add(selector.viewerCanClose());
        values.add(selector.viewerCanDelete());
        values.add(selector.viewerCanLabel());
        values.add(selector.viewerCanReact());
        values.add(selector.viewerCanReopen());
        values.add(selector.viewerCanSetFields());
        values.add(selector.viewerCanSetMilestone());
        values.add(selector.viewerCanSubscribe());
        values.add(selector.viewerCanType());
        values.add(selector.viewerCanUpdate());
        values.add(selector.viewerCanUpdateMetadata());
        values.add(selector.viewerCannotUpdateReasons());
        values.add(selector.viewerDidAuthor());
        values.add(selector.viewerSubscription());
        values.add(selector.viewerThreadSubscriptionFormAction());
        values.add(selector.viewerThreadSubscriptionStatus());
        return values;
    }

    private static List<Object> readWithoutArguments(final IssueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.blockedBy(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.blocking(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.closedByPullRequestsReferences(Paging.first(1), PullRequestSelector::activeLockReason));
        values.add(selector.comments(Paging.first(1), IssueCommentSelector::authorAssociation));
        values.add(selector.hovercard(child -> child.contexts(HovercardContextSelector::message)));
        values.add(selector.labels(Paging.first(1), LabelSelector::color));
        values.add(selector.projectCards(Paging.first(1), ProjectCardSelector::createdAt));
        values.add(selector.projectItems(Paging.first(1), ProjectV2ItemSelector::createdAt));
        values.add(selector.projectsV2(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.reactions(Paging.first(1), ReactionSelector::content));
        values.add(selector.relatesTo(Paging.first(1), IssueSelector::activeLockReason));
        values.add(selector.stateReason());
        values.add(selector.suggestedActors(
                Paging.first(1), child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.timeline(
                Paging.first(1), child -> child.on(AssignedEventSelector.class, AssignedEventSelector::createdAt)));
        values.add(selector.timelineItems(
                Paging.first(1),
                child -> child.on(AddedToProjectEventSelector.class, AddedToProjectEventSelector::createdAt)));
        values.add(selector.trackedIssuesCount());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueSelectorImpl(new RecordingCursor(root)));
        final IssueSelectorImpl selector = new IssueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        LockReason.OFF_TOPIC,
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        "x",
                        CommentAuthorAssociation.COLLABORATOR,
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        1,
                        LockReason.OFF_TOPIC,
                        "x",
                        BigInteger.ONE,
                        List.of("x"),
                        "x",
                        true,
                        true,
                        true,
                        1,
                        new Page<>(List.of("x"), false, null),
                        IssueTypeColor.BLUE,
                        new Page<>(List.of("x"), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of("x"), false, null),
                        true,
                        true,
                        1,
                        LockReason.OFF_TOPIC,
                        new Page<>(List.of(true), false, null),
                        List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)),
                        1,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        true,
                        new Page<>(List.of(true), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        List.of(ReactionContent.CONFUSED),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        true,
                        "x",
                        IssueState.CLOSED,
                        IssueStateReason.COMPLETED,
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        1,
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        "x",
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
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
                        List.of(CommentCannotUpdateReason.ARCHIVED),
                        true,
                        SubscriptionState.IGNORED,
                        ThreadSubscriptionFormAction.NONE,
                        ThreadSubscriptionState.DISABLED);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new IssueSelectorImpl(new RecordingCursor(root)));
        final IssueSelectorImpl selector = new IssueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        List.of("x"),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        IssueStateReason.COMPLETED,
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        1);
    }
}
