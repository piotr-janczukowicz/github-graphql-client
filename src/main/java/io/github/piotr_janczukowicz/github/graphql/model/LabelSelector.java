package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Label}. */
public interface LabelSelector {

    String color();

    @Nullable Instant createdAt();

    @Nullable String description();

    String id();

    boolean isDefault();

    <R> Page<R> issues(Paging paging, LabelIssuesFilter arguments, Function<IssueSelector, R> selection);

    <R> Page<R> issues(Paging paging, Function<IssueSelector, R> selection);

    String name();

    <R> Page<R> pullRequests(
            Paging paging, LabelPullRequestsFilter arguments, Function<PullRequestSelector, R> selection);

    <R> Page<R> pullRequests(Paging paging, Function<PullRequestSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    @Nullable Instant updatedAt();

    String url();
}
