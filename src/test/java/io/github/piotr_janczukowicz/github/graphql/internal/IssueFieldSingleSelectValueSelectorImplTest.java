package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectOptionColor;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IssueFieldSingleSelectValueSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"color\":\"BLUE\"" + "," + "\"description\":\"x\"" + ","
            + "\"field\":{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"optionId\":\"x\"" + "," + "\"value\":\"x\"" + "}";

    private static List<Object> readWithArguments(final IssueFieldSingleSelectValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.color());
        values.add(selector.description());
        values.add(selector.field(child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.optionId());
        values.add(selector.value());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueFieldSingleSelectValueSelectorImpl(new RecordingCursor(root)));
        final IssueFieldSingleSelectValueSelectorImpl selector =
                new IssueFieldSingleSelectValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        IssueFieldSingleSelectOptionColor.BLUE,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        "x",
                        "x");
    }
}
