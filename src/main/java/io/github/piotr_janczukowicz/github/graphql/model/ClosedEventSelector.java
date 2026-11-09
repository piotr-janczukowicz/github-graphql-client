package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ClosedEvent}. */
public interface ClosedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> R closable(Function<ClosableSelector, R> selection);

    <R> @Nullable R closer(Function<CloserSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R duplicateOf(Function<IssueOrPullRequestSelector, R> selection);

    String id();

    <R> @Nullable R intent(Function<IssueUpdateIntentSelector, R> selection);

    String resourcePath();

    @Nullable IssueStateReason stateReason();

    String url();
}
