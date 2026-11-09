package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CreatedPullRequestReviewContributionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"isRestricted\":true" + ","
            + "\"occurredAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}"
            + "," + "\"pullRequestReview\":{\"authorAssociation\": \"COLLABORATOR\"}" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + "," + "\"url\":\"x\""
            + "," + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final CreatedPullRequestReviewContributionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.isRestricted());
        values.add(selector.occurredAt());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.pullRequestReview(PullRequestReviewSelector::authorAssociation));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.url());
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CreatedPullRequestReviewContributionSelectorImpl(new RecordingCursor(root)));
        final CreatedPullRequestReviewContributionSelectorImpl selector =
                new CreatedPullRequestReviewContributionSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        LockReason.OFF_TOPIC,
                        CommentAuthorAssociation.COLLABORATOR,
                        true,
                        "x",
                        "x",
                        true);
    }
}
