package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CodeCoverageParameters}. */
public interface CodeCoverageParametersSelector {

    @Nullable Double maxCoverageDrop();

    @Nullable Double minimumCoverage();
}
