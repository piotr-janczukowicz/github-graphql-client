package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code ViewerHovercardContext}. */
public interface ViewerHovercardContextSelector {

    String message();

    String octicon();

    <R> R viewer(Function<UserSelector, R> selection);
}
