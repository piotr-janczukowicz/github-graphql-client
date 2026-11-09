package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code StatusCheckRollup}. */
public interface StatusCheckRollupSelector {

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    <R> Page<R> contexts(Paging paging, Function<StatusCheckRollupContextSelector, R> selection);

    String id();

    StatusState state();
}
