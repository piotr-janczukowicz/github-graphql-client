package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code BlockedByAddedEvent}. */
public interface BlockedByAddedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> @Nullable R blockingIssue(Function<IssueSelector, R> selection);

    Instant createdAt();

    String id();
}
