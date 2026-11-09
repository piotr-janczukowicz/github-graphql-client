package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AutomaticBaseChangeSucceededEvent}. */
public interface AutomaticBaseChangeSucceededEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    String newBase();

    String oldBase();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);
}
