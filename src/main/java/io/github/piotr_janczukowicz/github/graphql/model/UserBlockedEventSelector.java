package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UserBlockedEvent}. */
public interface UserBlockedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    UserBlockDuration blockDuration();

    Instant createdAt();

    String id();

    <R> @Nullable R subject(Function<UserSelector, R> selection);
}
