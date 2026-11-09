package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CommitCommentThread}. */
public interface CommitCommentThreadSelector {

    <R> Page<R> comments(Paging paging, Function<CommitCommentSelector, R> selection);

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    String id();

    @Nullable String path();

    @Nullable Integer position();

    <R> R repository(Function<RepositorySelector, R> selection);
}
