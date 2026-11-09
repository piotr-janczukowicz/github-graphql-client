package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code EPSS}. */
public interface EPSSSelector {

    @Nullable Double percentage();

    @Nullable Double percentile();
}
