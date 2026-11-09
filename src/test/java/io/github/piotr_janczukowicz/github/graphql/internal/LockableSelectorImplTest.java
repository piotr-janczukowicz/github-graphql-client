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
class LockableSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"activeLockReason\":\"OFF_TOPIC\"" + "," + "\"locked\":true" + ","
            + "\"__typename\":\"Discussion\"" + "}";

    private static List<Object> readWithArguments(final LockableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.activeLockReason());
        values.add(selector.locked());
        values.add(selector.on(DiscussionSelector.class, DiscussionSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new LockableSelectorImpl(new RecordingCursor(root)));
        final LockableSelectorImpl selector =
                new LockableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(LockReason.OFF_TOPIC, true, LockReason.OFF_TOPIC);
    }
}
