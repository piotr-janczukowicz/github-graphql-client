package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardState;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectCardSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"column\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"content\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"creator\":{\"avatarUrl\": \"x\"}" + ","
            + "\"databaseId\":1" + "," + "\"id\":\"x\"" + "," + "\"isArchived\":true" + "," + "\"note\":\"x\"" + ","
            + "\"project\":{\"closed\": true}" + "," + "\"resourcePath\":\"x\"" + "," + "\"state\":\"CONTENT_ONLY\""
            + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ProjectCardSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.column(ProjectColumnSelector::createdAt));
        values.add(selector.content(child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.isArchived());
        values.add(selector.note());
        values.add(selector.project(ProjectSelector::closed));
        values.add(selector.resourcePath());
        values.add(selector.state());
        values.add(selector.updatedAt());
        values.add(selector.url());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectCardSelectorImpl(new RecordingCursor(root)));
        final ProjectCardSelectorImpl selector =
                new ProjectCardSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        LockReason.OFF_TOPIC,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        1,
                        "x",
                        true,
                        "x",
                        true,
                        "x",
                        ProjectCardState.CONTENT_ONLY,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x");
    }
}
