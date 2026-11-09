package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code SuggestedReviewerActor}. */
public interface SuggestedReviewerActorSelector {

    boolean isAuthor();

    boolean isCommenter();

    <R> R reviewer(Function<ActorSelector, R> selection);
}
