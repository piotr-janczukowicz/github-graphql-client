package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code LabeledEvent}. */
public interface LabeledEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R intent(Function<IssueUpdateIntentSelector, R> selection);

    <R> R label(Function<LabelSelector, R> selection);

    <R> R labelable(Function<LabelableSelector, R> selection);
}
