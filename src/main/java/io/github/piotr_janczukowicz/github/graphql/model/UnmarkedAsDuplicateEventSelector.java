package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UnmarkedAsDuplicateEvent}. */
public interface UnmarkedAsDuplicateEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> @Nullable R canonical(Function<IssueOrPullRequestSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R duplicate(Function<IssueOrPullRequestSelector, R> selection);

    String id();

    boolean isCrossRepository();
}
