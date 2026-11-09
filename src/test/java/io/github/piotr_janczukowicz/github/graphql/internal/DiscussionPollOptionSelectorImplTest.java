package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DiscussionPollOptionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + "," + "\"option\":\"x\"" + ","
            + "\"poll\":{\"id\": \"x\"}" + "," + "\"totalVoteCount\":1" + "," + "\"viewerHasVoted\":true" + "}";

    private static List<Object> readWithArguments(final DiscussionPollOptionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.option());
        values.add(selector.poll(DiscussionPollSelector::id));
        values.add(selector.totalVoteCount());
        values.add(selector.viewerHasVoted());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DiscussionPollOptionSelectorImpl(new RecordingCursor(root)));
        final DiscussionPollOptionSelectorImpl selector =
                new DiscussionPollOptionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", 1, true);
    }
}
