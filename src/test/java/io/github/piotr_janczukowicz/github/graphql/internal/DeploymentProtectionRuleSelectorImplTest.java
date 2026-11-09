package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentProtectionRuleType;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DeploymentProtectionRuleSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"databaseId\":1" + "," + "\"preventSelfReview\":true" + ","
            + "\"reviewers\":{\"nodes\": [{\"__typename\": \"Team\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"timeout\":1" + "," + "\"type\":\"BRANCH_POLICY\"" + "}";

    private static List<Object> readWithArguments(final DeploymentProtectionRuleSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.databaseId());
        values.add(selector.preventSelfReview());
        values.add(selector.reviewers(Paging.first(1), child -> child.on(TeamSelector.class, TeamSelector::avatarUrl)));
        values.add(selector.timeout());
        values.add(selector.type());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DeploymentProtectionRuleSelectorImpl(new RecordingCursor(root)));
        final DeploymentProtectionRuleSelectorImpl selector =
                new DeploymentProtectionRuleSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        1, true, new Page<>(List.of("x"), false, null), 1, DeploymentProtectionRuleType.BRANCH_POLICY);
    }
}
