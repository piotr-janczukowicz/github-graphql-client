package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DeploymentRequestSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"currentUserCanApprove\":true" + "," + "\"environment\":{\"databaseId\": 1}" + ","
                    + "\"reviewers\":{\"nodes\": [{\"__typename\": \"Team\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "," + "\"waitTimer\":1" + "," + "\"waitTimerStartedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final DeploymentRequestSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.currentUserCanApprove());
        values.add(selector.environment(EnvironmentSelector::databaseId));
        values.add(selector.reviewers(Paging.first(1), child -> child.on(TeamSelector.class, TeamSelector::avatarUrl)));
        values.add(selector.waitTimer());
        values.add(selector.waitTimerStartedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DeploymentRequestSelectorImpl(new RecordingCursor(root)));
        final DeploymentRequestSelectorImpl selector =
                new DeploymentRequestSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true, 1, new Page<>(List.of("x"), false, null), 1, Instant.parse("2024-05-01T10:15:30Z"));
    }
}
