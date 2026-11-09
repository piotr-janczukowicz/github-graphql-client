package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserEdgeSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RequestReviewsPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"clientMutationId\":\"x\""
            + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"requestedReviewersEdge\":{\"cursor\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final RequestReviewsPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.clientMutationId());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.requestedReviewersEdge(UserEdgeSelector::cursor));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RequestReviewsPayloadSelectorImpl(new RecordingCursor(root)));
        final RequestReviewsPayloadSelectorImpl selector =
                new RequestReviewsPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", LockReason.OFF_TOPIC, "x");
    }
}
