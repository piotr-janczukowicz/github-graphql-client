package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldTextValue}. */
public interface IssueFieldTextValueSelector {

    <R> @Nullable R field(Function<IssueFieldsSelector, R> selection);

    String id();

    String value();
}
