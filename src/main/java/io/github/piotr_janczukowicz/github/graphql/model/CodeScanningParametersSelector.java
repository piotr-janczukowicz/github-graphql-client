package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code CodeScanningParameters}. */
public interface CodeScanningParametersSelector {

    <R> List<R> codeScanningTools(Function<CodeScanningToolSelector, R> selection);
}
