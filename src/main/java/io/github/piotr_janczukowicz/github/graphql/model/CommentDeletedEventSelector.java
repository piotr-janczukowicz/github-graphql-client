package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CommentDeletedEvent}. */
public interface CommentDeletedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    <R> @Nullable R deletedCommentAuthor(Function<ActorSelector, R> selection);

    String id();
}
