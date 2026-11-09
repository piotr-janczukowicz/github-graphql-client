package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryOwner}. */
public interface RepositoryOwnerSelector {

    String avatarUrl(RepositoryOwnerAvatarUrlFilter arguments);

    String avatarUrl();

    String id();

    String login();

    <R> Page<R> repositories(
            Paging paging, RepositoryOwnerRepositoriesFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> repositories(Paging paging, Function<RepositorySelector, R> selection);

    <R> @Nullable R repository(
            String name, RepositoryOwnerRepositoryFilter arguments, Function<RepositorySelector, R> selection);

    <R> @Nullable R repository(String name, Function<RepositorySelector, R> selection);

    String resourcePath();

    String url();

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
