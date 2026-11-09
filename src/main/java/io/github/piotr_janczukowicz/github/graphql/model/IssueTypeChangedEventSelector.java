package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueTypeChangedEvent}. */
public interface IssueTypeChangedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R intent(Function<IssueUpdateIntentSelector, R> selection);

    <R> @Nullable R issueType(Function<IssueTypeSelector, R> selection);

    <R> @Nullable R prevIssueType(Function<IssueTypeSelector, R> selection);
}
