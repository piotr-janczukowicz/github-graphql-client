package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MaxFileSizeParametersSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"ignoredFilePaths\":[\"x\"]" + "," + "\"maxFileSize\":1" + "}";

    private static List<Object> readWithArguments(final MaxFileSizeParametersSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.ignoredFilePaths());
        values.add(selector.maxFileSize());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MaxFileSizeParametersSelectorImpl(new RecordingCursor(root)));
        final MaxFileSizeParametersSelectorImpl selector =
                new MaxFileSizeParametersSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of("x"), 1);
    }
}
