package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentityAttributeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserEmailMetadataSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ExternalIdentitySamlAttributesSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"attributes\":[{\"metadata\": \"x\"}]" + ","
            + "\"emails\":[{\"primary\": true}]" + "," + "\"familyName\":\"x\"" + "," + "\"givenName\":\"x\"" + ","
            + "\"groups\":[\"x\"]" + "," + "\"nameId\":\"x\"" + "," + "\"username\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ExternalIdentitySamlAttributesSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.attributes(ExternalIdentityAttributeSelector::metadata));
        values.add(selector.emails(UserEmailMetadataSelector::primary));
        values.add(selector.familyName());
        values.add(selector.givenName());
        values.add(selector.groups());
        values.add(selector.nameId());
        values.add(selector.username());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ExternalIdentitySamlAttributesSelectorImpl(new RecordingCursor(root)));
        final ExternalIdentitySamlAttributesSelectorImpl selector =
                new ExternalIdentitySamlAttributesSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of("x"), List.of(true), "x", "x", List.of("x"), "x", "x");
    }
}
