package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestStackEntry}. */
public interface PullRequestStackEntrySelector {

    String id();

    int position();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);

    <R> @Nullable R stack(Function<PullRequestStackSelector, R> selection);
}
