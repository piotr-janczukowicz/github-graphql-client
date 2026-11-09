package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelableLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class LabelableSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"labels\":{\"nodes\": [{\"color\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanLabel\":true" + "," + "\"activeLockReason\":\"OFF_TOPIC\"" + ","
            + "\"__typename\":\"Discussion\"" + "}";

    private static List<Object> readWithArguments(final LabelableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.labels(
                Paging.first(1),
                LabelableLabelsFilterBuilder.builder()
                        .orderBy(LabelOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(LabelOrderField.CREATED_AT)
                                .build())
                        .build(),
                LabelSelector::color));
        values.add(selector.viewerCanLabel());
        values.add(selector.on(DiscussionSelector.class, DiscussionSelector::activeLockReason));
        return values;
    }

    private static List<Object> readWithoutArguments(final LabelableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.labels(Paging.first(1), LabelSelector::color));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new LabelableSelectorImpl(new RecordingCursor(root)));
        final LabelableSelectorImpl selector =
                new LabelableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null), true, LockReason.OFF_TOPIC);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new LabelableSelectorImpl(new RecordingCursor(root)));
        final LabelableSelectorImpl selector =
                new LabelableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
