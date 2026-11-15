package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicyConflict;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicyState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateOrganizationCopilotCodeReviewPolicyPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"clientMutationId\":\"x\"" + "," + "\"conflict\":\"POLICY_MANAGED_BY_ENTERPRISE\"" + ","
                    + "\"policy\":{\"configuredState\": \"DISABLED\"}" + "}";

    private static List<Object> readWithArguments(
            final UpdateOrganizationCopilotCodeReviewPolicyPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.conflict());
        values.add(selector.policy(OrganizationCopilotCodeReviewPolicySelector::configuredState));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateOrganizationCopilotCodeReviewPolicyPayloadSelectorImpl(new RecordingCursor(root)));
        final UpdateOrganizationCopilotCodeReviewPolicyPayloadSelectorImpl selector =
                new UpdateOrganizationCopilotCodeReviewPolicyPayloadSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        OrganizationCopilotCodeReviewPolicyConflict.POLICY_MANAGED_BY_ENTERPRISE,
                        OrganizationCopilotCodeReviewPolicyState.DISABLED);
    }
}
