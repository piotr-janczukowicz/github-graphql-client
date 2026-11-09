package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OwnerProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2PermissionLevel;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2OwnerSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + "," + "\"projectV2\":{\"closed\": true}" + ","
            + "\"projectsV2\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"activeLockReason\":\"OFF_TOPIC\"" + "," + "\"__typename\":\"Issue\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2OwnerSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.projectV2(1, ProjectV2Selector::closed));
        values.add(selector.projectsV2(
                Paging.first(1),
                ProjectV2OwnerProjectsV2FilterBuilder.builder()
                        .minPermissionLevel(ProjectV2PermissionLevel.ADMIN)
                        .orderBy(ProjectV2OrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2OrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .build(),
                ProjectV2Selector::closed));
        values.add(selector.on(IssueSelector.class, IssueSelector::activeLockReason));
        return values;
    }

    private static List<Object> readWithoutArguments(final ProjectV2OwnerSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.projectsV2(Paging.first(1), ProjectV2Selector::closed));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2OwnerSelectorImpl(new RecordingCursor(root)));
        final ProjectV2OwnerSelectorImpl selector =
                new ProjectV2OwnerSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", true, new Page<>(List.of(true), false, null), LockReason.OFF_TOPIC);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ProjectV2OwnerSelectorImpl(new RecordingCursor(root)));
        final ProjectV2OwnerSelectorImpl selector =
                new ProjectV2OwnerSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(true), false, null));
    }
}
