package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class EnvironmentSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"databaseId\":1" + "," + "\"id\":\"x\"" + "," + "\"isPinned\":true"
            + "," + "\"latestCompletedDeployment\":{\"commitOid\": \"x\"}" + "," + "\"name\":\"x\"" + ","
            + "\"pinnedPosition\":1" + ","
            + "\"protectionRules\":{\"nodes\": [{\"databaseId\": 1}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "}";

    private static List<Object> readWithArguments(final EnvironmentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.isPinned());
        values.add(selector.latestCompletedDeployment(DeploymentSelector::commitOid));
        values.add(selector.name());
        values.add(selector.pinnedPosition());
        values.add(selector.protectionRules(Paging.first(1), DeploymentProtectionRuleSelector::databaseId));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnvironmentSelectorImpl(new RecordingCursor(root)));
        final EnvironmentSelectorImpl selector =
                new EnvironmentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, "x", true, "x", "x", 1, new Page<>(List.of(1), false, null));
    }
}
