package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueTemplate}. */
public interface IssueTemplateSelector {

    @Nullable String about();

    <R> Page<R> assignees(Paging paging, Function<UserSelector, R> selection);

    @Nullable String body();

    String filename();

    <R> Page<R> labels(Paging paging, IssueTemplateLabelsFilter arguments, Function<LabelSelector, R> selection);

    <R> Page<R> labels(Paging paging, Function<LabelSelector, R> selection);

    String name();

    @Nullable String title();

    <R> @Nullable R type(Function<IssueTypeSelector, R> selection);
}
