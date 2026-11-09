package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Status}. */
public interface StatusSelector {

    <R> Page<R> combinedContexts(Paging paging, Function<StatusCheckRollupContextSelector, R> selection);

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    <R> @Nullable R context(String name, Function<StatusContextSelector, R> selection);

    <R> List<R> contexts(Function<StatusContextSelector, R> selection);

    String id();

    StatusState state();
}
