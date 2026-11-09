package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code PullRequestReviewContributionsByRepository}. */
public interface PullRequestReviewContributionsByRepositorySelector {

    <R> Page<R> contributions(
            Paging paging,
            PullRequestReviewContributionsByRepositoryContributionsFilter arguments,
            Function<CreatedPullRequestReviewContributionSelector, R> selection);

    <R> Page<R> contributions(Paging paging, Function<CreatedPullRequestReviewContributionSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);
}
