package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MemberFeatureRequestNotificationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"body\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"title\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final MemberFeatureRequestNotificationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.body());
        values.add(selector.id());
        values.add(selector.title());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MemberFeatureRequestNotificationSelectorImpl(new RecordingCursor(root)));
        final MemberFeatureRequestNotificationSelectorImpl selector =
                new MemberFeatureRequestNotificationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", Instant.parse("2024-05-01T10:15:30Z"));
    }
}
