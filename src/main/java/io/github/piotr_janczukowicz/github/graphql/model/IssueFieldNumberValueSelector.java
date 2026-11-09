package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldNumberValue}. */
public interface IssueFieldNumberValueSelector {

    <R> @Nullable R field(Function<IssueFieldsSelector, R> selection);

    String id();

    double value();
}
