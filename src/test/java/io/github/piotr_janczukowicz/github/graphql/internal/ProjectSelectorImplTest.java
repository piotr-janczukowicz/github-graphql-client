package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardArchivedState;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectPendingCardsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectProgressSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + "," + "\"closed\":true"
            + "," + "\"closedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"columns\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"creator\":{\"avatarUrl\": \"x\"}" + ","
            + "\"databaseId\":1" + "," + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"number\":1" + ","
            + "\"owner\":{\"id\": \"x\"}" + ","
            + "\"pendingCards\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"progress\":{\"doneCount\": 1}" + "," + "\"resourcePath\":\"x\"" + "," + "\"state\":\"CLOSED\""
            + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "," + "\"viewerCanClose\":true"
            + "," + "\"viewerCanReopen\":true" + "," + "\"viewerCanUpdate\":true" + "}";

    private static List<Object> readWithArguments(final ProjectSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.closed());
        values.add(selector.closedAt());
        values.add(selector.columns(Paging.first(1), ProjectColumnSelector::createdAt));
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.number());
        values.add(selector.owner(ProjectOwnerSelector::id));
        values.add(selector.pendingCards(
                Paging.first(1),
                ProjectPendingCardsFilterBuilder.builder()
                        .archivedStates(List.of(ProjectCardArchivedState.ARCHIVED))
                        .build(),
                ProjectCardSelector::createdAt));
        values.add(selector.progress(ProjectProgressSelector::doneCount));
        values.add(selector.resourcePath());
        values.add(selector.state());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.viewerCanClose());
        values.add(selector.viewerCanReopen());
        values.add(selector.viewerCanUpdate());
        return values;
    }

    private static List<Object> readWithoutArguments(final ProjectSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.pendingCards(Paging.first(1), ProjectCardSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectSelectorImpl(new RecordingCursor(root)));
        final ProjectSelectorImpl selector =
                new ProjectSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        1,
                        "x",
                        "x",
                        1,
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        1,
                        "x",
                        ProjectState.CLOSED,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        true,
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ProjectSelectorImpl(new RecordingCursor(root)));
        final ProjectSelectorImpl selector =
                new ProjectSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
