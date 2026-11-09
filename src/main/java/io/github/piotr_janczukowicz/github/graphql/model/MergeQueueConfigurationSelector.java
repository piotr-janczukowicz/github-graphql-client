package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MergeQueueConfiguration}. */
public interface MergeQueueConfigurationSelector {

    @Nullable Integer checkResponseTimeout();

    @Nullable Integer maximumEntriesToBuild();

    @Nullable Integer maximumEntriesToMerge();

    @Nullable PullRequestMergeMethod mergeMethod();

    @Nullable MergeQueueMergingStrategy mergingStrategy();

    @Nullable Integer minimumEntriesToMerge();

    @Nullable Integer minimumEntriesToMergeWaitTime();
}
