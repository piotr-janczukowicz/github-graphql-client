package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SingleSelectFieldOptionColor;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2SingleSelectFieldOptionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"color\":\"BLUE\"" + "," + "\"description\":\"x\"" + "," + "\"descriptionHTML\":\"x\"" + ","
                    + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"nameHTML\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2SingleSelectFieldOptionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.color());
        values.add(selector.description());
        values.add(selector.descriptionHTML());
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.nameHTML());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2SingleSelectFieldOptionSelectorImpl(new RecordingCursor(root)));
        final ProjectV2SingleSelectFieldOptionSelectorImpl selector =
                new ProjectV2SingleSelectFieldOptionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(ProjectV2SingleSelectFieldOptionColor.BLUE, "x", "x", "x", "x", "x");
    }
}
