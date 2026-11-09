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
class StatusCheckRollupContextSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"completedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"__typename\":\"CheckRun\"" + "}";

    private static List<Object> readWithArguments(final StatusCheckRollupContextSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(CheckRunSelector.class, CheckRunSelector::completedAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new StatusCheckRollupContextSelectorImpl(new RecordingCursor(root)));
        final StatusCheckRollupContextSelectorImpl selector =
                new StatusCheckRollupContextSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(Instant.parse("2024-05-01T10:15:30Z"));
    }
}
