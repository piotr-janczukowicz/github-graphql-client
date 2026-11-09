package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.AssignableSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReplaceActorsForAssignablePayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"assignable\":{\"viewerCanAssign\": true}" + "," + "\"clientMutationId\":\"x\"" + "}";

    private static List<Object> readWithArguments(final ReplaceActorsForAssignablePayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.assignable(AssignableSelector::viewerCanAssign));
        values.add(selector.clientMutationId());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReplaceActorsForAssignablePayloadSelectorImpl(new RecordingCursor(root)));
        final ReplaceActorsForAssignablePayloadSelectorImpl selector =
                new ReplaceActorsForAssignablePayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, "x");
    }
}
