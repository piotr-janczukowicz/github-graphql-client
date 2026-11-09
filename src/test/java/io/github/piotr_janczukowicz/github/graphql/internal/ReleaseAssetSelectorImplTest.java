package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ReleaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReleaseAssetSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"contentType\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"digest\":\"x\""
                    + "," + "\"downloadCount\":1" + "," + "\"downloadUrl\":\"x\"" + "," + "\"id\":\"x\"" + ","
                    + "\"name\":\"x\"" + "," + "\"release\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
                    + "\"size\":1" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + ","
                    + "\"uploadedBy\":{\"anyPinnableItems\": true}" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ReleaseAssetSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.contentType());
        values.add(selector.createdAt());
        values.add(selector.digest());
        values.add(selector.downloadCount());
        values.add(selector.downloadUrl());
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.release(ReleaseSelector::createdAt));
        values.add(selector.size());
        values.add(selector.updatedAt());
        values.add(selector.uploadedBy(UserSelector::anyPinnableItems));
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReleaseAssetSelectorImpl(new RecordingCursor(root)));
        final ReleaseAssetSelectorImpl selector =
                new ReleaseAssetSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        1,
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        "x");
    }
}
