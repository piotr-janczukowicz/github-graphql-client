package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class FilePathRestrictionParametersSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"ignoredFilePaths\":[\"x\"]" + "," + "\"restrictedFilePaths\":[\"x\"]" + "}";

    private static List<Object> readWithArguments(final FilePathRestrictionParametersSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.ignoredFilePaths());
        values.add(selector.restrictedFilePaths());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new FilePathRestrictionParametersSelectorImpl(new RecordingCursor(root)));
        final FilePathRestrictionParametersSelectorImpl selector =
                new FilePathRestrictionParametersSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of("x"), List.of("x"));
    }
}
