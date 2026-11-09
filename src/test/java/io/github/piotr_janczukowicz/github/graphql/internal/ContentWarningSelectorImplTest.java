package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ContentWarningSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"category\":\"x\"" + "," + "\"customSubCategory\":\"x\"" + "," + "\"subCategory\":\"x\"" + ","
                    + "\"subTitle\":\"x\"" + "," + "\"title\":\"x\"" + "," + "\"type\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ContentWarningSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.category());
        values.add(selector.customSubCategory());
        values.add(selector.subCategory());
        values.add(selector.subTitle());
        values.add(selector.title());
        values.add(selector.type());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ContentWarningSelectorImpl(new RecordingCursor(root)));
        final ContentWarningSelectorImpl selector =
                new ContentWarningSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", "x", "x", "x");
    }
}
