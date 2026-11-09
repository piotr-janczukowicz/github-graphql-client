package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldPullRequestValue}. */
public interface ProjectV2ItemFieldPullRequestValueSelector {

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> Page<R> pullRequests(
            Paging paging,
            ProjectV2ItemFieldPullRequestValuePullRequestsFilter arguments,
            Function<PullRequestSelector, R> selection);

    <R> Page<R> pullRequests(Paging paging, Function<PullRequestSelector, R> selection);
}
