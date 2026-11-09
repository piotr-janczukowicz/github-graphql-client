package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeploymentRequest}. */
public interface DeploymentRequestSelector {

    boolean currentUserCanApprove();

    <R> R environment(Function<EnvironmentSelector, R> selection);

    <R> Page<R> reviewers(Paging paging, Function<DeploymentReviewerSelector, R> selection);

    int waitTimer();

    @Nullable Instant waitTimerStartedAt();
}
