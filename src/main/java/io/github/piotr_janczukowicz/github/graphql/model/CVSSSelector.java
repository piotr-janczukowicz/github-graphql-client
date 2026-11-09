package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CVSS}. */
public interface CVSSSelector {

    double score();

    @Nullable String vectorString();
}
