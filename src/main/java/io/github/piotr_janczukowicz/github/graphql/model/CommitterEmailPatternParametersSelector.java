package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CommitterEmailPatternParameters}. */
public interface CommitterEmailPatternParametersSelector {

    @Nullable String name();

    boolean negate();

    String operator();

    String pattern();
}
