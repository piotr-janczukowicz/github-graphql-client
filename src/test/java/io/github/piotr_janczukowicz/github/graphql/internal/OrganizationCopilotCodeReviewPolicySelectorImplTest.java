package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicyManager;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicyState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class OrganizationCopilotCodeReviewPolicySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"configuredState\":\"DISABLED\"" + "," + "\"editable\":true" + ","
            + "\"effectiveState\":\"DISABLED\"" + "," + "\"managedBy\":\"ENTERPRISE\"" + "}";

    private static List<Object> readWithArguments(final OrganizationCopilotCodeReviewPolicySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.configuredState());
        values.add(selector.editable());
        values.add(selector.effectiveState());
        values.add(selector.managedBy());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrganizationCopilotCodeReviewPolicySelectorImpl(new RecordingCursor(root)));
        final OrganizationCopilotCodeReviewPolicySelectorImpl selector =
                new OrganizationCopilotCodeReviewPolicySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        OrganizationCopilotCodeReviewPolicyState.DISABLED,
                        true,
                        OrganizationCopilotCodeReviewPolicyState.DISABLED,
                        OrganizationCopilotCodeReviewPolicyManager.ENTERPRISE);
    }
}
