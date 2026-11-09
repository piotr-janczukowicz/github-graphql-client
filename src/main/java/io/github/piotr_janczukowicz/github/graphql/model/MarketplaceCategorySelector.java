package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MarketplaceCategory}. */
public interface MarketplaceCategorySelector {

    @Nullable String description();

    @Nullable String howItWorks();

    String id();

    String name();

    int primaryListingCount();

    String resourcePath();

    int secondaryListingCount();

    String slug();

    String url();
}
