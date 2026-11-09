package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDataType;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldVisibility;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IssueFieldDateSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"dataType\":\"DATE\"" + "," + "\"description\":\"x\"" + "," + "\"fullDatabaseId\":\"1\"" + ","
            + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"visibility\":\"ALL\"" + "}";

    private static List<Object> readWithArguments(final IssueFieldDateSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.dataType());
        values.add(selector.description());
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.visibility());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueFieldDateSelectorImpl(new RecordingCursor(root)));
        final IssueFieldDateSelectorImpl selector =
                new IssueFieldDateSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        IssueFieldDataType.DATE,
                        "x",
                        BigInteger.ONE,
                        "x",
                        "x",
                        IssueFieldVisibility.ALL);
    }
}
