package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code BaseRefForcePushedEvent}. */
public interface BaseRefForcePushedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> @Nullable R afterCommit(Function<CommitSelector, R> selection);

    <R> @Nullable R beforeCommit(Function<CommitSelector, R> selection);

    Instant createdAt();

    String id();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    <R> @Nullable R ref(Function<RefSelector, R> selection);
}
