package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueEventConfidenceLevel;
import io.github.piotr_janczukowicz.github.graphql.model.IssueUpdateIntentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelableSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class LabeledEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
                    + "\"id\":\"x\"" + "," + "\"intent\":{\"confidence\": \"HIGH\"}" + ","
                    + "\"label\":{\"color\": \"x\"}" + "," + "\"labelable\":{\"viewerCanLabel\": true}" + "}";

    private static List<Object> readWithArguments(final LabeledEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.intent(IssueUpdateIntentSelector::confidence));
        values.add(selector.label(LabelSelector::color));
        values.add(selector.labelable(LabelableSelector::viewerCanLabel));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new LabeledEventSelectorImpl(new RecordingCursor(root)));
        final LabeledEventSelectorImpl selector =
                new LabeledEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x", Instant.parse("2024-05-01T10:15:30Z"), "x", IssueEventConfidenceLevel.HIGH, "x", true);
    }
}
