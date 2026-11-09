package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CheckRunSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateCheckRunPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"checkRun\":{\"completedAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"clientMutationId\":\"x\"" + "}";

    private static List<Object> readWithArguments(final UpdateCheckRunPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.checkRun(CheckRunSelector::completedAt));
        values.add(selector.clientMutationId());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateCheckRunPayloadSelectorImpl(new RecordingCursor(root)));
        final UpdateCheckRunPayloadSelectorImpl selector =
                new UpdateCheckRunPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(Instant.parse("2024-05-01T10:15:30Z"), "x");
    }
}
