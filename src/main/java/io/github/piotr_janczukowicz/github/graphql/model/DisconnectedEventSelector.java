package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DisconnectedEvent}. */
public interface DisconnectedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    boolean isCrossRepository();

    <R> R source(Function<ReferencedSubjectSelector, R> selection);

    <R> R subject(Function<ReferencedSubjectSelector, R> selection);
}
