package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import io.github.piotr_janczukowicz.github.graphql.model.CustomPropertyValueType;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertyValuesEditableBy;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryCustomPropertySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"allowedValues\":[\"x\"]" + "," + "\"defaultValue\":\"x\"" + ","
            + "\"description\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"propertyName\":\"x\"" + "," + "\"regex\":\"x\""
            + "," + "\"requireExplicitValues\":true" + "," + "\"required\":true" + ","
            + "\"source\":{\"__typename\": \"Enterprise\", \"avatarUrl\": \"x\"}" + ","
            + "\"valueType\":\"MULTI_SELECT\"" + "," + "\"valuesEditableBy\":\"ORG_ACTORS\"" + "}";

    private static List<Object> readWithArguments(final RepositoryCustomPropertySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.allowedValues());
        values.add(selector.defaultValue());
        values.add(selector.description());
        values.add(selector.id());
        values.add(selector.propertyName());
        values.add(selector.regex());
        values.add(selector.requireExplicitValues());
        values.add(selector.required());
        values.add(selector.source(child -> child.on(EnterpriseSelector.class, EnterpriseSelector::avatarUrl)));
        values.add(selector.valueType());
        values.add(selector.valuesEditableBy());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryCustomPropertySelectorImpl(new RecordingCursor(root)));
        final RepositoryCustomPropertySelectorImpl selector =
                new RepositoryCustomPropertySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        List.of("x"),
                        CustomPropertyValue.ofText("x"),
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        true,
                        "x",
                        CustomPropertyValueType.MULTI_SELECT,
                        RepositoryCustomPropertyValuesEditableBy.ORG_ACTORS);
    }
}
