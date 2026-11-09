package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateTeamsRepositoryPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"teams\":[{\"avatarUrl\": \"x\"}]" + "}";

    private static List<Object> readWithArguments(final UpdateTeamsRepositoryPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.teams(TeamSelector::avatarUrl));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateTeamsRepositoryPayloadSelectorImpl(new RecordingCursor(root)));
        final UpdateTeamsRepositoryPayloadSelectorImpl selector =
                new UpdateTeamsRepositoryPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", true, List.of("x"));
    }
}
