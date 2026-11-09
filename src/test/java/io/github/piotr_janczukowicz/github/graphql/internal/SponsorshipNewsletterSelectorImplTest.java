package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SponsorshipNewsletterSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"author\":{\"anyPinnableItems\": true}" + "," + "\"body\":\"x\""
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + "," + "\"isPublished\":true" + ","
            + "\"sponsorable\":{\"estimatedNextSponsorsPayoutInCents\": 1}" + "," + "\"subject\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final SponsorshipNewsletterSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.author(UserSelector::anyPinnableItems));
        values.add(selector.body());
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.isPublished());
        values.add(selector.sponsorable(SponsorableSelector::estimatedNextSponsorsPayoutInCents));
        values.add(selector.subject());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorshipNewsletterSelectorImpl(new RecordingCursor(root)));
        final SponsorshipNewsletterSelectorImpl selector =
                new SponsorshipNewsletterSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        true,
                        1,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
