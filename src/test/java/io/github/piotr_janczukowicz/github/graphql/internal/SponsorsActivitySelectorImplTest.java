package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityAction;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipPaymentSource;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipPrivacy;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SponsorsActivitySelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"action\":\"CANCELLED_SPONSORSHIP\"" + ","
            + "\"currentPrivacyLevel\":\"PRIVATE\"" + "," + "\"id\":\"x\"" + "," + "\"paymentSource\":\"GITHUB\"" + ","
            + "\"previousSponsorsTier\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"sponsor\":{\"__typename\": \"Organization\", \"anyPinnableItems\": true}" + ","
            + "\"sponsorable\":{\"estimatedNextSponsorsPayoutInCents\": 1}" + ","
            + "\"sponsorsTier\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"timestamp\":\"2024-05-01T10:15:30Z\"" + "," + "\"viaBulkSponsorship\":true" + "}";

    private static List<Object> readWithArguments(final SponsorsActivitySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.action());
        values.add(selector.currentPrivacyLevel());
        values.add(selector.id());
        values.add(selector.paymentSource());
        values.add(selector.previousSponsorsTier(SponsorsTierSelector::createdAt));
        values.add(selector.sponsor(
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsorable(SponsorableSelector::estimatedNextSponsorsPayoutInCents));
        values.add(selector.sponsorsTier(SponsorsTierSelector::createdAt));
        values.add(selector.timestamp());
        values.add(selector.viaBulkSponsorship());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorsActivitySelectorImpl(new RecordingCursor(root)));
        final SponsorsActivitySelectorImpl selector =
                new SponsorsActivitySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        SponsorsActivityAction.CANCELLED_SPONSORSHIP,
                        SponsorshipPrivacy.PRIVATE,
                        "x",
                        SponsorshipPaymentSource.GITHUB,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true);
    }
}
