package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AutoMergeDisabledEvent}. */
public interface AutoMergeDisabledEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R disabler(Function<UserSelector, R> selection);

    String id();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);

    @Nullable String reason();

    @Nullable String reasonCode();
}
