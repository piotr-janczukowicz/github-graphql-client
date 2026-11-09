package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentState;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentStatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DeploymentSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"commit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"commitOid\":\"x\""
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"creator\":{\"avatarUrl\": \"x\"}" + ","
            + "\"databaseId\":1" + "," + "\"description\":\"x\"" + "," + "\"environment\":\"x\"" + "," + "\"id\":\"x\""
            + "," + "\"latestEnvironment\":\"x\"" + "," + "\"latestStatus\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}"
            + "," + "\"originalEnvironment\":\"x\"" + "," + "\"payload\":\"x\"" + "," + "\"ref\":{\"id\": \"x\"}" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"state\":\"ABANDONED\"" + ","
            + "\"statuses\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"task\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final DeploymentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.commitOid());
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.databaseId());
        values.add(selector.description());
        values.add(selector.environment());
        values.add(selector.id());
        values.add(selector.latestEnvironment());
        values.add(selector.latestStatus(DeploymentStatusSelector::createdAt));
        values.add(selector.originalEnvironment());
        values.add(selector.payload());
        values.add(selector.ref(RefSelector::id));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.state());
        values.add(selector.statuses(Paging.first(1), DeploymentStatusSelector::createdAt));
        values.add(selector.task());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DeploymentSelectorImpl(new RecordingCursor(root)));
        final DeploymentSelectorImpl selector =
                new DeploymentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        1,
                        "x",
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        "x",
                        true,
                        DeploymentState.ABANDONED,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
