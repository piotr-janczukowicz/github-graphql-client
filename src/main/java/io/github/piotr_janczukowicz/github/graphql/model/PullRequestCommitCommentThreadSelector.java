package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestCommitCommentThread}. */
public interface PullRequestCommitCommentThreadSelector {

    <R> Page<R> comments(Paging paging, Function<CommitCommentSelector, R> selection);

    <R> R commit(Function<CommitSelector, R> selection);

    String id();

    @Nullable String path();

    @Nullable Integer position();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);
}
