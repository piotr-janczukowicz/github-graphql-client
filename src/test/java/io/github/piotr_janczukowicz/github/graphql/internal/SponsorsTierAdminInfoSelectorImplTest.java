package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierAdminInfoSponsorshipsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SponsorsTierAdminInfoSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"isDraft\":true" + "," + "\"isPublished\":true" + "," + "\"isRetired\":true" + ","
                    + "\"sponsorships\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "}";

    private static List<Object> readWithArguments(final SponsorsTierAdminInfoSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.isDraft());
        values.add(selector.isPublished());
        values.add(selector.isRetired());
        values.add(selector.sponsorships(
                Paging.first(1),
                SponsorsTierAdminInfoSponsorshipsFilterBuilder.builder()
                        .includePrivate(true)
                        .orderBy(SponsorshipOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipSelector::createdAt));
        return values;
    }

    private static List<Object> readWithoutArguments(final SponsorsTierAdminInfoSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.sponsorships(Paging.first(1), SponsorshipSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorsTierAdminInfoSelectorImpl(new RecordingCursor(root)));
        final SponsorsTierAdminInfoSelectorImpl selector =
                new SponsorsTierAdminInfoSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true, true, true, new Page<>(List.of(Instant.parse("2024-05-01T10:15:30Z")), false, null));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new SponsorsTierAdminInfoSelectorImpl(new RecordingCursor(root)));
        final SponsorsTierAdminInfoSelectorImpl selector =
                new SponsorsTierAdminInfoSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(Instant.parse("2024-05-01T10:15:30Z")), false, null));
    }
}
