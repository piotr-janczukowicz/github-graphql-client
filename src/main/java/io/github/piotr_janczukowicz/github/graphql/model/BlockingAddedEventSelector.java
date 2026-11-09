package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code BlockingAddedEvent}. */
public interface BlockingAddedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> @Nullable R blockedIssue(Function<IssueSelector, R> selection);

    Instant createdAt();

    String id();
}
