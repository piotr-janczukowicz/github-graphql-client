package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Tag}. */
public interface TagSelector {

    String abbreviatedOid();

    String commitResourcePath();

    String commitUrl();

    String id();

    @Nullable String message();

    String name();

    String oid();

    <R> R repository(Function<RepositorySelector, R> selection);

    <R> @Nullable R tagger(Function<GitActorSelector, R> selection);

    <R> R target(Function<GitObjectSelector, R> selection);
}
