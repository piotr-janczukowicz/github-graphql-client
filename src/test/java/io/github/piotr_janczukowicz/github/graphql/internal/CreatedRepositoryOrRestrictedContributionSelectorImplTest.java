package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CreatedRepositoryContributionSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CreatedRepositoryOrRestrictedContributionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"isRestricted\":true" + "," + "\"__typename\":\"CreatedRepositoryContribution\"" + "}";

    private static List<Object> readWithArguments(
            final CreatedRepositoryOrRestrictedContributionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(
                CreatedRepositoryContributionSelector.class, CreatedRepositoryContributionSelector::isRestricted));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CreatedRepositoryOrRestrictedContributionSelectorImpl(new RecordingCursor(root)));
        final CreatedRepositoryOrRestrictedContributionSelectorImpl selector =
                new CreatedRepositoryOrRestrictedContributionSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true);
    }
}
