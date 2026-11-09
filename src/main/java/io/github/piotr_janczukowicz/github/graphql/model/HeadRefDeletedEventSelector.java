package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code HeadRefDeletedEvent}. */
public interface HeadRefDeletedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R headRef(Function<RefSelector, R> selection);

    String headRefName();

    String id();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);
}
