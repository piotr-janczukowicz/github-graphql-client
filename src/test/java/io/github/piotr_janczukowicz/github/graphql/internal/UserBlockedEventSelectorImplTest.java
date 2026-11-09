package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserBlockDuration;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UserBlockedEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"blockDuration\":\"ONE_DAY\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\""
            + "," + "\"subject\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final UserBlockedEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.blockDuration());
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.subject(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UserBlockedEventSelectorImpl(new RecordingCursor(root)));
        final UserBlockedEventSelectorImpl selector =
                new UserBlockedEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly("x", UserBlockDuration.ONE_DAY, Instant.parse("2024-05-01T10:15:30Z"), "x", true);
    }
}
