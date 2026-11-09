package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsGoalSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeaturedItemFeatureableType;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeaturedItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeaturedItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingTiersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StripeConnectAccountSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SponsorsListingSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"activeGoal\":{\"description\": \"x\"}" + ","
            + "\"activeStripeConnectAccount\":{\"accountId\": \"x\"}" + "," + "\"billingCountryOrRegion\":\"x\"" + ","
            + "\"contactEmailAddress\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"dashboardResourcePath\":\"x\"" + "," + "\"dashboardUrl\":\"x\"" + ","
            + "\"featuredItems\":[{\"createdAt\": \"2024-05-01T10:15:30Z\"}]" + ","
            + "\"fiscalHost\":{\"anyPinnableItems\": true}" + "," + "\"fullDescription\":\"x\"" + ","
            + "\"fullDescriptionHTML\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"isPublic\":true" + ","
            + "\"name\":\"x\"" + "," + "\"nextPayoutDate\":\"2024-05-01\"" + "," + "\"residenceCountryOrRegion\":\"x\""
            + "," + "\"resourcePath\":\"x\"" + "," + "\"shortDescription\":\"x\"" + "," + "\"slug\":\"x\"" + ","
            + "\"sponsorable\":{\"estimatedNextSponsorsPayoutInCents\": 1}" + ","
            + "\"tiers\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final SponsorsListingSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.activeGoal(SponsorsGoalSelector::description));
        values.add(selector.activeStripeConnectAccount(StripeConnectAccountSelector::accountId));
        values.add(selector.billingCountryOrRegion());
        values.add(selector.contactEmailAddress());
        values.add(selector.createdAt());
        values.add(selector.dashboardResourcePath());
        values.add(selector.dashboardUrl());
        values.add(selector.featuredItems(
                SponsorsListingFeaturedItemsFilterBuilder.builder()
                        .featureableTypes(List.of(SponsorsListingFeaturedItemFeatureableType.REPOSITORY))
                        .build(),
                SponsorsListingFeaturedItemSelector::createdAt));
        values.add(selector.fiscalHost(OrganizationSelector::anyPinnableItems));
        values.add(selector.fullDescription());
        values.add(selector.fullDescriptionHTML());
        values.add(selector.id());
        values.add(selector.isPublic());
        values.add(selector.name());
        values.add(selector.nextPayoutDate());
        values.add(selector.residenceCountryOrRegion());
        values.add(selector.resourcePath());
        values.add(selector.shortDescription());
        values.add(selector.slug());
        values.add(selector.sponsorable(SponsorableSelector::estimatedNextSponsorsPayoutInCents));
        values.add(selector.tiers(
                Paging.first(1),
                SponsorsListingTiersFilterBuilder.builder()
                        .includeUnpublished(true)
                        .orderBy(SponsorsTierOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorsTierOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorsTierSelector::createdAt));
        values.add(selector.url());
        return values;
    }

    private static List<Object> readWithoutArguments(final SponsorsListingSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.featuredItems(SponsorsListingFeaturedItemSelector::createdAt));
        values.add(selector.tiers(Paging.first(1), SponsorsTierSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorsListingSelectorImpl(new RecordingCursor(root)));
        final SponsorsListingSelectorImpl selector =
                new SponsorsListingSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)),
                        true,
                        "x",
                        "x",
                        "x",
                        true,
                        "x",
                        LocalDate.of(2024, 5, 1),
                        "x",
                        "x",
                        "x",
                        "x",
                        1,
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new SponsorsListingSelectorImpl(new RecordingCursor(root)));
        final SponsorsListingSelectorImpl selector =
                new SponsorsListingSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
