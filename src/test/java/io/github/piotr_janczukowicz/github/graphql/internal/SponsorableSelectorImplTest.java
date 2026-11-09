package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableLifetimeReceivedSponsorshipValuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsoringFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorsActivitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipForViewerAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipForViewerAsSponsorableFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipNewslettersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipsAsMaintainerFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipsAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableTotalSponsorshipAmountAsSponsorInCentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityAction;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivityPeriod;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterSelector;
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
class SponsorableSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"estimatedNextSponsorsPayoutInCents\":1" + ","
            + "\"hasSponsorsListing\":true" + "," + "\"isSponsoredBy\":true" + "," + "\"isSponsoringViewer\":true" + ","
            + "\"lifetimeReceivedSponsorshipValues\":{\"nodes\": [{\"amountInCents\": 1}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"monthlyEstimatedSponsorsIncomeInCents\":1" + ","
            + "\"sponsoring\":{\"nodes\": [{\"__typename\": \"Organization\", \"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsors\":{\"nodes\": [{\"__typename\": \"Organization\", \"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorsActivities\":{\"nodes\": [{\"action\": \"CANCELLED_SPONSORSHIP\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"sponsorsListing\":{\"billingCountryOrRegion\": \"x\"}" + ","
            + "\"sponsorshipForViewerAsSponsor\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"sponsorshipForViewerAsSponsorable\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"sponsorshipNewsletters\":{\"nodes\": [{\"body\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorshipsAsMaintainer\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"sponsorshipsAsSponsor\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"totalSponsorshipAmountAsSponsorInCents\":1" + "," + "\"viewerCanSponsor\":true" + ","
            + "\"viewerIsSponsoring\":true" + "," + "\"anyPinnableItems\":true" + ","
            + "\"__typename\":\"Organization\"" + "}";

    private static List<Object> readWithArguments(final SponsorableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.estimatedNextSponsorsPayoutInCents());
        values.add(selector.hasSponsorsListing());
        values.add(selector.isSponsoredBy("x"));
        values.add(selector.isSponsoringViewer());
        values.add(selector.lifetimeReceivedSponsorshipValues(
                Paging.first(1),
                SponsorableLifetimeReceivedSponsorshipValuesFilterBuilder.builder()
                        .orderBy(SponsorAndLifetimeValueOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorAndLifetimeValueOrderField.LIFETIME_VALUE)
                                .build())
                        .build(),
                SponsorAndLifetimeValueSelector::amountInCents));
        values.add(selector.monthlyEstimatedSponsorsIncomeInCents());
        values.add(selector.sponsoring(
                Paging.first(1),
                SponsorableSponsoringFilterBuilder.builder()
                        .orderBy(SponsorOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorOrderField.LOGIN)
                                .build())
                        .build(),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsors(
                Paging.first(1),
                SponsorableSponsorsFilterBuilder.builder()
                        .orderBy(SponsorOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorOrderField.LOGIN)
                                .build())
                        .tierId("x")
                        .build(),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsorsActivities(
                Paging.first(1),
                SponsorableSponsorsActivitiesFilterBuilder.builder()
                        .actions(List.of(SponsorsActivityAction.CANCELLED_SPONSORSHIP))
                        .includeAsSponsor(true)
                        .includePrivate(true)
                        .orderBy(SponsorsActivityOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorsActivityOrderField.TIMESTAMP)
                                .build())
                        .period(SponsorsActivityPeriod.ALL)
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .until(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build(),
                SponsorsActivitySelector::action));
        values.add(selector.sponsorsListing(SponsorsListingSelector::billingCountryOrRegion));
        values.add(selector.sponsorshipForViewerAsSponsor(
                SponsorableSponsorshipForViewerAsSponsorFilterBuilder.builder()
                        .activeOnly(true)
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipForViewerAsSponsorable(
                SponsorableSponsorshipForViewerAsSponsorableFilterBuilder.builder()
                        .activeOnly(true)
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipNewsletters(
                Paging.first(1),
                SponsorableSponsorshipNewslettersFilterBuilder.builder()
                        .orderBy(SponsorshipNewsletterOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipNewsletterOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipNewsletterSelector::body));
        values.add(selector.sponsorshipsAsMaintainer(
                Paging.first(1),
                SponsorableSponsorshipsAsMaintainerFilterBuilder.builder()
                        .activeOnly(true)
                        .includePrivate(true)
                        .orderBy(SponsorshipOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipsAsSponsor(
                Paging.first(1),
                SponsorableSponsorshipsAsSponsorFilterBuilder.builder()
                        .activeOnly(true)
                        .maintainerLogins(List.of("x"))
                        .orderBy(SponsorshipOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SponsorshipOrderField.CREATED_AT)
                                .build())
                        .build(),
                SponsorshipSelector::createdAt));
        values.add(selector.totalSponsorshipAmountAsSponsorInCents(
                SponsorableTotalSponsorshipAmountAsSponsorInCentsFilterBuilder.builder()
                        .since(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .sponsorableLogins(List.of("x"))
                        .until(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build()));
        values.add(selector.viewerCanSponsor());
        values.add(selector.viewerIsSponsoring());
        values.add(selector.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems));
        return values;
    }

    private static List<Object> readWithoutArguments(final SponsorableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.lifetimeReceivedSponsorshipValues(
                Paging.first(1), SponsorAndLifetimeValueSelector::amountInCents));
        values.add(selector.sponsoring(
                Paging.first(1),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsors(
                Paging.first(1),
                child -> child.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems)));
        values.add(selector.sponsorsActivities(Paging.first(1), SponsorsActivitySelector::action));
        values.add(selector.sponsorshipForViewerAsSponsor(SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipForViewerAsSponsorable(SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipNewsletters(Paging.first(1), SponsorshipNewsletterSelector::body));
        values.add(selector.sponsorshipsAsMaintainer(Paging.first(1), SponsorshipSelector::createdAt));
        values.add(selector.sponsorshipsAsSponsor(Paging.first(1), SponsorshipSelector::createdAt));
        values.add(selector.totalSponsorshipAmountAsSponsorInCents());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorableSelectorImpl(new RecordingCursor(root)));
        final SponsorableSelectorImpl selector =
                new SponsorableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        1,
                        true,
                        true,
                        true,
                        new Page<>(List.of(1), false, null),
                        1,
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(SponsorsActivityAction.CANCELLED_SPONSORSHIP), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        1,
                        true,
                        true,
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new SponsorableSelectorImpl(new RecordingCursor(root)));
        final SponsorableSelectorImpl selector =
                new SponsorableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(1), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of(SponsorsActivityAction.CANCELLED_SPONSORSHIP), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        1);
    }
}
