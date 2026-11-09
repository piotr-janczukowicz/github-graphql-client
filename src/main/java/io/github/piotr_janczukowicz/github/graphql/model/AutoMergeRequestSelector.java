package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AutoMergeRequest}. */
public interface AutoMergeRequestSelector {

    @Nullable String authorEmail();

    @Nullable String commitBody();

    @Nullable String commitHeadline();

    @Nullable Instant enabledAt();

    <R> @Nullable R enabledBy(Function<ActorSelector, R> selection);

    PullRequestMergeMethod mergeMethod();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);
}
