package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class BranchProtectionRuleConflictSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"branchProtectionRule\":{\"allowsDeletions\": true}" + ","
            + "\"conflictingBranchProtectionRule\":{\"allowsDeletions\": true}" + "," + "\"ref\":{\"id\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final BranchProtectionRuleConflictSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.branchProtectionRule(BranchProtectionRuleSelector::allowsDeletions));
        values.add(selector.conflictingBranchProtectionRule(BranchProtectionRuleSelector::allowsDeletions));
        values.add(selector.ref(RefSelector::id));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new BranchProtectionRuleConflictSelectorImpl(new RecordingCursor(root)));
        final BranchProtectionRuleConflictSelectorImpl selector =
                new BranchProtectionRuleConflictSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, true, "x");
    }
}
