package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DependabotUpdate}. */
public interface DependabotUpdateSelector {

    <R> @Nullable R error(Function<DependabotUpdateErrorSelector, R> selection);

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);
}
