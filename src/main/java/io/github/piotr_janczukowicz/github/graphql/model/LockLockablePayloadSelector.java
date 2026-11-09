package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code LockLockablePayload}. */
public interface LockLockablePayloadSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    @Nullable String clientMutationId();

    <R> @Nullable R lockedRecord(Function<LockableSelector, R> selection);
}
