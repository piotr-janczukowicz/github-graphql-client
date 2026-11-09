package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentStatusState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DeploymentStatusSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"creator\":{\"avatarUrl\": \"x\"}" + "," + "\"deployment\":{\"commitOid\": \"x\"}" + ","
            + "\"description\":\"x\"" + "," + "\"environment\":\"x\"" + "," + "\"environmentUrl\":\"x\"" + ","
            + "\"id\":\"x\"" + "," + "\"logUrl\":\"x\"" + "," + "\"state\":\"ERROR\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final DeploymentStatusSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.deployment(DeploymentSelector::commitOid));
        values.add(selector.description());
        values.add(selector.environment());
        values.add(selector.environmentUrl());
        values.add(selector.id());
        values.add(selector.logUrl());
        values.add(selector.state());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DeploymentStatusSelectorImpl(new RecordingCursor(root)));
        final DeploymentStatusSelectorImpl selector =
                new DeploymentStatusSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        DeploymentStatusState.ERROR,
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
