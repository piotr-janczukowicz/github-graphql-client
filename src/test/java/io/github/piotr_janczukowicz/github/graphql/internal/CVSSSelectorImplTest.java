package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CVSSSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"score\":1.5" + "," + "\"vectorString\":\"x\"" + "}";

    private static List<Object> readWithArguments(final CVSSSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.score());
        values.add(selector.vectorString());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CVSSSelectorImpl(new RecordingCursor(root)));
        final CVSSSelectorImpl selector = new CVSSSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1.5, "x");
    }
}
