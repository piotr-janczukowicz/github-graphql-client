package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IssueFieldDateValueSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"field\":{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
                    + "\"id\":\"x\"" + "," + "\"value\":\"x\"" + "}";

    private static List<Object> readWithArguments(final IssueFieldDateValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.field(child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.id());
        values.add(selector.value());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueFieldDateValueSelectorImpl(new RecordingCursor(root)));
        final IssueFieldDateValueSelectorImpl selector =
                new IssueFieldDateValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(Instant.parse("2024-05-01T10:15:30Z"), "x", "x");
    }
}
