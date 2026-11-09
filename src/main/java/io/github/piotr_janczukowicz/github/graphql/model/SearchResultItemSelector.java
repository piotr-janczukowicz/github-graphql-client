package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SearchResultItem}. */
public interface SearchResultItemSelector {

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
