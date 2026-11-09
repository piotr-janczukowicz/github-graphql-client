package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SubscribableSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"id\":\"x\"" + "," + "\"viewerCanSubscribe\":true" + "," + "\"viewerSubscription\":\"IGNORED\""
                    + "," + "\"abbreviatedOid\":\"x\"" + "," + "\"__typename\":\"Commit\"" + "}";

    private static List<Object> readWithArguments(final SubscribableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.viewerCanSubscribe());
        values.add(selector.viewerSubscription());
        values.add(selector.on(CommitSelector.class, CommitSelector::abbreviatedOid));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SubscribableSelectorImpl(new RecordingCursor(root)));
        final SubscribableSelectorImpl selector =
                new SubscribableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", true, SubscriptionState.IGNORED, "x");
    }
}
