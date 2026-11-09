package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPropertyTargetDefinitionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PropertyTargetDefinitionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefNameConditionTargetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIdConditionTargetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryNameConditionTargetSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryRuleConditionsSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"organizationProperty\":{\"exclude\": [{\"name\": \"x\"}]}" + ","
            + "\"refName\":{\"exclude\": [\"x\"]}" + "," + "\"repositoryId\":{\"repositoryIds\": [\"x\"]}" + ","
            + "\"repositoryName\":{\"exclude\": [\"x\"]}" + ","
            + "\"repositoryProperty\":{\"exclude\": [{\"name\": \"x\"}]}" + "}";

    private static List<Object> readWithArguments(final RepositoryRuleConditionsSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.organizationProperty(
                child -> child.exclude(OrganizationPropertyTargetDefinitionSelector::name)));
        values.add(selector.refName(RefNameConditionTargetSelector::exclude));
        values.add(selector.repositoryId(RepositoryIdConditionTargetSelector::repositoryIds));
        values.add(selector.repositoryName(RepositoryNameConditionTargetSelector::exclude));
        values.add(selector.repositoryProperty(child -> child.exclude(PropertyTargetDefinitionSelector::name)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryRuleConditionsSelectorImpl(new RecordingCursor(root)));
        final RepositoryRuleConditionsSelectorImpl selector =
                new RepositoryRuleConditionsSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of("x"), List.of("x"), List.of("x"), List.of("x"), List.of("x"));
    }
}
