package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewEffortLevel;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewDefaultEffortSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class OrganizationCopilotCodeReviewSettingsSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"availableReviewEfforts\":[\"AUTO\"]" + ","
            + "\"defaultReviewEffort\":{\"configured\": \"AUTO\"}" + "}";

    private static List<Object> readWithArguments(final OrganizationCopilotCodeReviewSettingsSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.availableReviewEfforts());
        values.add(selector.defaultReviewEffort(OrganizationCopilotCodeReviewDefaultEffortSelector::configured));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrganizationCopilotCodeReviewSettingsSelectorImpl(new RecordingCursor(root)));
        final OrganizationCopilotCodeReviewSettingsSelectorImpl selector =
                new OrganizationCopilotCodeReviewSettingsSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(List.of(CopilotCodeReviewEffortLevel.AUTO), CopilotCodeReviewEffortLevel.AUTO);
    }
}
