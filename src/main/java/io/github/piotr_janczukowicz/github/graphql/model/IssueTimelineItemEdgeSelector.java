package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueTimelineItemEdge}. */
public interface IssueTimelineItemEdgeSelector {

    String cursor();

    <R> @Nullable R node(Function<IssueTimelineItemSelector, R> selection);
}
