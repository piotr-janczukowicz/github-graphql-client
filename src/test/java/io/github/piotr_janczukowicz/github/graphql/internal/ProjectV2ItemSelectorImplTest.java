package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DraftIssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldDateValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldValueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldValueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldValuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemType;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ProjectV2ItemSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"content\":{\"__typename\": \"DraftIssue\", \"body\": \"x\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"creator\":{\"avatarUrl\": \"x\"}" + ","
            + "\"databaseId\":1" + ","
            + "\"fieldValueByName\":{\"__typename\": \"ProjectV2ItemFieldDateValue\", \"createdAt\": \"2024-05-01T10:15:30Z\"}"
            + ","
            + "\"fieldValues\":{\"nodes\": [{\"__typename\": \"ProjectV2ItemFieldDateValue\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"fullDatabaseId\":\"1\"" + "," + "\"id\":\"x\"" + "," + "\"isArchived\":true" + ","
            + "\"project\":{\"closed\": true}" + "," + "\"type\":\"DRAFT_ISSUE\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final ProjectV2ItemSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.content(child -> child.on(DraftIssueSelector.class, DraftIssueSelector::body)));
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.databaseId());
        values.add(selector.fieldValueByName(
                "x",
                child -> child.on(
                        ProjectV2ItemFieldDateValueSelector.class, ProjectV2ItemFieldDateValueSelector::createdAt)));
        values.add(selector.fieldValues(
                Paging.first(1),
                ProjectV2ItemFieldValuesFilterBuilder.builder()
                        .orderBy(ProjectV2ItemFieldValueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ProjectV2ItemFieldValueOrderField.POSITION)
                                .build())
                        .build(),
                child -> child.on(
                        ProjectV2ItemFieldDateValueSelector.class, ProjectV2ItemFieldDateValueSelector::createdAt)));
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.isArchived());
        values.add(selector.project(ProjectV2Selector::closed));
        values.add(selector.type());
        values.add(selector.updatedAt());
        return values;
    }

    private static List<Object> readWithoutArguments(final ProjectV2ItemSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.fieldValues(
                Paging.first(1),
                child -> child.on(
                        ProjectV2ItemFieldDateValueSelector.class, ProjectV2ItemFieldDateValueSelector::createdAt)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2ItemSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ItemSelectorImpl selector =
                new ProjectV2ItemSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        BigInteger.ONE,
                        "x",
                        true,
                        true,
                        ProjectV2ItemType.DRAFT_ISSUE,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ProjectV2ItemSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ItemSelectorImpl selector =
                new ProjectV2ItemSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
