package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateBranchProtectionRulePayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"branchProtectionRule\":{\"allowsDeletions\": true}" + "," + "\"clientMutationId\":\"x\"" + "}";

    private static List<Object> readWithArguments(final UpdateBranchProtectionRulePayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.branchProtectionRule(BranchProtectionRuleSelector::allowsDeletions));
        values.add(selector.clientMutationId());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateBranchProtectionRulePayloadSelectorImpl(new RecordingCursor(root)));
        final UpdateBranchProtectionRulePayloadSelectorImpl selector =
                new UpdateBranchProtectionRulePayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, "x");
    }
}
