package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AutoRebaseEnabledEvent}. */
public interface AutoRebaseEnabledEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R enabler(Function<UserSelector, R> selection);

    String id();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);
}
