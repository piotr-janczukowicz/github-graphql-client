package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestReviewThread}. */
public interface PullRequestReviewThreadSelector {

    <R> Page<R> comments(
            Paging paging,
            PullRequestReviewThreadCommentsFilter arguments,
            Function<PullRequestReviewCommentSelector, R> selection);

    <R> Page<R> comments(Paging paging, Function<PullRequestReviewCommentSelector, R> selection);

    DiffSide diffSide();

    String id();

    boolean isCollapsed();

    boolean isOutdated();

    boolean isResolved();

    @Nullable Integer line();

    @Nullable Integer originalLine();

    @Nullable Integer originalStartLine();

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
