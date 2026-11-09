package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code CheckAnnotationSpan}. */
public interface CheckAnnotationSpanSelector {

    <R> R end(Function<CheckAnnotationPositionSelector, R> selection);

    <R> R start(Function<CheckAnnotationPositionSelector, R> selection);
}
