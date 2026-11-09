package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class AnnouncementBannerSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"expiresAt\":\"2024-05-01T10:15:30Z\"" + ","
                    + "\"isUserDismissible\":true" + "," + "\"message\":\"x\"" + "}";

    private static List<Object> readWithArguments(final AnnouncementBannerSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.expiresAt());
        values.add(selector.isUserDismissible());
        values.add(selector.message());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new AnnouncementBannerSelectorImpl(new RecordingCursor(root)));
        final AnnouncementBannerSelectorImpl selector =
                new AnnouncementBannerSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"), Instant.parse("2024-05-01T10:15:30Z"), true, "x");
    }
}
