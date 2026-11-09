package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PushSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + "," + "\"nextSha\":\"x\"" + ","
            + "\"permalink\":\"x\"" + "," + "\"previousSha\":\"x\"" + "," + "\"pusher\":{\"avatarUrl\": \"x\"}" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "}";

    private static List<Object> readWithArguments(final PushSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.nextSha());
        values.add(selector.permalink());
        values.add(selector.previousSha());
        values.add(selector.pusher(ActorSelector::avatarUrl));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PushSelectorImpl(new RecordingCursor(root)));
        final PushSelectorImpl selector = new PushSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", "x", "x", true);
    }
}
