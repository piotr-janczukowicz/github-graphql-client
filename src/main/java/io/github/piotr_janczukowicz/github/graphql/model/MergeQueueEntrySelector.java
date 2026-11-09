package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MergeQueueEntry}. */
public interface MergeQueueEntrySelector {

    <R> @Nullable R baseCommit(Function<CommitSelector, R> selection);

    Instant enqueuedAt();

    <R> R enqueuer(Function<ActorSelector, R> selection);

    @Nullable Integer estimatedTimeToMerge();

    <R> @Nullable R headCommit(Function<CommitSelector, R> selection);

    String id();

    boolean jump();

    <R> @Nullable R mergeQueue(Function<MergeQueueSelector, R> selection);

    int position();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);

    boolean solo();

    MergeQueueEntryState state();
}
