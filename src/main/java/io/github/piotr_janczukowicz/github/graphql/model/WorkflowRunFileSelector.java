package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code WorkflowRunFile}. */
public interface WorkflowRunFileSelector {

    String id();

    String path();

    String repositoryFileUrl();

    String repositoryName();

    String resourcePath();

    <R> R run(Function<WorkflowRunSelector, R> selection);

    String url();

    boolean viewerCanPushRepository();

    boolean viewerCanReadRepository();
}
