package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddCommentPayload}. */
public interface AddCommentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R commentEdge(Function<IssueCommentEdgeSelector, R> selection);

    <R> @Nullable R subject(Function<NodeSelector, R> selection);

    <R> @Nullable R timelineEdge(Function<IssueTimelineItemEdgeSelector, R> selection);
}
