package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class StatusSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"combinedContexts\":{\"nodes\": [{\"__typename\": \"CheckRun\", \"completedAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"commit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"context\":{\"avatarUrl\": \"x\"}" + ","
            + "\"contexts\":[{\"avatarUrl\": \"x\"}]" + "," + "\"id\":\"x\"" + "," + "\"state\":\"ERROR\"" + "}";

    private static List<Object> readWithArguments(final StatusSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.combinedContexts(
                Paging.first(1), child -> child.on(CheckRunSelector.class, CheckRunSelector::completedAt)));
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.context("x", StatusContextSelector::avatarUrl));
        values.add(selector.contexts(StatusContextSelector::avatarUrl));
        values.add(selector.id());
        values.add(selector.state());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new StatusSelectorImpl(new RecordingCursor(root)));
        final StatusSelectorImpl selector = new StatusSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(Instant.parse("2024-05-01T10:15:30Z")), false, null),
                        "x",
                        "x",
                        List.of("x"),
                        "x",
                        StatusState.ERROR);
    }
}
