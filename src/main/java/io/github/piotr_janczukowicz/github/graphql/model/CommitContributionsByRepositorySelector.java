package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code CommitContributionsByRepository}. */
public interface CommitContributionsByRepositorySelector {

    <R> Page<R> contributions(
            Paging paging,
            CommitContributionsByRepositoryContributionsFilter arguments,
            Function<CreatedCommitContributionSelector, R> selection);

    <R> Page<R> contributions(Paging paging, Function<CreatedCommitContributionSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    String url();
}
