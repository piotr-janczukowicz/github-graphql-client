package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ReactableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class AddReactionPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"reaction\":{\"content\": \"CONFUSED\"}" + "," + "\"reactionGroups\":[{\"content\": \"CONFUSED\"}]"
            + "," + "\"subject\":{\"databaseId\": 1}" + "}";

    private static List<Object> readWithArguments(final AddReactionPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.reaction(ReactionSelector::content));
        values.add(selector.reactionGroups(ReactionGroupSelector::content));
        values.add(selector.subject(ReactableSelector::databaseId));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new AddReactionPayloadSelectorImpl(new RecordingCursor(root)));
        final AddReactionPayloadSelectorImpl selector =
                new AddReactionPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", ReactionContent.CONFUSED, List.of(ReactionContent.CONFUSED), 1);
    }
}
