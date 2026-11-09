package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MergedEvent}. */
public interface MergedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R mergeRef(Function<RefSelector, R> selection);

    String mergeRefName();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    String resourcePath();

    String url();
}
