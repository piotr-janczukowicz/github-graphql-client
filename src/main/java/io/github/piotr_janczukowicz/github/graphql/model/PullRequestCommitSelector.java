package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code PullRequestCommit}. */
public interface PullRequestCommitSelector {

    <R> R commit(Function<CommitSelector, R> selection);

    String id();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    String resourcePath();

    String url();
}
