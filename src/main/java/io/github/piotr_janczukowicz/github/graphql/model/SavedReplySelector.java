package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SavedReply}. */
public interface SavedReplySelector {

    String body();

    String bodyHTML();

    @Nullable Integer databaseId();

    String id();

    String title();

    <R> @Nullable R user(Function<ActorSelector, R> selection);
}
