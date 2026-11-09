package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CheckRun}. */
public interface CheckRunSelector {

    <R> Page<R> annotations(Paging paging, Function<CheckAnnotationSelector, R> selection);

    <R> R checkSuite(Function<CheckSuiteSelector, R> selection);

    @Nullable Instant completedAt();

    @Nullable CheckConclusionState conclusion();

    @Nullable Integer databaseId();

    <R> @Nullable R deployment(Function<DeploymentSelector, R> selection);

    @Nullable String detailsUrl();

    @Nullable String externalId();

    String id();

    boolean isRequired(CheckRunIsRequiredFilter arguments);

    boolean isRequired();

    String name();

    <R> @Nullable R pendingDeploymentRequest(Function<DeploymentRequestSelector, R> selection);

    String permalink();

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    @Nullable Instant startedAt();

    CheckStatusState status();

    <R> Page<R> steps(Paging paging, CheckRunStepsFilter arguments, Function<CheckStepSelector, R> selection);

    <R> Page<R> steps(Paging paging, Function<CheckStepSelector, R> selection);

    @Nullable String summary();

    @Nullable String text();

    @Nullable String title();

    String url();
}
