package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Starrable}. */
public interface StarrableSelector {

    String id();

    int stargazerCount();

    <R> Page<R> stargazers(Paging paging, StarrableStargazersFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> stargazers(Paging paging, Function<UserSelector, R> selection);

    boolean viewerHasStarred();

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
