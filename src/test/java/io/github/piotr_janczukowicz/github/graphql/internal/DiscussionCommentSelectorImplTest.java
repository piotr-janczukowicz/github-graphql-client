package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DiscussionCommentSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"author\":{\"avatarUrl\": \"x\"}" + ","
            + "\"authorAssociation\":\"COLLABORATOR\"" + "," + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + ","
            + "\"bodyText\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"createdViaEmail\":true"
            + "," + "\"databaseId\":1" + "," + "\"deletedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"discussion\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"editor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"id\":\"x\"" + "," + "\"includesCreatedEdit\":true" + "," + "\"isAnswer\":true" + ","
            + "\"isMinimized\":true" + "," + "\"lastEditedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"minimizedReason\":\"x\"" + "," + "\"publishedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"reactionGroups\":[{\"content\": \"CONFUSED\"}]" + ","
            + "\"reactions\":{\"nodes\": [{\"content\": \"CONFUSED\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"replies\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"replyTo\":{\"authorAssociation\": \"COLLABORATOR\"}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"upvoteCount\":1" + "," + "\"url\":\"x\"" + ","
            + "\"userContentEdits\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanDelete\":true" + "," + "\"viewerCanMarkAsAnswer\":true" + ","
            + "\"viewerCanMinimize\":true" + "," + "\"viewerCanReact\":true" + "," + "\"viewerCanUnmarkAsAnswer\":true"
            + "," + "\"viewerCanUnminimize\":true" + "," + "\"viewerCanUpdate\":true" + "," + "\"viewerCanUpvote\":true"
            + "," + "\"viewerCannotUpdateReasons\":[\"ARCHIVED\"]" + "," + "\"viewerDidAuthor\":true" + ","
            + "\"viewerHasUpvoted\":true" + "}";

    private static List<Object> readWithArguments(final DiscussionCommentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.author(ActorSelector::avatarUrl));
        values.add(selector.authorAssociation());
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.bodyText());
        values.add(selector.createdAt());
        values.add(selector.createdViaEmail());
        values.add(selector.databaseId());
        values.add(selector.deletedAt());
        values.add(selector.discussion(DiscussionSelector::activeLockReason));
        values.add(selector.editor(ActorSelector::avatarUrl));
        values.add(selector.id());
        values.add(selector.includesCreatedEdit());
        values.add(selector.isAnswer());
        values.add(selector.isMinimized());
        values.add(selector.lastEditedAt());
        values.add(selector.minimizedReason());
        values.add(selector.publishedAt());
        values.add(selector.reactionGroups(ReactionGroupSelector::content));
        values.add(selector.reactions(
                Paging.first(1),
                DiscussionCommentReactionsFilterBuilder.builder()
                        .content(ReactionContent.CONFUSED)
                        .orderBy(ReactionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ReactionOrderField.CREATED_AT)
                                .build())
                        .build(),
                ReactionSelector::content));
        values.add(selector.replies(Paging.first(1), DiscussionCommentSelector::authorAssociation));
        values.add(selector.replyTo(DiscussionCommentSelector::authorAssociation));
        values.add(selector.resourcePath());
        values.add(selector.updatedAt());
        values.add(selector.upvoteCount());
        values.add(selector.url());
        values.add(selector.userContentEdits(Paging.first(1), UserContentEditSelector::createdAt));
        values.add(selector.viewerCanDelete());
        values.add(selector.viewerCanMarkAsAnswer());
        values.add(selector.viewerCanMinimize());
        values.add(selector.viewerCanReact());
        values.add(selector.viewerCanUnmarkAsAnswer());
        values.add(selector.viewerCanUnminimize());
        values.add(selector.viewerCanUpdate());
        values.add(selector.viewerCanUpvote());
        values.add(selector.viewerCannotUpdateReasons());
        values.add(selector.viewerDidAuthor());
        values.add(selector.viewerHasUpvoted());
        return values;
    }

    private static List<Object> readWithoutArguments(final DiscussionCommentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.reactions(Paging.first(1), ReactionSelector::content));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DiscussionCommentSelectorImpl(new RecordingCursor(root)));
        final DiscussionCommentSelectorImpl selector =
                new DiscussionCommentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        CommentAuthorAssociation.COLLABORATOR,
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        LockReason.OFF_TOPIC,
                        "x",
                        "x",
                        true,
                        true,
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        List.of(ReactionContent.CONFUSED),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        CommentAuthorAssociation.COLLABORATOR,
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
                        List.of(CommentCannotUpdateReason.ARCHIVED),
                        true,
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new DiscussionCommentSelectorImpl(new RecordingCursor(root)));
        final DiscussionCommentSelectorImpl selector =
                new DiscussionCommentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(ReactionContent.CONFUSED), false, null));
    }
}
