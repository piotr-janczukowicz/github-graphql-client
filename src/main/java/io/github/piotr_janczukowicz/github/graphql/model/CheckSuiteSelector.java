package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CheckSuite}. */
public interface CheckSuiteSelector {

    <R> @Nullable R app(Function<AppSelector, R> selection);

    <R> @Nullable R branch(Function<RefSelector, R> selection);

    <R> Page<R> checkRuns(Paging paging, CheckSuiteCheckRunsFilter arguments, Function<CheckRunSelector, R> selection);

    <R> Page<R> checkRuns(Paging paging, Function<CheckRunSelector, R> selection);

    <R> R commit(Function<CommitSelector, R> selection);

    @Nullable CheckConclusionState conclusion();

    Instant createdAt();

    <R> @Nullable R creator(Function<UserSelector, R> selection);

    @Nullable Integer databaseId();

    String id();

    <R> Page<R> matchingPullRequests(
            Paging paging, CheckSuiteMatchingPullRequestsFilter arguments, Function<PullRequestSelector, R> selection);

    <R> Page<R> matchingPullRequests(Paging paging, Function<PullRequestSelector, R> selection);

    <R> @Nullable R push(Function<PushSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    CheckStatusState status();

    Instant updatedAt();

    String url();

    <R> @Nullable R workflowRun(Function<WorkflowRunSelector, R> selection);
}
