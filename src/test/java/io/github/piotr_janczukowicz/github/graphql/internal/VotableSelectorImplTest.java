package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class VotableSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"upvoteCount\":1" + "," + "\"viewerCanUpvote\":true" + "," + "\"viewerHasUpvoted\":true" + ","
                    + "\"activeLockReason\":\"OFF_TOPIC\"" + "," + "\"__typename\":\"Discussion\"" + "}";

    private static List<Object> readWithArguments(final VotableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.upvoteCount());
        values.add(selector.viewerCanUpvote());
        values.add(selector.viewerHasUpvoted());
        values.add(selector.on(DiscussionSelector.class, DiscussionSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new VotableSelectorImpl(new RecordingCursor(root)));
        final VotableSelectorImpl selector =
                new VotableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, true, true, LockReason.OFF_TOPIC);
    }
}
