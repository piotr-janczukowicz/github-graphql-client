package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdateStatus;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectV2StatusUpdateSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"creator\":{\"avatarUrl\": \"x\"}" + ","
            + "\"databaseId\":1" + "," + "\"fullDatabaseId\":\"1\"" + "," + "\"id\":\"x\"" + ","
            + "\"project\":{\"closed\": true}" + "," + "\"startDate\":\"2024-05-01\"" + "," + "\"status\":\"AT_RISK\""
            + "," + "\"targetDate\":\"2024-05-01\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2StatusUpdateSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.databaseId());
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.project(ProjectV2Selector::closed));
        values.add(selector.startDate());
        values.add(selector.status());
        values.add(selector.targetDate());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2StatusUpdateSelectorImpl(new RecordingCursor(root)));
        final ProjectV2StatusUpdateSelectorImpl selector =
                new ProjectV2StatusUpdateSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        1,
                        BigInteger.ONE,
                        "x",
                        true,
                        LocalDate.of(2024, 5, 1),
                        ProjectV2StatusUpdateStatus.AT_RISK,
                        LocalDate.of(2024, 5, 1),
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
