package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class StatusCheckRollupSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"commit\":{\"abbreviatedOid\": \"x\"}" + ","
            + "\"contexts\":{\"nodes\": [{\"__typename\": \"CheckRun\", \"completedAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"state\":\"ERROR\"" + "}";

    private static List<Object> readWithArguments(final StatusCheckRollupSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.contexts(
                Paging.first(1), child -> child.on(CheckRunSelector.class, CheckRunSelector::completedAt)));
        values.add(selector.id());
        values.add(selector.state());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new StatusCheckRollupSelectorImpl(new RecordingCursor(root)));
        final StatusCheckRollupSelectorImpl selector =
                new StatusCheckRollupSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        new Page<>(List.of(Instant.parse("2024-05-01T10:15:30Z")), false, null),
                        "x",
                        StatusState.ERROR);
    }
}
