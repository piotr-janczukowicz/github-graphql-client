package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.BranchNamePatternParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleType;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryRuleSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + ","
            + "\"parameters\":{\"__typename\": \"BranchNamePatternParameters\", \"name\": \"x\"}" + ","
            + "\"repositoryRuleset\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"type\":\"AUTHORIZATION\""
            + "}";

    private static List<Object> readWithArguments(final RepositoryRuleSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.parameters(child ->
                child.on(BranchNamePatternParametersSelector.class, BranchNamePatternParametersSelector::name)));
        values.add(selector.repositoryRuleset(RepositoryRulesetSelector::createdAt));
        values.add(selector.type());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryRuleSelectorImpl(new RecordingCursor(root)));
        final RepositoryRuleSelectorImpl selector =
                new RepositoryRuleSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly("x", "x", Instant.parse("2024-05-01T10:15:30Z"), RepositoryRuleType.AUTHORIZATION);
    }
}
