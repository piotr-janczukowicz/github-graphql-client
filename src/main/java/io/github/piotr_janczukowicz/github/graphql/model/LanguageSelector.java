package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Language}. */
public interface LanguageSelector {

    @Nullable String color();

    String id();

    String name();
}
