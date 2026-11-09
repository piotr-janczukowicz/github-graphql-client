package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Milestone}. */
public interface MilestoneSelector {

    boolean closed();

    @Nullable Instant closedAt();

    int closedIssueCount();

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    @Nullable String description();

    @Nullable String descriptionHTML();

    @Nullable Instant dueOn();

    String id();

    <R> Page<R> issues(Paging paging, MilestoneIssuesFilter arguments, Function<IssueSelector, R> selection);

    <R> Page<R> issues(Paging paging, Function<IssueSelector, R> selection);

    int number();

    int openIssueCount();

    double progressPercentage();

    <R> Page<R> pullRequests(
            Paging paging, MilestonePullRequestsFilter arguments, Function<PullRequestSelector, R> selection);

    <R> Page<R> pullRequests(Paging paging, Function<PullRequestSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    MilestoneState state();

    String title();

    Instant updatedAt();

    String url();

    boolean viewerCanClose();

    boolean viewerCanReopen();
}
