package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CommitAuthorEmailPatternParameters}. */
public interface CommitAuthorEmailPatternParametersSelector {

    @Nullable String name();

    boolean negate();

    String operator();

    String pattern();
}
