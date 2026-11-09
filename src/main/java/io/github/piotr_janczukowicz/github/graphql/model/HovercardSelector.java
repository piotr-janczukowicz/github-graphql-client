package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code Hovercard}. */
public interface HovercardSelector {

    <R> List<R> contexts(Function<HovercardContextSelector, R> selection);
}
