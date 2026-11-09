package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ActorLocation}. */
public interface ActorLocationSelector {

    @Nullable String city();

    @Nullable String country();

    @Nullable String countryCode();

    @Nullable String region();

    @Nullable String regionCode();
}
