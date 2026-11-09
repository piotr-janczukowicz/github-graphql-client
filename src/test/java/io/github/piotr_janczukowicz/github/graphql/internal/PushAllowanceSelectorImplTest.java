package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PushAllowanceSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"__typename\": \"App\", \"clientId\": \"x\"}" + ","
            + "\"branchProtectionRule\":{\"allowsDeletions\": true}" + "," + "\"id\":\"x\"" + "}";

    private static List<Object> readWithArguments(final PushAllowanceSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(child -> child.on(AppSelector.class, AppSelector::clientId)));
        values.add(selector.branchProtectionRule(BranchProtectionRuleSelector::allowsDeletions));
        values.add(selector.id());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PushAllowanceSelectorImpl(new RecordingCursor(root)));
        final PushAllowanceSelectorImpl selector =
                new PushAllowanceSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", true, "x");
    }
}
