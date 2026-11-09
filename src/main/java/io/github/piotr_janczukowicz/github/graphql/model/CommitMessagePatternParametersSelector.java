package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CommitMessagePatternParameters}. */
public interface CommitMessagePatternParametersSelector {

    @Nullable String name();

    boolean negate();

    String operator();

    String pattern();
}
