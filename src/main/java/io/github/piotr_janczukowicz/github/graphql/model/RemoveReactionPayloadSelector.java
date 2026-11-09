package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RemoveReactionPayload}. */
public interface RemoveReactionPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R reaction(Function<ReactionSelector, R> selection);

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> @Nullable R subject(Function<ReactableSelector, R> selection);
}
