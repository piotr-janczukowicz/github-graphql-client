package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Push}. */
public interface PushSelector {

    String id();

    @Nullable String nextSha();

    String permalink();

    @Nullable String previousSha();

    <R> R pusher(Function<ActorSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);
}
