package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PublicKeySelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"accessedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"fingerprint\":\"x\"" + "," + "\"id\":\"x\"" + ","
            + "\"isReadOnly\":true" + "," + "\"key\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final PublicKeySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.accessedAt());
        values.add(selector.createdAt());
        values.add(selector.fingerprint());
        values.add(selector.id());
        values.add(selector.isReadOnly());
        values.add(selector.key());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PublicKeySelectorImpl(new RecordingCursor(root)));
        final PublicKeySelectorImpl selector =
                new PublicKeySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        true,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
