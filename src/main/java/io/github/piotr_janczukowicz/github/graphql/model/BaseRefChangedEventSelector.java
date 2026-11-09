package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code BaseRefChangedEvent}. */
public interface BaseRefChangedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String currentRefName();

    @Nullable Integer databaseId();

    String id();

    String previousRefName();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);
}
