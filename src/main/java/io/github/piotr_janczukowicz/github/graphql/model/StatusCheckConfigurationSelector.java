package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code StatusCheckConfiguration}. */
public interface StatusCheckConfigurationSelector {

    String context();

    @Nullable Integer integrationId();
}
