package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPropertyTargetDefinitionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleType;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetBypassActorBypassMode;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetBypassActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetRulesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetTarget;
import io.github.piotr_janczukowicz.github.graphql.model.RuleEnforcement;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryRulesetSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"bypassActors\":{\"nodes\": [{\"bypassMode\": \"ALWAYS\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"conditions\":{\"organizationProperty\": {\"exclude\": [{\"name\": \"x\"}]}}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + "," + "\"enforcement\":\"ACTIVE\""
            + "," + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + ","
            + "\"rules\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"source\":{\"__typename\": \"Enterprise\", \"avatarUrl\": \"x\"}" + "," + "\"target\":\"BRANCH\""
            + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final RepositoryRulesetSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.bypassActors(Paging.first(1), RepositoryRulesetBypassActorSelector::bypassMode));
        values.add(selector.conditions(child -> child.organizationProperty(
                child1 -> child1.exclude(OrganizationPropertyTargetDefinitionSelector::name))));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.enforcement());
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.rules(
                Paging.first(1),
                RepositoryRulesetRulesFilterBuilder.builder()
                        .type(RepositoryRuleType.AUTHORIZATION)
                        .build(),
                RepositoryRuleSelector::id));
        values.add(selector.source(child -> child.on(EnterpriseSelector.class, EnterpriseSelector::avatarUrl)));
        values.add(selector.target());
        values.add(selector.updatedAt());
        return values;
    }

    private static List<Object> readWithoutArguments(final RepositoryRulesetSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.rules(Paging.first(1), RepositoryRuleSelector::id));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryRulesetSelectorImpl(new RecordingCursor(root)));
        final RepositoryRulesetSelectorImpl selector =
                new RepositoryRulesetSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(RepositoryRulesetBypassActorBypassMode.ALWAYS), false, null),
                        List.of("x"),
                        Instant.parse("2024-05-01T10:15:30Z"),
                        1,
                        RuleEnforcement.ACTIVE,
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        RepositoryRulesetTarget.BRANCH,
                        Instant.parse("2024-05-01T10:15:30Z"));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new RepositoryRulesetSelectorImpl(new RecordingCursor(root)));
        final RepositoryRulesetSelectorImpl selector =
                new RepositoryRulesetSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
