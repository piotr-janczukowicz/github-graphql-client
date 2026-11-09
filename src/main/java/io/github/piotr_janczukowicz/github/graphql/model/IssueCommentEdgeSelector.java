package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueCommentEdge}. */
public interface IssueCommentEdgeSelector {

    String cursor();

    <R> @Nullable R node(Function<IssueCommentSelector, R> selection);
}
