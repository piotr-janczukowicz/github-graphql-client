package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Sponsorship}. */
public interface SponsorshipSelector {

    Instant createdAt();

    String id();

    boolean isActive();

    boolean isOneTimePayment();

    @Nullable Boolean isSponsorOptedIntoEmail();

    /**
     * @deprecated `Sponsorship.maintainer` will be removed. Use `Sponsorship.sponsorable` instead. Removal on
     *     2020-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> R maintainer(Function<UserSelector, R> selection);

    @Nullable SponsorshipPaymentSource paymentSource();

    SponsorshipPrivacy privacyLevel();

    /**
     * @deprecated `Sponsorship.sponsor` will be removed. Use `Sponsorship.sponsorEntity` instead. Removal on 2020-10-01
     *     UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R sponsor(Function<UserSelector, R> selection);

    <R> @Nullable R sponsorEntity(Function<SponsorSelector, R> selection);

    <R> R sponsorable(Function<SponsorableSelector, R> selection);

    <R> @Nullable R tier(Function<SponsorsTierSelector, R> selection);

    @Nullable Instant tierSelectedAt();
}
