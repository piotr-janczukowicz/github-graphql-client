package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectCardEdge}. */
public interface ProjectCardEdgeSelector {

    String cursor();

    <R> @Nullable R node(Function<ProjectCardSelector, R> selection);
}
