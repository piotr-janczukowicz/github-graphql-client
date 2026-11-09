package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReviewRequestSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"asCodeOwner\":true" + "," + "\"databaseId\":1" + ","
            + "\"id\":\"x\"" + "," + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"requestedReviewer\":{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final ReviewRequestSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.asCodeOwner());
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.requestedReviewer(child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReviewRequestSelectorImpl(new RecordingCursor(root)));
        final ReviewRequestSelectorImpl selector =
                new ReviewRequestSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, 1, "x", LockReason.OFF_TOPIC, "x");
    }
}
