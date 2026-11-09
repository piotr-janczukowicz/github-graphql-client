package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code PullRequestChangedFile}. */
public interface PullRequestChangedFileSelector {

    int additions();

    PatchStatus changeType();

    int deletions();

    String path();

    FileViewedState viewerViewedState();
}
