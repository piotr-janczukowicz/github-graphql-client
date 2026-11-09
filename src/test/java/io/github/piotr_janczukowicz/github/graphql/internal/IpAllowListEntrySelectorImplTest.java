package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IpAllowListEntrySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"allowListValue\":\"x\"" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + "," + "\"isActive\":true" + ","
            + "\"name\":\"x\"" + "," + "\"owner\":{\"__typename\": \"App\", \"clientId\": \"x\"}" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final IpAllowListEntrySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.allowListValue());
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.isActive());
        values.add(selector.name());
        values.add(selector.owner(child -> child.on(AppSelector.class, AppSelector::clientId)));
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IpAllowListEntrySelectorImpl(new RecordingCursor(root)));
        final IpAllowListEntrySelectorImpl selector =
                new IpAllowListEntrySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        true,
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
