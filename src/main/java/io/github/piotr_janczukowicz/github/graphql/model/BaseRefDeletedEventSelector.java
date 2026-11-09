package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code BaseRefDeletedEvent}. */
public interface BaseRefDeletedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    @Nullable String baseRefName();

    Instant createdAt();

    String id();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);
}
