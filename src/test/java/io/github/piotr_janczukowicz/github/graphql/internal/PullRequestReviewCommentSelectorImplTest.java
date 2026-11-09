package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewThreadSubjectType;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class PullRequestReviewCommentSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"author\":{\"avatarUrl\": \"x\"}" + ","
            + "\"authorAssociation\":\"COLLABORATOR\"" + "," + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + ","
            + "\"bodyText\":\"x\"" + "," + "\"commit\":{\"abbreviatedOid\": \"x\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"createdViaEmail\":true" + "," + "\"databaseId\":1"
            + "," + "\"diffHunk\":\"x\"" + "," + "\"draftedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"editor\":{\"avatarUrl\": \"x\"}" + "," + "\"fullDatabaseId\":\"1\"" + "," + "\"id\":\"x\"" + ","
            + "\"includesCreatedEdit\":true" + "," + "\"isMinimized\":true" + ","
            + "\"lastEditedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"line\":1" + "," + "\"minimizedReason\":\"x\"" + ","
            + "\"originalCommit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"originalLine\":1" + ","
            + "\"originalPosition\":1" + "," + "\"originalStartLine\":1" + "," + "\"outdated\":true" + ","
            + "\"path\":\"x\"" + "," + "\"position\":1" + "," + "\"publishedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"pullRequestReview\":{\"authorAssociation\": \"COLLABORATOR\"}" + ","
            + "\"reactionGroups\":[{\"content\": \"CONFUSED\"}]" + ","
            + "\"reactions\":{\"nodes\": [{\"content\": \"CONFUSED\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"replyTo\":{\"authorAssociation\": \"COLLABORATOR\"}" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + "," + "\"startLine\":1"
            + "," + "\"state\":\"PENDING\"" + "," + "\"subjectType\":\"FILE\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + ","
            + "\"userContentEdits\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanDelete\":true" + "," + "\"viewerCanMinimize\":true" + "," + "\"viewerCanReact\":true"
            + "," + "\"viewerCanUnminimize\":true" + "," + "\"viewerCanUpdate\":true" + ","
            + "\"viewerCannotUpdateReasons\":[\"ARCHIVED\"]" + "," + "\"viewerDidAuthor\":true" + "}";

    private static List<Object> readWithArguments(final PullRequestReviewCommentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.author(ActorSelector::avatarUrl));
        values.add(selector.authorAssociation());
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.bodyText());
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.createdAt());
        values.add(selector.createdViaEmail());
        values.add(selector.databaseId());
        values.add(selector.diffHunk());
        values.add(selector.draftedAt());
        values.add(selector.editor(ActorSelector::avatarUrl));
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.includesCreatedEdit());
        values.add(selector.isMinimized());
        values.add(selector.lastEditedAt());
        values.add(selector.line());
        values.add(selector.minimizedReason());
        values.add(selector.originalCommit(CommitSelector::abbreviatedOid));
        values.add(selector.originalLine());
        values.add(selector.originalPosition());
        values.add(selector.originalStartLine());
        values.add(selector.outdated());
        values.add(selector.path());
        values.add(selector.position());
        values.add(selector.publishedAt());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.pullRequestReview(PullRequestReviewSelector::authorAssociation));
        values.add(selector.reactionGroups(ReactionGroupSelector::content));
        values.add(selector.reactions(
                Paging.first(1),
                PullRequestReviewCommentReactionsFilterBuilder.builder()
                        .content(ReactionContent.CONFUSED)
                        .orderBy(ReactionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ReactionOrderField.CREATED_AT)
                                .build())
                        .build(),
                ReactionSelector::content));
        values.add(selector.replyTo(PullRequestReviewCommentSelector::authorAssociation));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.startLine());
        values.add(selector.state());
        values.add(selector.subjectType());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.userContentEdits(Paging.first(1), UserContentEditSelector::createdAt));
        values.add(selector.viewerCanDelete());
        values.add(selector.viewerCanMinimize());
        values.add(selector.viewerCanReact());
        values.add(selector.viewerCanUnminimize());
        values.add(selector.viewerCanUpdate());
        values.add(selector.viewerCannotUpdateReasons());
        values.add(selector.viewerDidAuthor());
        return values;
    }

    private static List<Object> readWithoutArguments(final PullRequestReviewCommentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.reactions(Paging.first(1), ReactionSelector::content));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PullRequestReviewCommentSelectorImpl(new RecordingCursor(root)));
        final PullRequestReviewCommentSelectorImpl selector =
                new PullRequestReviewCommentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        CommentAuthorAssociation.COLLABORATOR,
                        "x",
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        1,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        BigInteger.ONE,
                        "x",
                        true,
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        "x",
                        1,
                        1,
                        1,
                        true,
                        "x",
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        LockReason.OFF_TOPIC,
                        CommentAuthorAssociation.COLLABORATOR,
                        List.of(ReactionContent.CONFUSED),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        CommentAuthorAssociation.COLLABORATOR,
                        true,
                        "x",
                        1,
                        PullRequestReviewCommentState.PENDING,
                        PullRequestReviewThreadSubjectType.FILE,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
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
        readWithoutArguments(new PullRequestReviewCommentSelectorImpl(new RecordingCursor(root)));
        final PullRequestReviewCommentSelectorImpl selector =
                new PullRequestReviewCommentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(ReactionContent.CONFUSED), false, null));
    }
}
