package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewRunnerConfiguredBy;
import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewRunnerType;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class OrganizationCopilotCodeReviewRunnerConfigurationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"allowRepositoryCustomization\":true" + ","
            + "\"configuredBy\":\"CODE_REVIEW\"" + "," + "\"runnerGroupName\":\"x\"" + "," + "\"runnerLabels\":[\"x\"]"
            + "," + "\"runnerType\":\"LABELED\"" + "}";

    private static List<Object> readWithArguments(
            final OrganizationCopilotCodeReviewRunnerConfigurationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.allowRepositoryCustomization());
        values.add(selector.configuredBy());
        values.add(selector.runnerGroupName());
        values.add(selector.runnerLabels());
        values.add(selector.runnerType());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrganizationCopilotCodeReviewRunnerConfigurationSelectorImpl(new RecordingCursor(root)));
        final OrganizationCopilotCodeReviewRunnerConfigurationSelectorImpl selector =
                new OrganizationCopilotCodeReviewRunnerConfigurationSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        CopilotCodeReviewRunnerConfiguredBy.CODE_REVIEW,
                        "x",
                        List.of("x"),
                        CopilotCodeReviewRunnerType.LABELED);
    }
}
