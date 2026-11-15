package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseCopilotCodeReviewPolicySelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseCopilotCodeReviewPolicyState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"policy\":{\"policyState\": \"CONFIGURED_BY_ORGANIZATION_ADMINS\"}" + "}";

    private static List<Object> readWithArguments(
            final UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.policy(EnterpriseCopilotCodeReviewPolicySelector::policyState));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelectorImpl(new RecordingCursor(root)));
        final UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelectorImpl selector =
                new UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly("x", EnterpriseCopilotCodeReviewPolicyState.CONFIGURED_BY_ORGANIZATION_ADMINS);
    }
}
