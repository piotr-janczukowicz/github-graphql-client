package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ClosableSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"closed\":true" + "," + "\"closedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"viewerCanClose\":true" + "," + "\"viewerCanReopen\":true" + "," + "\"activeLockReason\":\"OFF_TOPIC\""
            + "," + "\"__typename\":\"Discussion\"" + "}";

    private static List<Object> readWithArguments(final ClosableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.closed());
        values.add(selector.closedAt());
        values.add(selector.viewerCanClose());
        values.add(selector.viewerCanReopen());
        values.add(selector.on(DiscussionSelector.class, DiscussionSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ClosableSelectorImpl(new RecordingCursor(root)));
        final ClosableSelectorImpl selector =
                new ClosableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(true, Instant.parse("2024-05-01T10:15:30Z"), true, true, LockReason.OFF_TOPIC);
    }
}
