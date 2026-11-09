package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SponsorsActivity}. */
public interface SponsorsActivitySelector {

    SponsorsActivityAction action();

    @Nullable SponsorshipPrivacy currentPrivacyLevel();

    String id();

    @Nullable SponsorshipPaymentSource paymentSource();

    <R> @Nullable R previousSponsorsTier(Function<SponsorsTierSelector, R> selection);

    <R> @Nullable R sponsor(Function<SponsorSelector, R> selection);

    <R> R sponsorable(Function<SponsorableSelector, R> selection);

    <R> @Nullable R sponsorsTier(Function<SponsorsTierSelector, R> selection);

    @Nullable Instant timestamp();

    boolean viaBulkSponsorship();
}
