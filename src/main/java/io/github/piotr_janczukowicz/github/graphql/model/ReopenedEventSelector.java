package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReopenedEvent}. */
public interface ReopenedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> R closable(Function<ClosableSelector, R> selection);

    Instant createdAt();

    String id();

    @Nullable IssueStateReason stateReason();
}
