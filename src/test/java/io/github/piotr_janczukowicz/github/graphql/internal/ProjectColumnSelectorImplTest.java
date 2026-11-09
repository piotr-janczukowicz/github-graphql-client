package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardArchivedState;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnCardsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnPurpose;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectColumnSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"cards\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + "," + "\"id\":\"x\"" + ","
            + "\"name\":\"x\"" + "," + "\"project\":{\"closed\": true}" + "," + "\"purpose\":\"DONE\"" + ","
            + "\"resourcePath\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ProjectColumnSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.cards(
                Paging.first(1),
                ProjectColumnCardsFilterBuilder.builder()
                        .archivedStates(List.of(ProjectCardArchivedState.ARCHIVED))
                        .build(),
                ProjectCardSelector::createdAt));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.project(ProjectSelector::closed));
        values.add(selector.purpose());
        values.add(selector.resourcePath());
        values.add(selector.updatedAt());
        values.add(selector.url());
        return values;
    }

    private static List<Object> readWithoutArguments(final ProjectColumnSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.cards(Paging.first(1), ProjectCardSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectColumnSelectorImpl(new RecordingCursor(root)));
        final ProjectColumnSelectorImpl selector =
                new ProjectColumnSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        "x",
                        true,
                        ProjectColumnPurpose.DONE,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ProjectColumnSelectorImpl(new RecordingCursor(root)));
        final ProjectColumnSelectorImpl selector =
                new ProjectColumnSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
