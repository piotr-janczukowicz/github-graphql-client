package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReviewRequest}. */
public interface ReviewRequestSelector {

    boolean asCodeOwner();

    @Nullable Integer databaseId();

    String id();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    <R> @Nullable R requestedReviewer(Function<RequestedReviewerSelector, R> selection);
}
