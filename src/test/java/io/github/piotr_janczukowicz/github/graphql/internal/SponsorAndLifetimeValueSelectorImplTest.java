package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SponsorAndLifetimeValueSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"amountInCents\":1" + "," + "\"formattedAmount\":\"x\"" + ","
            + "\"sponsor\":{\"estimatedNextSponsorsPayoutInCents\": 1}" + ","
            + "\"sponsorable\":{\"estimatedNextSponsorsPayoutInCents\": 1}" + "}";

    private static List<Object> readWithArguments(final SponsorAndLifetimeValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.amountInCents());
        values.add(selector.formattedAmount());
        values.add(selector.sponsor(SponsorableSelector::estimatedNextSponsorsPayoutInCents));
        values.add(selector.sponsorable(SponsorableSelector::estimatedNextSponsorsPayoutInCents));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorAndLifetimeValueSelectorImpl(new RecordingCursor(root)));
        final SponsorAndLifetimeValueSelectorImpl selector =
                new SponsorAndLifetimeValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, "x", 1, 1);
    }
}
