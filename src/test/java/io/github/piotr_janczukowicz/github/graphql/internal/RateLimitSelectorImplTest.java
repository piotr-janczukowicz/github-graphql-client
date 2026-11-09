package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RateLimitSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"cost\":1" + "," + "\"limit\":1" + "," + "\"nodeCount\":1" + ","
            + "\"remaining\":1" + "," + "\"resetAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"used\":1" + "}";

    private static List<Object> readWithArguments(final RateLimitSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.cost());
        values.add(selector.limit());
        values.add(selector.nodeCount());
        values.add(selector.remaining());
        values.add(selector.resetAt());
        values.add(selector.used());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RateLimitSelectorImpl(new RecordingCursor(root)));
        final RateLimitSelectorImpl selector =
                new RateLimitSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, 1, 1, 1, Instant.parse("2024-05-01T10:15:30Z"), 1);
    }
}
