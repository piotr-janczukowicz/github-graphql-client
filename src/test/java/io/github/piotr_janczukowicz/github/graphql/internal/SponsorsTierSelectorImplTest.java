package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierAdminInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SponsorsTierSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"adminInfo\":{\"isDraft\": true}" + ","
            + "\"closestLesserValueTier\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"description\":\"x\"" + ","
            + "\"descriptionHTML\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"isCustomAmount\":true" + ","
            + "\"isOneTime\":true" + "," + "\"monthlyPriceInCents\":1" + "," + "\"monthlyPriceInDollars\":1" + ","
            + "\"name\":\"x\"" + "," + "\"sponsorsListing\":{\"billingCountryOrRegion\": \"x\"}" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final SponsorsTierSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.adminInfo(SponsorsTierAdminInfoSelector::isDraft));
        values.add(selector.closestLesserValueTier(SponsorsTierSelector::createdAt));
        values.add(selector.createdAt());
        values.add(selector.description());
        values.add(selector.descriptionHTML());
        values.add(selector.id());
        values.add(selector.isCustomAmount());
        values.add(selector.isOneTime());
        values.add(selector.monthlyPriceInCents());
        values.add(selector.monthlyPriceInDollars());
        values.add(selector.name());
        values.add(selector.sponsorsListing(SponsorsListingSelector::billingCountryOrRegion));
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorsTierSelectorImpl(new RecordingCursor(root)));
        final SponsorsTierSelectorImpl selector =
                new SponsorsTierSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        "x",
                        true,
                        true,
                        1,
                        1,
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
