package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackEntrySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PullRequestStackSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"baseRefName\":\"x\"" + ","
            + "\"entries\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"number\":1" + "," + "\"size\":1" + "}";

    private static List<Object> readWithArguments(final PullRequestStackSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.baseRefName());
        values.add(selector.entries(Paging.first(1), PullRequestStackEntrySelector::id));
        values.add(selector.id());
        values.add(selector.number());
        values.add(selector.size());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PullRequestStackSelectorImpl(new RecordingCursor(root)));
        final PullRequestStackSelectorImpl selector =
                new PullRequestStackSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", new Page<>(List.of("x"), false, null), "x", 1, 1);
    }
}
