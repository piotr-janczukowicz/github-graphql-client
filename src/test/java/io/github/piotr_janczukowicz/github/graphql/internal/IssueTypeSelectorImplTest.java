package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFiltersBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeColor;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class IssueTypeSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"color\":\"BLUE\"" + "," + "\"description\":\"x\"" + ","
            + "\"id\":\"x\"" + "," + "\"isEnabled\":true" + "," + "\"isPrivate\":true" + ","
            + "\"issues\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"name\":\"x\"" + ","
            + "\"pinnedFields\":[{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}]" + "}";

    private static List<Object> readWithArguments(final IssueTypeSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.color());
        values.add(selector.description());
        values.add(selector.id());
        values.add(selector.isEnabled());
        values.add(selector.isPrivate());
        values.add(selector.issues(
                "x",
                Paging.first(1),
                IssueTypeIssuesFilterBuilder.builder()
                        .filterBy(IssueFiltersBuilder.builder().build())
                        .labels(List.of("x"))
                        .orderBy(IssueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IssueOrderField.COMMENTS)
                                .build())
                        .states(List.of(IssueState.CLOSED))
                        .build(),
                IssueSelector::activeLockReason));
        values.add(selector.name());
        values.add(selector.pinnedFields(
                child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        return values;
    }

    private static List<Object> readWithoutArguments(final IssueTypeSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.issues("x", Paging.first(1), IssueSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueTypeSelectorImpl(new RecordingCursor(root)));
        final IssueTypeSelectorImpl selector =
                new IssueTypeSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        IssueTypeColor.BLUE,
                        "x",
                        "x",
                        true,
                        true,
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        "x",
                        List.of(Instant.parse("2024-05-01T10:15:30Z")));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new IssueTypeSelectorImpl(new RecordingCursor(root)));
        final IssueTypeSelectorImpl selector =
                new IssueTypeSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(LockReason.OFF_TOPIC), false, null));
    }
}
