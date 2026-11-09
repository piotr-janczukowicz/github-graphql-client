package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestTemplate}. */
public interface PullRequestTemplateSelector {

    @Nullable String body();

    @Nullable String filename();

    <R> R repository(Function<RepositorySelector, R> selection);
}
