package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PackageFileSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + "," + "\"md5\":\"x\"" + "," + "\"name\":\"x\"" + ","
            + "\"packageVersion\":{\"id\": \"x\"}" + "," + "\"sha1\":\"x\"" + "," + "\"sha256\":\"x\"" + ","
            + "\"size\":1" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final PackageFileSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.md5());
        values.add(selector.name());
        values.add(selector.packageVersion(PackageVersionSelector::id));
        values.add(selector.sha1());
        values.add(selector.sha256());
        values.add(selector.size());
        values.add(selector.updatedAt());
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PackageFileSelectorImpl(new RecordingCursor(root)));
        final PackageFileSelectorImpl selector =
                new PackageFileSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", "x", "x", "x", 1, Instant.parse("2024-05-01T10:15:30Z"), "x");
    }
}
