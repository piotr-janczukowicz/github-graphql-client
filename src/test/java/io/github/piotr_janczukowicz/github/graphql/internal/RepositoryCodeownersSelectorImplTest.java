package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCodeownersErrorSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryCodeownersSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"errors\":[{\"column\": 1}]" + "}";

    private static List<Object> readWithArguments(final RepositoryCodeownersSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.errors(RepositoryCodeownersErrorSelector::column));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryCodeownersSelectorImpl(new RecordingCursor(root)));
        final RepositoryCodeownersSelectorImpl selector =
                new RepositoryCodeownersSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of(1));
    }
}
