package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectOptionColor;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IssueFieldSingleSelectOptionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"color\":\"BLUE\"" + "," + "\"databaseId\":1" + ","
            + "\"description\":\"x\"" + "," + "\"fullDatabaseId\":\"1\"" + "," + "\"id\":\"x\"" + "," + "\"name\":\"x\""
            + "," + "\"priority\":1" + "}";

    private static List<Object> readWithArguments(final IssueFieldSingleSelectOptionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.color());
        values.add(selector.databaseId());
        values.add(selector.description());
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.priority());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueFieldSingleSelectOptionSelectorImpl(new RecordingCursor(root)));
        final IssueFieldSingleSelectOptionSelectorImpl selector =
                new IssueFieldSingleSelectOptionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(IssueFieldSingleSelectOptionColor.BLUE, 1, "x", BigInteger.ONE, "x", "x", 1);
    }
}
