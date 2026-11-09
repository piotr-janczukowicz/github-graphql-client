package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CrossReferencedEvent}. */
public interface CrossReferencedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    boolean isCrossRepository();

    Instant referencedAt();

    String resourcePath();

    <R> R source(Function<ReferencedSubjectSelector, R> selection);

    <R> R target(Function<ReferencedSubjectSelector, R> selection);

    String url();

    boolean willCloseTarget();
}
