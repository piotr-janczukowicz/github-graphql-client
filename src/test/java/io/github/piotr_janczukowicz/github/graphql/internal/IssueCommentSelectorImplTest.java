package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
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
class IssueCommentSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"author\":{\"avatarUrl\": \"x\"}" + ","
            + "\"authorAssociation\":\"COLLABORATOR\"" + "," + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + ","
            + "\"bodyText\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"createdViaEmail\":true"
            + "," + "\"databaseId\":1" + "," + "\"editor\":{\"avatarUrl\": \"x\"}" + "," + "\"fullDatabaseId\":\"1\""
            + "," + "\"id\":\"x\"" + "," + "\"includesCreatedEdit\":true" + "," + "\"isMinimized\":true" + ","
            + "\"isPinned\":true" + "," + "\"issue\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"lastEditedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"minimizedReason\":\"x\"" + ","
            + "\"pinnedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"pinnedBy\":{\"anyPinnableItems\": true}" + ","
            + "\"publishedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}"
            + "," + "\"reactionGroups\":[{\"content\": \"CONFUSED\"}]" + ","
            + "\"reactions\":{\"nodes\": [{\"content\": \"CONFUSED\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + ","
            + "\"userContentEdits\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanDelete\":true" + "," + "\"viewerCanMinimize\":true" + "," + "\"viewerCanPin\":true"
            + "," + "\"viewerCanReact\":true" + "," + "\"viewerCanUnminimize\":true" + "," + "\"viewerCanUnpin\":true"
            + "," + "\"viewerCanUpdate\":true" + "," + "\"viewerCannotUpdateReasons\":[\"ARCHIVED\"]" + ","
            + "\"viewerDidAuthor\":true" + "}";

    private static List<Object> readWithArguments(final IssueCommentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.author(ActorSelector::avatarUrl));
        values.add(selector.authorAssociation());
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.bodyText());
        values.add(selector.createdAt());
        values.add(selector.createdViaEmail());
        values.add(selector.databaseId());
        values.add(selector.editor(ActorSelector::avatarUrl));
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.includesCreatedEdit());
        values.add(selector.isMinimized());
        values.add(selector.isPinned());
        values.add(selector.issue(IssueSelector::activeLockReason));
        values.add(selector.lastEditedAt());
        values.add(selector.minimizedReason());
        values.add(selector.pinnedAt());
        values.add(selector.pinnedBy(UserSelector::anyPinnableItems));
        values.add(selector.publishedAt());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.reactionGroups(ReactionGroupSelector::content));
        values.add(selector.reactions(
                Paging.first(1),
                IssueCommentReactionsFilterBuilder.builder()
                        .content(ReactionContent.CONFUSED)
                        .orderBy(ReactionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ReactionOrderField.CREATED_AT)
                                .build())
                        .build(),
                ReactionSelector::content));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.userContentEdits(Paging.first(1), UserContentEditSelector::createdAt));
        values.add(selector.viewerCanDelete());
        values.add(selector.viewerCanMinimize());
        values.add(selector.viewerCanPin());
        values.add(selector.viewerCanReact());
        values.add(selector.viewerCanUnminimize());
        values.add(selector.viewerCanUnpin());
        values.add(selector.viewerCanUpdate());
        values.add(selector.viewerCannotUpdateReasons());
        values.add(selector.viewerDidAuthor());
        return values;
    }

    private static List<Object> readWithoutArguments(final IssueCommentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.reactions(Paging.first(1), ReactionSelector::content));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueCommentSelectorImpl(new RecordingCursor(root)));
        final IssueCommentSelectorImpl selector =
                new IssueCommentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

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
                        "x",
                        BigInteger.ONE,
                        "x",
                        true,
                        true,
                        true,
                        LockReason.OFF_TOPIC,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        LockReason.OFF_TOPIC,
                        List.of(ReactionContent.CONFUSED),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        true,
                        "x",
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
                        List.of(CommentCannotUpdateReason.ARCHIVED),
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new IssueCommentSelectorImpl(new RecordingCursor(root)));
        final IssueCommentSelectorImpl selector =
                new IssueCommentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(ReactionContent.CONFUSED), false, null));
    }
}
