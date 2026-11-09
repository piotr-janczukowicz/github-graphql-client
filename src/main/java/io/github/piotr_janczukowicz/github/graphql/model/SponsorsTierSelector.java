package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SponsorsTier}. */
public interface SponsorsTierSelector {

    <R> @Nullable R adminInfo(Function<SponsorsTierAdminInfoSelector, R> selection);

    <R> @Nullable R closestLesserValueTier(Function<SponsorsTierSelector, R> selection);

    Instant createdAt();

    String description();

    String descriptionHTML();

    String id();

    boolean isCustomAmount();

    boolean isOneTime();

    int monthlyPriceInCents();

    int monthlyPriceInDollars();

    String name();

    <R> R sponsorsListing(Function<SponsorsListingSelector, R> selection);

    Instant updatedAt();
}
