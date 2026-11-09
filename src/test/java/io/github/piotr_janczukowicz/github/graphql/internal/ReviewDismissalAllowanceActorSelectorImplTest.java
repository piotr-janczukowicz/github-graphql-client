package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReviewDismissalAllowanceActorSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientId\":\"x\"" + "," + "\"__typename\":\"App\"" + "}";

    private static List<Object> readWithArguments(final ReviewDismissalAllowanceActorSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(AppSelector.class, AppSelector::clientId));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReviewDismissalAllowanceActorSelectorImpl(new RecordingCursor(root)));
        final ReviewDismissalAllowanceActorSelectorImpl selector =
                new ReviewDismissalAllowanceActorSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
