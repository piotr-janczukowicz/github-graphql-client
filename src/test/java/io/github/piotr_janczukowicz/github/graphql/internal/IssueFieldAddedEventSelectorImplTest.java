package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueEventConfidenceLevel;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldTimelineOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueUpdateIntentSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IssueFieldAddedEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"color\":\"x\"" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + ","
            + "\"intent\":{\"confidence\": \"HIGH\"}" + ","
            + "\"issueField\":{\"__typename\": \"IssueFieldDate\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"options\":[{\"color\": \"x\"}]" + "," + "\"value\":\"x\"" + "}";

    private static List<Object> readWithArguments(final IssueFieldAddedEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.color());
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.intent(IssueUpdateIntentSelector::confidence));
        values.add(selector.issueField(
                child -> child.on(IssueFieldDateSelector.class, IssueFieldDateSelector::createdAt)));
        values.add(selector.options(IssueFieldTimelineOptionSelector::color));
        values.add(selector.value());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueFieldAddedEventSelectorImpl(new RecordingCursor(root)));
        final IssueFieldAddedEventSelectorImpl selector =
                new IssueFieldAddedEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        IssueEventConfidenceLevel.HIGH,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        List.of("x"),
                        "x");
    }
}
