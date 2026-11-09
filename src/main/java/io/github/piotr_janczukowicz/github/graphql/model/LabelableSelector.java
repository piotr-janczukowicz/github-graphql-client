package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Labelable}. */
public interface LabelableSelector {

    <R> Page<R> labels(Paging paging, LabelableLabelsFilter arguments, Function<LabelSelector, R> selection);

    <R> Page<R> labels(Paging paging, Function<LabelSelector, R> selection);

    boolean viewerCanLabel();

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
