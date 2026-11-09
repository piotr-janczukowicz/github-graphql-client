package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class BlameRangeSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"age\":1" + "," + "\"commit\":{\"abbreviatedOid\": \"x\"}" + ","
            + "\"endingLine\":1" + "," + "\"startingLine\":1" + "}";

    private static List<Object> readWithArguments(final BlameRangeSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.age());
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.endingLine());
        values.add(selector.startingLine());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new BlameRangeSelectorImpl(new RecordingCursor(root)));
        final BlameRangeSelectorImpl selector =
                new BlameRangeSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, "x", 1, 1);
    }
}
