package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssignableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class UnassignedEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + "," + "\"assignable\":{\"viewerCanAssign\": true}" + ","
                    + "\"assignee\":{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}" + ","
                    + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + ","
                    + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final UnassignedEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.assignable(AssignableSelector::viewerCanAssign));
        values.add(selector.assignee(child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UnassignedEventSelectorImpl(new RecordingCursor(root)));
        final UnassignedEventSelectorImpl selector =
                new UnassignedEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", true, "x", Instant.parse("2024-05-01T10:15:30Z"), "x", true);
    }
}
