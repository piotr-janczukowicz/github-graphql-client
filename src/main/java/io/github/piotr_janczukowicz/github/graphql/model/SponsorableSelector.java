package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Sponsorable}. */
public interface SponsorableSelector {

    int estimatedNextSponsorsPayoutInCents();

    boolean hasSponsorsListing();

    boolean isSponsoredBy(String accountLogin);

    boolean isSponsoringViewer();

    <R> Page<R> lifetimeReceivedSponsorshipValues(
            Paging paging,
            SponsorableLifetimeReceivedSponsorshipValuesFilter arguments,
            Function<SponsorAndLifetimeValueSelector, R> selection);

    <R> Page<R> lifetimeReceivedSponsorshipValues(
            Paging paging, Function<SponsorAndLifetimeValueSelector, R> selection);

    int monthlyEstimatedSponsorsIncomeInCents();

    <R> Page<R> sponsoring(
            Paging paging, SponsorableSponsoringFilter arguments, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsoring(Paging paging, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsors(Paging paging, SponsorableSponsorsFilter arguments, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsors(Paging paging, Function<SponsorSelector, R> selection);

    <R> Page<R> sponsorsActivities(
            Paging paging,
            SponsorableSponsorsActivitiesFilter arguments,
            Function<SponsorsActivitySelector, R> selection);

    <R> Page<R> sponsorsActivities(Paging paging, Function<SponsorsActivitySelector, R> selection);

    <R> @Nullable R sponsorsListing(Function<SponsorsListingSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsor(
            SponsorableSponsorshipForViewerAsSponsorFilter arguments, Function<SponsorshipSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsor(Function<SponsorshipSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsorable(
            SponsorableSponsorshipForViewerAsSponsorableFilter arguments, Function<SponsorshipSelector, R> selection);

    <R> @Nullable R sponsorshipForViewerAsSponsorable(Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipNewsletters(
            Paging paging,
            SponsorableSponsorshipNewslettersFilter arguments,
            Function<SponsorshipNewsletterSelector, R> selection);

    <R> Page<R> sponsorshipNewsletters(Paging paging, Function<SponsorshipNewsletterSelector, R> selection);

    <R> Page<R> sponsorshipsAsMaintainer(
            Paging paging,
            SponsorableSponsorshipsAsMaintainerFilter arguments,
            Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipsAsMaintainer(Paging paging, Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipsAsSponsor(
            Paging paging,
            SponsorableSponsorshipsAsSponsorFilter arguments,
            Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorshipsAsSponsor(Paging paging, Function<SponsorshipSelector, R> selection);

    @Nullable Integer totalSponsorshipAmountAsSponsorInCents(SponsorableTotalSponsorshipAmountAsSponsorInCentsFilter arguments);

    @Nullable Integer totalSponsorshipAmountAsSponsorInCents();

    boolean viewerCanSponsor();

    boolean viewerIsSponsoring();

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
