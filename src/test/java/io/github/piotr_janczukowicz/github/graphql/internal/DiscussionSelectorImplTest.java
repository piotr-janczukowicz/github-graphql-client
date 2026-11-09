package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionStateReason;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DiscussionSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"activeLockReason\":\"OFF_TOPIC\"" + ","
            + "\"answer\":{\"authorAssociation\": \"COLLABORATOR\"}" + ","
            + "\"answerChosenAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"answerChosenBy\":{\"avatarUrl\": \"x\"}" + ","
            + "\"author\":{\"avatarUrl\": \"x\"}" + "," + "\"authorAssociation\":\"COLLABORATOR\"" + ","
            + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + "," + "\"bodyText\":\"x\"" + ","
            + "\"category\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"closed\":true" + ","
            + "\"closedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"comments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"createdViaEmail\":true" + ","
            + "\"databaseId\":1" + "," + "\"editor\":{\"avatarUrl\": \"x\"}" + "," + "\"id\":\"x\"" + ","
            + "\"includesCreatedEdit\":true" + "," + "\"isAnswered\":true" + ","
            + "\"labels\":{\"nodes\": [{\"color\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"lastEditedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"locked\":true" + "," + "\"number\":1" + ","
            + "\"poll\":{\"id\": \"x\"}" + "," + "\"publishedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"reactionGroups\":[{\"content\": \"CONFUSED\"}]" + ","
            + "\"reactions\":{\"nodes\": [{\"content\": \"CONFUSED\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"stateReason\":\"DUPLICATE\"" + "," + "\"title\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\""
            + "," + "\"upvoteCount\":1" + "," + "\"url\":\"x\"" + ","
            + "\"userContentEdits\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanClose\":true" + "," + "\"viewerCanDelete\":true" + "," + "\"viewerCanLabel\":true" + ","
            + "\"viewerCanReact\":true" + "," + "\"viewerCanReopen\":true" + "," + "\"viewerCanSubscribe\":true" + ","
            + "\"viewerCanUpdate\":true" + "," + "\"viewerCanUpvote\":true" + "," + "\"viewerDidAuthor\":true" + ","
            + "\"viewerHasUpvoted\":true" + "," + "\"viewerSubscription\":\"IGNORED\"" + "}";

    private static List<Object> readWithArguments(final DiscussionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.activeLockReason());
        values.add(selector.answer(DiscussionCommentSelector::authorAssociation));
        values.add(selector.answerChosenAt());
        values.add(selector.answerChosenBy(ActorSelector::avatarUrl));
        values.add(selector.author(ActorSelector::avatarUrl));
        values.add(selector.authorAssociation());
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.bodyText());
        values.add(selector.category(DiscussionCategorySelector::createdAt));
        values.add(selector.closed());
        values.add(selector.closedAt());
        values.add(selector.comments(Paging.first(1), DiscussionCommentSelector::authorAssociation));
        values.add(selector.createdAt());
        values.add(selector.createdViaEmail());
        values.add(selector.databaseId());
        values.add(selector.editor(ActorSelector::avatarUrl));
        values.add(selector.id());
        values.add(selector.includesCreatedEdit());
        values.add(selector.isAnswered());
        values.add(selector.labels(
                Paging.first(1),
                DiscussionLabelsFilterBuilder.builder()
                        .orderBy(LabelOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(LabelOrderField.CREATED_AT)
                                .build())
                        .build(),
                LabelSelector::color));
        values.add(selector.lastEditedAt());
        values.add(selector.locked());
        values.add(selector.number());
        values.add(selector.poll(DiscussionPollSelector::id));
        values.add(selector.publishedAt());
        values.add(selector.reactionGroups(ReactionGroupSelector::content));
        values.add(selector.reactions(
                Paging.first(1),
                DiscussionReactionsFilterBuilder.builder()
                        .content(ReactionContent.CONFUSED)
                        .orderBy(ReactionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ReactionOrderField.CREATED_AT)
                                .build())
                        .build(),
                ReactionSelector::content));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.stateReason());
        values.add(selector.title());
        values.add(selector.updatedAt());
        values.add(selector.upvoteCount());
        values.add(selector.url());
        values.add(selector.userContentEdits(Paging.first(1), UserContentEditSelector::createdAt));
        values.add(selector.viewerCanClose());
        values.add(selector.viewerCanDelete());
        values.add(selector.viewerCanLabel());
        values.add(selector.viewerCanReact());
        values.add(selector.viewerCanReopen());
        values.add(selector.viewerCanSubscribe());
        values.add(selector.viewerCanUpdate());
        values.add(selector.viewerCanUpvote());
        values.add(selector.viewerDidAuthor());
        values.add(selector.viewerHasUpvoted());
        values.add(selector.viewerSubscription());
        return values;
    }

    private static List<Object> readWithoutArguments(final DiscussionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.labels(Paging.first(1), LabelSelector::color));
        values.add(selector.reactions(Paging.first(1), ReactionSelector::content));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DiscussionSelectorImpl(new RecordingCursor(root)));
        final DiscussionSelectorImpl selector =
                new DiscussionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        LockReason.OFF_TOPIC,
                        CommentAuthorAssociation.COLLABORATOR,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        CommentAuthorAssociation.COLLABORATOR,
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        1,
                        "x",
                        "x",
                        true,
                        true,
                        new Page<>(List.of("x"), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        1,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        List.of(ReactionContent.CONFUSED),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        true,
                        "x",
                        DiscussionStateReason.DUPLICATE,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
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
                        SubscriptionState.IGNORED);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new DiscussionSelectorImpl(new RecordingCursor(root)));
        final DiscussionSelectorImpl selector =
                new DiscussionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null));
    }
}
