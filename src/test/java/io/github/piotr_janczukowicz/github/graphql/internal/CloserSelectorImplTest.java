package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CloserSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"abbreviatedOid\":\"x\"" + "," + "\"__typename\":\"Commit\"" + "}";

    private static List<Object> readWithArguments(final CloserSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(CommitSelector.class, CommitSelector::abbreviatedOid));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CloserSelectorImpl(new RecordingCursor(root)));
        final CloserSelectorImpl selector = new CloserSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
