package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ExternalIdentityAttribute}. */
public interface ExternalIdentityAttributeSelector {

    @Nullable String metadata();

    String name();

    String value();
}
