package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SponsorableItemSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"anyPinnableItems\":true" + "," + "\"__typename\":\"Organization\"" + "}";

    private static List<Object> readWithArguments(final SponsorableItemSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorableItemSelectorImpl(new RecordingCursor(root)));
        final SponsorableItemSelectorImpl selector =
                new SponsorableItemSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true);
    }
}
