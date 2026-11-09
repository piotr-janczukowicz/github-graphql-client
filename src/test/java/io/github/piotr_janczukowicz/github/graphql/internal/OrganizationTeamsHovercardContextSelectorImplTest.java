package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class OrganizationTeamsHovercardContextSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"message\":\"x\"" + "," + "\"octicon\":\"x\"" + ","
            + "\"relevantTeams\":{\"nodes\": [{\"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"teamsResourcePath\":\"x\"" + "," + "\"teamsUrl\":\"x\"" + "," + "\"totalTeamCount\":1" + "}";

    private static List<Object> readWithArguments(final OrganizationTeamsHovercardContextSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.message());
        values.add(selector.octicon());
        values.add(selector.relevantTeams(Paging.first(1), TeamSelector::avatarUrl));
        values.add(selector.teamsResourcePath());
        values.add(selector.teamsUrl());
        values.add(selector.totalTeamCount());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrganizationTeamsHovercardContextSelectorImpl(new RecordingCursor(root)));
        final OrganizationTeamsHovercardContextSelectorImpl selector =
                new OrganizationTeamsHovercardContextSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", new Page<>(List.of("x"), false, null), "x", "x", 1);
    }
}
