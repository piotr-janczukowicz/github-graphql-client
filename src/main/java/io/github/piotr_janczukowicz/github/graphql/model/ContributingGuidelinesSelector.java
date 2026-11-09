package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ContributingGuidelines}. */
public interface ContributingGuidelinesSelector {

    @Nullable String body();

    @Nullable String resourcePath();

    @Nullable String url();
}
