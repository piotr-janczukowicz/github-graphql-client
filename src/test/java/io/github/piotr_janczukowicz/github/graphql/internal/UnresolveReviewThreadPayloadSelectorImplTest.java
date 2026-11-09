package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.DiffSide;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewThreadSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UnresolveReviewThreadPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"clientMutationId\":\"x\"" + "," + "\"thread\":{\"diffSide\": \"LEFT\"}" + "}";

    private static List<Object> readWithArguments(final UnresolveReviewThreadPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.thread(PullRequestReviewThreadSelector::diffSide));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UnresolveReviewThreadPayloadSelectorImpl(new RecordingCursor(root)));
        final UnresolveReviewThreadPayloadSelectorImpl selector =
                new UnresolveReviewThreadPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", DiffSide.LEFT);
    }
}
