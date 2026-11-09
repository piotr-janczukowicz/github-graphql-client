package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddedToMergeQueueEvent}. */
public interface AddedToMergeQueueEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R enqueuer(Function<UserSelector, R> selection);

    String id();

    <R> @Nullable R mergeQueue(Function<MergeQueueSelector, R> selection);

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);
}
