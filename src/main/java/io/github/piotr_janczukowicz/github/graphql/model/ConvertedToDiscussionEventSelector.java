package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ConvertedToDiscussionEvent}. */
public interface ConvertedToDiscussionEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R discussion(Function<DiscussionSelector, R> selection);

    String id();
}
