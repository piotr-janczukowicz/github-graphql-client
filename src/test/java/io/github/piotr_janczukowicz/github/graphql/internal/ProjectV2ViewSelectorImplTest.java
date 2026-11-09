package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SortByFieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SortBySelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewGroupByFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewGroupByFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewLayout;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewVerticalGroupByFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewVerticalGroupByFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewVisibleFieldsFilterBuilder;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectV2ViewSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"configuration\":{\"visibleFields\": {\"nodes\": [{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}}"
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + ","
            + "\"fields\":{\"nodes\": [{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"filter\":\"x\"" + "," + "\"fullDatabaseId\":\"1\"" + ","
            + "\"groupBy\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"groupByFields\":{\"nodes\": [{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"layout\":\"BOARD_LAYOUT\"" + "," + "\"name\":\"x\"" + "," + "\"number\":1"
            + "," + "\"project\":{\"closed\": true}" + ","
            + "\"sortBy\":{\"nodes\": [{\"direction\": \"ASC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sortByFields\":{\"nodes\": [{\"direction\": \"ASC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"verticalGroupBy\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"verticalGroupByFields\":{\"nodes\": [{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"visibleFields\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "}";

    private static List<Object> readWithArguments(final ProjectV2ViewSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.configuration(child -> child.visibleFields(
                Paging.first(1),
                child1 -> child1.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt))));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.fields(
                Paging.first(1),
                ProjectV2ViewFieldsFilterBuilder.builder()
                        .orderBy(ProjectV2FieldOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2FieldOrderField.CREATED_AT)
                                .build())
                        .build(),
                child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.filter());
        values.add(selector.fullDatabaseId());
        values.add(selector.groupBy(
                Paging.first(1),
                ProjectV2ViewGroupByFilterBuilder.builder()
                        .orderBy(ProjectV2FieldOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2FieldOrderField.CREATED_AT)
                                .build())
                        .build(),
                ProjectV2FieldSelector::createdAt));
        values.add(selector.groupByFields(
                Paging.first(1),
                ProjectV2ViewGroupByFieldsFilterBuilder.builder()
                        .orderBy(ProjectV2FieldOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2FieldOrderField.CREATED_AT)
                                .build())
                        .build(),
                child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.id());
        values.add(selector.layout());
        values.add(selector.name());
        values.add(selector.number());
        values.add(selector.project(ProjectV2Selector::closed));
        values.add(selector.sortBy(Paging.first(1), ProjectV2SortBySelector::direction));
        values.add(selector.sortByFields(Paging.first(1), ProjectV2SortByFieldSelector::direction));
        values.add(selector.updatedAt());
        values.add(selector.verticalGroupBy(
                Paging.first(1),
                ProjectV2ViewVerticalGroupByFilterBuilder.builder()
                        .orderBy(ProjectV2FieldOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2FieldOrderField.CREATED_AT)
                                .build())
                        .build(),
                ProjectV2FieldSelector::createdAt));
        values.add(selector.verticalGroupByFields(
                Paging.first(1),
                ProjectV2ViewVerticalGroupByFieldsFilterBuilder.builder()
                        .orderBy(ProjectV2FieldOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2FieldOrderField.CREATED_AT)
                                .build())
                        .build(),
                child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.visibleFields(
                Paging.first(1),
                ProjectV2ViewVisibleFieldsFilterBuilder.builder()
                        .orderBy(ProjectV2FieldOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2FieldOrderField.CREATED_AT)
                                .build())
                        .build(),
                ProjectV2FieldSelector::createdAt));
        return values;
    }

    private static List<Object> readWithoutArguments(final ProjectV2ViewSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.fields(
                Paging.first(1), child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.groupBy(Paging.first(1), ProjectV2FieldSelector::createdAt));
        values.add(selector.groupByFields(
                Paging.first(1), child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.verticalGroupBy(Paging.first(1), ProjectV2FieldSelector::createdAt));
        values.add(selector.verticalGroupByFields(
                Paging.first(1), child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.visibleFields(Paging.first(1), ProjectV2FieldSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2ViewSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ViewSelectorImpl selector =
                new ProjectV2ViewSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        BigInteger.ONE,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        ProjectV2ViewLayout.BOARD_LAYOUT,
                        "x",
                        1,
                        true,
                        new Page<>(List.of(OrderDirection.ASC), false, null),
                        new Page<>(List.of(OrderDirection.ASC), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ProjectV2ViewSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ViewSelectorImpl selector =
                new ProjectV2ViewSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
