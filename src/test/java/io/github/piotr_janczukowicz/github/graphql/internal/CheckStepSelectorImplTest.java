package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CheckConclusionState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckStatusState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CheckStepSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"completedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"conclusion\":\"ACTION_REQUIRED\"" + "," + "\"externalId\":\"x\"" + "," + "\"name\":\"x\"" + ","
            + "\"number\":1" + "," + "\"secondsToCompletion\":1" + "," + "\"startedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"status\":\"COMPLETED\"" + "}";

    private static List<Object> readWithArguments(final CheckStepSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.completedAt());
        values.add(selector.conclusion());
        values.add(selector.externalId());
        values.add(selector.name());
        values.add(selector.number());
        values.add(selector.secondsToCompletion());
        values.add(selector.startedAt());
        values.add(selector.status());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CheckStepSelectorImpl(new RecordingCursor(root)));
        final CheckStepSelectorImpl selector =
                new CheckStepSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        CheckConclusionState.ACTION_REQUIRED,
                        "x",
                        "x",
                        1,
                        1,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        CheckStatusState.COMPLETED);
    }
}
