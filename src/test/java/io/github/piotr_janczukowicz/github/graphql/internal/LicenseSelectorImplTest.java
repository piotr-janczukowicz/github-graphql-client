package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.LicenseRuleSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class LicenseSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"body\":\"x\"" + "," + "\"conditions\":[{\"description\": \"x\"}]"
            + "," + "\"description\":\"x\"" + "," + "\"featured\":true" + "," + "\"hidden\":true" + "," + "\"id\":\"x\""
            + "," + "\"implementation\":\"x\"" + "," + "\"key\":\"x\"" + ","
            + "\"limitations\":[{\"description\": \"x\"}]" + "," + "\"name\":\"x\"" + "," + "\"nickname\":\"x\"" + ","
            + "\"permissions\":[{\"description\": \"x\"}]" + "," + "\"pseudoLicense\":true" + "," + "\"spdxId\":\"x\""
            + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final LicenseSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.body());
        values.add(selector.conditions(LicenseRuleSelector::description));
        values.add(selector.description());
        values.add(selector.featured());
        values.add(selector.hidden());
        values.add(selector.id());
        values.add(selector.implementation());
        values.add(selector.key());
        values.add(selector.limitations(LicenseRuleSelector::description));
        values.add(selector.name());
        values.add(selector.nickname());
        values.add(selector.permissions(LicenseRuleSelector::description));
        values.add(selector.pseudoLicense());
        values.add(selector.spdxId());
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new LicenseSelectorImpl(new RecordingCursor(root)));
        final LicenseSelectorImpl selector =
                new LicenseSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        List.of("x"),
                        "x",
                        true,
                        true,
                        "x",
                        "x",
                        "x",
                        List.of("x"),
                        "x",
                        "x",
                        List.of("x"),
                        true,
                        "x",
                        "x");
    }
}
