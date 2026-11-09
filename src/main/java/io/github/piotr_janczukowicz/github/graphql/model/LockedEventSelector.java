package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code LockedEvent}. */
public interface LockedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    @Nullable LockReason lockReason();

    <R> R lockable(Function<LockableSelector, R> selection);
}
