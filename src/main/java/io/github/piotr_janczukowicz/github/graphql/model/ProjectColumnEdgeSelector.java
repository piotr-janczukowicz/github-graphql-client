package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectColumnEdge}. */
public interface ProjectColumnEdgeSelector {

    String cursor();

    <R> @Nullable R node(Function<ProjectColumnSelector, R> selection);
}
