package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CodeOfConduct}. */
public interface CodeOfConductSelector {

    @Nullable String body();

    String id();

    String key();

    String name();

    @Nullable String resourcePath();

    @Nullable String url();
}
