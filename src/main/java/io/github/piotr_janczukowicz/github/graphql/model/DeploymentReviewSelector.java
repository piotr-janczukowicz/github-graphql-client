package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeploymentReview}. */
public interface DeploymentReviewSelector {

    String comment();

    @Nullable Integer databaseId();

    <R> Page<R> environments(Paging paging, Function<EnvironmentSelector, R> selection);

    String id();

    DeploymentReviewState state();

    <R> R user(Function<UserSelector, R> selection);
}
