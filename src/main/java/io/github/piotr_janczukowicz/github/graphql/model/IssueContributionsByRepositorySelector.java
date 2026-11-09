package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code IssueContributionsByRepository}. */
public interface IssueContributionsByRepositorySelector {

    <R> Page<R> contributions(
            Paging paging,
            IssueContributionsByRepositoryContributionsFilter arguments,
            Function<CreatedIssueContributionSelector, R> selection);

    <R> Page<R> contributions(Paging paging, Function<CreatedIssueContributionSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);
}
