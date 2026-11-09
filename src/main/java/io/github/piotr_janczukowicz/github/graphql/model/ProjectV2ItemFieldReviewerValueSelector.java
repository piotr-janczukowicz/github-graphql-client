package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldReviewerValue}. */
public interface ProjectV2ItemFieldReviewerValueSelector {

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> Page<R> reviewers(Paging paging, Function<RequestedReviewerSelector, R> selection);
}
