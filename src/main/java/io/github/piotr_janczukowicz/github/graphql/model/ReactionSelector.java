package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Reaction}. */
public interface ReactionSelector {

    ReactionContent content();

    Instant createdAt();

    @Nullable Integer databaseId();

    String id();

    <R> R reactable(Function<ReactableSelector, R> selection);

    <R> @Nullable R user(Function<UserSelector, R> selection);
}
