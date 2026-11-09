package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code WorkflowFileReference}. */
public interface WorkflowFileReferenceSelector {

    String path();

    @Nullable String ref();

    int repositoryId();

    @Nullable String sha();
}
