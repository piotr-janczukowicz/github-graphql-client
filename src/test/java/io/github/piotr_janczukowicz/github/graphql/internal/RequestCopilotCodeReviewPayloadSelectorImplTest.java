package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewRequestReason;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewRequestSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RequestCopilotCodeReviewPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"clientMutationId\":\"x\""
            + "," + "\"failureReason\":\"ACTOR_INELIGIBLE\"" + ","
            + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"reviewRequest\":{\"asCodeOwner\": true}" + "," + "\"success\":true" + "}";

    private static List<Object> readWithArguments(final RequestCopilotCodeReviewPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.clientMutationId());
        values.add(selector.failureReason());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.reviewRequest(ReviewRequestSelector::asCodeOwner));
        values.add(selector.success());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RequestCopilotCodeReviewPayloadSelectorImpl(new RecordingCursor(root)));
        final RequestCopilotCodeReviewPayloadSelectorImpl selector =
                new RequestCopilotCodeReviewPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x", "x", CopilotCodeReviewRequestReason.ACTOR_INELIGIBLE, LockReason.OFF_TOPIC, true, true);
    }
}
