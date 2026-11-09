package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Votable}. */
public interface VotableSelector {

    int upvoteCount();

    boolean viewerCanUpvote();

    boolean viewerHasUpvoted();

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
