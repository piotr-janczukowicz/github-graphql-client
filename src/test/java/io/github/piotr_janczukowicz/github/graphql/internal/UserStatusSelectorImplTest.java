package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UserStatusSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"emoji\":\"x\""
            + "," + "\"emojiHTML\":\"x\"" + "," + "\"expiresAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + ","
            + "\"indicatesLimitedAvailability\":true" + "," + "\"message\":\"x\"" + ","
            + "\"organization\":{\"anyPinnableItems\": true}" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final UserStatusSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.emoji());
        values.add(selector.emojiHTML());
        values.add(selector.expiresAt());
        values.add(selector.id());
        values.add(selector.indicatesLimitedAvailability());
        values.add(selector.message());
        values.add(selector.organization(OrganizationSelector::anyPinnableItems));
        values.add(selector.updatedAt());
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UserStatusSelectorImpl(new RecordingCursor(root)));
        final UserStatusSelectorImpl selector =
                new UserStatusSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        "x",
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true);
    }
}
