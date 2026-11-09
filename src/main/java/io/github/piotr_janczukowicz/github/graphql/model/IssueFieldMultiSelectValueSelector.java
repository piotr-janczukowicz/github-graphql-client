package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldMultiSelectValue}. */
public interface IssueFieldMultiSelectValueSelector {

    <R> @Nullable R field(Function<IssueFieldsSelector, R> selection);

    String id();

    <R> List<R> options(Function<IssueFieldSingleSelectOptionSelector, R> selection);

    @Nullable String value();
}
