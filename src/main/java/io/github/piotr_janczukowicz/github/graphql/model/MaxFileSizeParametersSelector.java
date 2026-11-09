package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;

/** Selection of the GraphQL type {@code MaxFileSizeParameters}. */
public interface MaxFileSizeParametersSelector {

    List<String> ignoredFilePaths();

    int maxFileSize();
}
