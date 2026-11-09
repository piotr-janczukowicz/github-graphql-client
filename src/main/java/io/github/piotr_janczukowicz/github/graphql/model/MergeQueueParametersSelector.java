package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code MergeQueueParameters}. */
public interface MergeQueueParametersSelector {

    int checkResponseTimeoutMinutes();

    MergeQueueGroupingStrategy groupingStrategy();

    int maxEntriesToBuild();

    int maxEntriesToMerge();

    MergeQueueMergeMethod mergeMethod();

    int minEntriesToMerge();

    int minEntriesToMergeWaitMinutes();
}
