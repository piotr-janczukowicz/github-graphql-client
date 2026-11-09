package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddedToStackEvent}. */
public interface AddedToStackEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);

    @Nullable BigInteger stackId();

    @Nullable Integer stackNumber();
}
