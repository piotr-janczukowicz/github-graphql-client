package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UserEmailMetadata}. */
public interface UserEmailMetadataSelector {

    @Nullable Boolean primary();

    @Nullable String type();

    String value();
}
