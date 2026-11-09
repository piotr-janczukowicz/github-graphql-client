package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOwnerProjectsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectOwnerSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + "," + "\"project\":{\"closed\": true}" + ","
            + "\"projects\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"projectsResourcePath\":\"x\"" + "," + "\"projectsUrl\":\"x\"" + ","
            + "\"viewerCanCreateProjects\":true" + "," + "\"anyPinnableItems\":true" + ","
            + "\"__typename\":\"Organization\"" + "}";

    private static List<Object> readWithArguments(final ProjectOwnerSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.project(1, ProjectSelector::closed));
        values.add(selector.projects(
                Paging.first(1),
                ProjectOwnerProjectsFilterBuilder.builder()
                        .orderBy(ProjectOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectOrderField.CREATED_AT)
                                .build())
                        .search("x")
                        .states(List.of(ProjectState.CLOSED))
                        .build(),
                ProjectSelector::closed));
        values.add(selector.projectsResourcePath());
        values.add(selector.projectsUrl());
        values.add(selector.viewerCanCreateProjects());
        values.add(selector.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems));
        return values;
    }

    private static List<Object> readWithoutArguments(final ProjectOwnerSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.projects(Paging.first(1), ProjectSelector::closed));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectOwnerSelectorImpl(new RecordingCursor(root)));
        final ProjectOwnerSelectorImpl selector =
                new ProjectOwnerSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", true, new Page<>(List.of(true), false, null), "x", "x", true, true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ProjectOwnerSelectorImpl(new RecordingCursor(root)));
        final ProjectOwnerSelectorImpl selector =
                new ProjectOwnerSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(true), false, null));
    }
}
