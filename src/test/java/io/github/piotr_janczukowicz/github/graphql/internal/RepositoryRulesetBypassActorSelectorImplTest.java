package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetBypassActorBypassMode;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryRulesetBypassActorSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"actor\":{\"__typename\": \"App\", \"clientId\": \"x\"}" + "," + "\"bypassMode\":\"ALWAYS\"" + ","
                    + "\"deployKey\":true" + "," + "\"enterpriseOwner\":true" + "," + "\"enterpriseRole\":true" + ","
                    + "\"enterpriseRoleDatabaseId\":\"1\"" + "," + "\"id\":\"x\"" + "," + "\"organizationAdmin\":true"
                    + "," + "\"repositoryRoleDatabaseId\":1" + "," + "\"repositoryRoleName\":\"x\"" + ","
                    + "\"repositoryRuleset\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final RepositoryRulesetBypassActorSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(child -> child.on(AppSelector.class, AppSelector::clientId)));
        values.add(selector.bypassMode());
        values.add(selector.deployKey());
        values.add(selector.enterpriseOwner());
        values.add(selector.enterpriseRole());
        values.add(selector.enterpriseRoleDatabaseId());
        values.add(selector.id());
        values.add(selector.organizationAdmin());
        values.add(selector.repositoryRoleDatabaseId());
        values.add(selector.repositoryRoleName());
        values.add(selector.repositoryRuleset(RepositoryRulesetSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryRulesetBypassActorSelectorImpl(new RecordingCursor(root)));
        final RepositoryRulesetBypassActorSelectorImpl selector =
                new RepositoryRulesetBypassActorSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        RepositoryRulesetBypassActorBypassMode.ALWAYS,
                        true,
                        true,
                        true,
                        BigInteger.ONE,
                        "x",
                        true,
                        1,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
