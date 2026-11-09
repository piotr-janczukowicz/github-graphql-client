package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code SuggestedReviewer}. */
public interface SuggestedReviewerSelector {

    boolean isAuthor();

    boolean isCommenter();

    <R> R reviewer(Function<UserSelector, R> selection);
}
