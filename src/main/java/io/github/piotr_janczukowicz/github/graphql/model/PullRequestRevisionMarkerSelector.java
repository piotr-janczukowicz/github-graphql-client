package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;

/** Selection of the GraphQL type {@code PullRequestRevisionMarker}. */
public interface PullRequestRevisionMarkerSelector {

    Instant createdAt();

    <R> R lastSeenCommit(Function<CommitSelector, R> selection);

    <R> R pullRequest(Function<PullRequestSelector, R> selection);
}
