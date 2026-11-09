package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RenamedTitleEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
                    + "\"currentTitle\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"previousTitle\":\"x\"" + ","
                    + "\"subject\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + "}";

    private static List<Object> readWithArguments(final RenamedTitleEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.createdAt());
        values.add(selector.currentTitle());
        values.add(selector.id());
        values.add(selector.previousTitle());
        values.add(selector.subject(child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RenamedTitleEventSelectorImpl(new RecordingCursor(root)));
        final RenamedTitleEventSelectorImpl selector =
                new RenamedTitleEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"), "x", "x", "x", LockReason.OFF_TOPIC);
    }
}
