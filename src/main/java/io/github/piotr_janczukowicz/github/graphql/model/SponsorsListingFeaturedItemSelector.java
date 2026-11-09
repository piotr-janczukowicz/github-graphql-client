package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SponsorsListingFeaturedItem}. */
public interface SponsorsListingFeaturedItemSelector {

    Instant createdAt();

    @Nullable String description();

    <R> R featureable(Function<SponsorsListingFeatureableItemSelector, R> selection);

    String id();

    int position();

    <R> R sponsorsListing(Function<SponsorsListingSelector, R> selection);

    Instant updatedAt();
}
