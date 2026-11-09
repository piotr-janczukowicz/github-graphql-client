package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipPaymentSource;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class SponsorshipSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + ","
            + "\"isActive\":true" + "," + "\"isOneTimePayment\":true" + "," + "\"isSponsorOptedIntoEmail\":true" + ","
            + "\"maintainer\":{\"anyPinnableItems\": true}" + "," + "\"paymentSource\":\"GITHUB\"" + ","
            + "\"privacyLevel\":\"PRIVATE\"" + "," + "\"sponsor\":{\"anyPinnableItems\": true}" + ","
            + "\"sponsorEntity\":{\"__typename\": \"Organization\", \"anyPinnableItems\": true}" + ","
            + "\"sponsorable\":{\"estimatedNextSponsorsPayoutInCents\": 1}" + ","
            + "\"tier\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"tierSelectedAt\":\"2024-05-01T10:15:30Z\""
            + "}";

    private static List<Object> readWithArguments(final SponsorshipSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.isActive());
        values.add(selector.isOneTimePayment());
        values.add(selector.isSponsorOptedIntoEmail());
        values.add(selector.maintainer(UserSelector::anyPinnableItems));
        values.add(selector.paymentSource());
        values.add(selector.privacyLevel());
        values.add(selector.sponsor(UserSelector::anyPinnableItems));
        values.add(selector.sponsorEntity(
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsorable(SponsorableSelector::estimatedNextSponsorsPayoutInCents));
        values.add(selector.tier(SponsorsTierSelector::createdAt));
        values.add(selector.tierSelectedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorshipSelectorImpl(new RecordingCursor(root)));
        final SponsorshipSelectorImpl selector =
                new SponsorshipSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        true,
                        true,
                        true,
                        SponsorshipPaymentSource.GITHUB,
                        SponsorshipPrivacy.PRIVATE,
                        true,
                        true,
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
