package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestThread}. */
public interface PullRequestThreadSelector {

    <R> Page<R> comments(
            Paging paging,
            PullRequestThreadCommentsFilter arguments,
            Function<PullRequestReviewCommentSelector, R> selection);

    <R> Page<R> comments(Paging paging, Function<PullRequestReviewCommentSelector, R> selection);

    DiffSide diffSide();

    String id();

    boolean isCollapsed();

    boolean isOutdated();

    boolean isResolved();

    @Nullable Integer line();

    String path();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    <R> @Nullable R resolvedBy(Function<UserSelector, R> selection);

    @Nullable DiffSide startDiffSide();

    @Nullable Integer startLine();

    PullRequestReviewThreadSubjectType subjectType();

    boolean viewerCanReply();

    boolean viewerCanResolve();

    boolean viewerCanUnresolve();
}
