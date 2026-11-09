package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReviewDismissedEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + "," + "\"dismissalMessage\":\"x\""
            + "," + "\"dismissalMessageHTML\":\"x\"" + "," + "\"id\":\"x\"" + ","
            + "\"previousReviewState\":\"APPROVED\"" + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}"
            + "," + "\"pullRequestCommit\":{\"id\": \"x\"}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"review\":{\"authorAssociation\": \"COLLABORATOR\"}" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ReviewDismissedEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.dismissalMessage());
        values.add(selector.dismissalMessageHTML());
        values.add(selector.id());
        values.add(selector.previousReviewState());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.pullRequestCommit(PullRequestCommitSelector::id));
        values.add(selector.resourcePath());
        values.add(selector.review(PullRequestReviewSelector::authorAssociation));
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReviewDismissedEventSelectorImpl(new RecordingCursor(root)));
        final ReviewDismissedEventSelectorImpl selector =
                new ReviewDismissedEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        1,
                        "x",
                        "x",
                        "x",
                        PullRequestReviewState.APPROVED,
                        LockReason.OFF_TOPIC,
                        "x",
                        "x",
                        CommentAuthorAssociation.COLLABORATOR,
                        "x");
    }
}
