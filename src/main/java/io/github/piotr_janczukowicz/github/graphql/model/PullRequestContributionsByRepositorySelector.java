package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code PullRequestContributionsByRepository}. */
public interface PullRequestContributionsByRepositorySelector {

    <R> Page<R> contributions(
            Paging paging,
            PullRequestContributionsByRepositoryContributionsFilter arguments,
            Function<CreatedPullRequestContributionSelector, R> selection);

    <R> Page<R> contributions(Paging paging, Function<CreatedPullRequestContributionSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);
}
