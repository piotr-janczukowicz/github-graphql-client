package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewEffortLevel;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewSettingsConflict;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewSettingsSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateOrganizationCopilotCodeReviewSettingsPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"clientMutationId\":\"x\"" + "," + "\"conflict\":\"SETTING_NOT_EDITABLE\"" + ","
                    + "\"settings\":{\"availableReviewEfforts\": [\"AUTO\"]}" + "}";

    private static List<Object> readWithArguments(
            final UpdateOrganizationCopilotCodeReviewSettingsPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.conflict());
        values.add(selector.settings(OrganizationCopilotCodeReviewSettingsSelector::availableReviewEfforts));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(
                new UpdateOrganizationCopilotCodeReviewSettingsPayloadSelectorImpl(new RecordingCursor(root)));
        final UpdateOrganizationCopilotCodeReviewSettingsPayloadSelectorImpl selector =
                new UpdateOrganizationCopilotCodeReviewSettingsPayloadSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        OrganizationCopilotCodeReviewSettingsConflict.SETTING_NOT_EDITABLE,
                        List.of(CopilotCodeReviewEffortLevel.AUTO));
    }
}
