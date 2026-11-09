package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Gist}. */
public interface GistSelector {

    <R> Page<R> comments(Paging paging, Function<GistCommentSelector, R> selection);

    Instant createdAt();

    @Nullable String description();

    <R> List<R> files(GistFilesFilter arguments, Function<GistFileSelector, R> selection);

    <R> List<R> files(Function<GistFileSelector, R> selection);

    <R> Page<R> forks(Paging paging, GistForksFilter arguments, Function<GistSelector, R> selection);

    <R> Page<R> forks(Paging paging, Function<GistSelector, R> selection);

    String id();

    boolean isFork();

    boolean isPublic();

    String name();

    <R> @Nullable R owner(Function<RepositoryOwnerSelector, R> selection);

    @Nullable Instant pushedAt();

    String resourcePath();

    int stargazerCount();

    <R> Page<R> stargazers(Paging paging, GistStargazersFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> stargazers(Paging paging, Function<UserSelector, R> selection);

    Instant updatedAt();

    String url();

    boolean viewerHasStarred();
}
