package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SponsorsListing}. */
public interface SponsorsListingSelector {

    <R> @Nullable R activeGoal(Function<SponsorsGoalSelector, R> selection);

    <R> @Nullable R activeStripeConnectAccount(Function<StripeConnectAccountSelector, R> selection);

    @Nullable String billingCountryOrRegion();

    @Nullable String contactEmailAddress();

    Instant createdAt();

    String dashboardResourcePath();

    String dashboardUrl();

    <R> List<R> featuredItems(
            SponsorsListingFeaturedItemsFilter arguments, Function<SponsorsListingFeaturedItemSelector, R> selection);

    <R> List<R> featuredItems(Function<SponsorsListingFeaturedItemSelector, R> selection);

    <R> @Nullable R fiscalHost(Function<OrganizationSelector, R> selection);

    String fullDescription();

    String fullDescriptionHTML();

    String id();

    boolean isPublic();

    String name();

    @Nullable LocalDate nextPayoutDate();

    @Nullable String residenceCountryOrRegion();

    String resourcePath();

    String shortDescription();

    String slug();

    <R> R sponsorable(Function<SponsorableSelector, R> selection);

    <R> Page<R> tiers(Paging paging, SponsorsListingTiersFilter arguments, Function<SponsorsTierSelector, R> selection);

    <R> Page<R> tiers(Paging paging, Function<SponsorsTierSelector, R> selection);

    String url();
}
