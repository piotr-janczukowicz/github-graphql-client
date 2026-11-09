package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemArchivedState;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2RepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdateOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdatesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2TeamsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2WorkflowOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2WorkflowSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2WorkflowsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2WorkflowsOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TeamOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectV2SelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"closed\":true" + "," + "\"closedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"creator\":{\"avatarUrl\": \"x\"}" + ","
            + "\"databaseId\":1" + ","
            + "\"field\":{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"fields\":{\"nodes\": [{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"fullDatabaseId\":\"1\"" + "," + "\"id\":\"x\"" + ","
            + "\"items\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"number\":1" + "," + "\"owner\":{\"id\": \"x\"}" + "," + "\"public\":true" + ","
            + "\"readme\":\"x\"" + ","
            + "\"repositories\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"resourcePath\":\"x\"" + "," + "\"shortDescription\":\"x\"" + ","
            + "\"statusUpdates\":{\"nodes\": [{\"body\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"teams\":{\"nodes\": [{\"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"template\":true" + "," + "\"title\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"url\":\"x\"" + "," + "\"view\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"viewerCanClose\":true" + "," + "\"viewerCanReopen\":true" + "," + "\"viewerCanUpdate\":true" + ","
            + "\"views\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"workflow\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"workflows\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "}";

    private static List<Object> readWithArguments(final ProjectV2SelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.closed());
        values.add(selector.closedAt());
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.databaseId());
        values.add(selector.field(
                "x", child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.fields(
                Paging.first(1),
                ProjectV2FieldsFilterBuilder.builder()
                        .orderBy(ProjectV2FieldOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2FieldOrderField.CREATED_AT)
                                .build())
                        .build(),
                child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.items(
                Paging.first(1),
                ProjectV2ItemsFilterBuilder.builder()
                        .archivedStates(List.of(ProjectV2ItemArchivedState.ARCHIVED))
                        .orderBy(ProjectV2ItemOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2ItemOrderField.POSITION)
                                .build())
                        .query("x")
                        .build(),
                ProjectV2ItemSelector::createdAt));
        values.add(selector.number());
        values.add(selector.owner(ProjectV2OwnerSelector::id));
        values.add(selector.publicValue());
        values.add(selector.readme());
        values.add(selector.repositories(
                Paging.first(1),
                ProjectV2RepositoriesFilterBuilder.builder()
                        .orderBy(RepositoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryOrderField.CREATED_AT)
                                .build())
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.shortDescription());
        values.add(selector.statusUpdates(
                Paging.first(1),
                ProjectV2StatusUpdatesFilterBuilder.builder()
                        .orderBy(ProjectV2StatusOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2StatusUpdateOrderField.CREATED_AT)
                                .build())
                        .build(),
                ProjectV2StatusUpdateSelector::body));
        values.add(selector.teams(
                Paging.first(1),
                ProjectV2TeamsFilterBuilder.builder()
                        .orderBy(TeamOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(TeamOrderField.NAME)
                                .build())
                        .build(),
                TeamSelector::avatarUrl));
        values.add(selector.template());
        values.add(selector.title());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.view(1, ProjectV2ViewSelector::createdAt));
        values.add(selector.viewerCanClose());
        values.add(selector.viewerCanReopen());
        values.add(selector.viewerCanUpdate());
        values.add(selector.views(
                Paging.first(1),
                ProjectV2ViewsFilterBuilder.builder()
                        .orderBy(ProjectV2ViewOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2ViewOrderField.CREATED_AT)
                                .build())
                        .build(),
                ProjectV2ViewSelector::createdAt));
        values.add(selector.workflow(1, ProjectV2WorkflowSelector::createdAt));
        values.add(selector.workflows(
                Paging.first(1),
                ProjectV2WorkflowsFilterBuilder.builder()
                        .orderBy(ProjectV2WorkflowOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2WorkflowsOrderField.CREATED_AT)
                                .build())
                        .build(),
                ProjectV2WorkflowSelector::createdAt));
        return values;
    }

    private static List<Object> readWithoutArguments(final ProjectV2SelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.fields(
                Paging.first(1), child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.items(Paging.first(1), ProjectV2ItemSelector::createdAt));
        values.add(selector.repositories(Paging.first(1), RepositorySelector::allowUpdateBranch));
        values.add(selector.statusUpdates(Paging.first(1), ProjectV2StatusUpdateSelector::body));
        values.add(selector.teams(Paging.first(1), TeamSelector::avatarUrl));
        values.add(selector.views(Paging.first(1), ProjectV2ViewSelector::createdAt));
        values.add(selector.workflows(Paging.first(1), ProjectV2WorkflowSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2SelectorImpl(new RecordingCursor(root)));
        final ProjectV2SelectorImpl selector =
                new ProjectV2SelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        BigInteger.ONE,
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        1,
                        "x",
                        true,
                        "x",
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null),
                        true,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        true,
                        true,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ProjectV2SelectorImpl(new RecordingCursor(root)));
        final ProjectV2SelectorImpl selector =
                new ProjectV2SelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
