package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldSingleSelectValue}. */
public interface IssueFieldSingleSelectValueSelector {

    IssueFieldSingleSelectOptionColor color();

    @Nullable String description();

    <R> @Nullable R field(Function<IssueFieldsSelector, R> selection);

    String id();

    String name();

    @Nullable String optionId();

    String value();
}
