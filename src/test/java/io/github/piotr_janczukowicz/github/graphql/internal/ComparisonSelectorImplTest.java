package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ComparisonStatus;
import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ComparisonSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"aheadBy\":1" + "," + "\"baseTarget\":{\"abbreviatedOid\": \"x\"}" + "," + "\"behindBy\":1" + ","
                    + "\"commits\":{\"nodes\": [{\"abbreviatedOid\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "," + "\"headTarget\":{\"abbreviatedOid\": \"x\"}" + "," + "\"id\":\"x\"" + ","
                    + "\"status\":\"AHEAD\"" + "}";

    private static List<Object> readWithArguments(final ComparisonSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.aheadBy());
        values.add(selector.baseTarget(GitObjectSelector::abbreviatedOid));
        values.add(selector.behindBy());
        values.add(selector.commits(Paging.first(1), CommitSelector::abbreviatedOid));
        values.add(selector.headTarget(GitObjectSelector::abbreviatedOid));
        values.add(selector.id());
        values.add(selector.status());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ComparisonSelectorImpl(new RecordingCursor(root)));
        final ComparisonSelectorImpl selector =
                new ComparisonSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(1, "x", 1, new Page<>(List.of("x"), false, null), "x", "x", ComparisonStatus.AHEAD);
    }
}
