package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTemplateLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeColor;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IssueTemplateSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"about\":\"x\"" + ","
            + "\"assignees\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"body\":\"x\"" + "," + "\"filename\":\"x\"" + ","
            + "\"labels\":{\"nodes\": [{\"color\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"name\":\"x\"" + "," + "\"title\":\"x\"" + "," + "\"type\":{\"color\": \"BLUE\"}" + "}";

    private static List<Object> readWithArguments(final IssueTemplateSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.about());
        values.add(selector.assignees(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.body());
        values.add(selector.filename());
        values.add(selector.labels(
                Paging.first(1),
                IssueTemplateLabelsFilterBuilder.builder()
                        .orderBy(LabelOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(LabelOrderField.CREATED_AT)
                                .build())
                        .build(),
                LabelSelector::color));
        values.add(selector.name());
        values.add(selector.title());
        values.add(selector.type(IssueTypeSelector::color));
        return values;
    }

    private static List<Object> readWithoutArguments(final IssueTemplateSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.labels(Paging.first(1), LabelSelector::color));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueTemplateSelectorImpl(new RecordingCursor(root)));
        final IssueTemplateSelectorImpl selector =
                new IssueTemplateSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        IssueTypeColor.BLUE);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new IssueTemplateSelectorImpl(new RecordingCursor(root)));
        final IssueTemplateSelectorImpl selector =
                new IssueTemplateSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
