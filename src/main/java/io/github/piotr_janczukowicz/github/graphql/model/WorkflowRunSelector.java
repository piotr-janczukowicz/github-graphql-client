package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code WorkflowRun}. */
public interface WorkflowRunSelector {

    <R> R checkSuite(Function<CheckSuiteSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    <R> Page<R> deploymentReviews(Paging paging, Function<DeploymentReviewSelector, R> selection);

    @Nullable String displayTitle();

    String event();

    <R> @Nullable R file(Function<WorkflowRunFileSelector, R> selection);

    String id();

    <R> Page<R> pendingDeploymentRequests(Paging paging, Function<DeploymentRequestSelector, R> selection);

    String resourcePath();

    int runAttempt();

    int runNumber();

    Instant updatedAt();

    String url();

    <R> R workflow(Function<WorkflowSelector, R> selection);
}
