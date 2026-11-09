package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReferencedEvent}. */
public interface ReferencedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    <R> R commitRepository(Function<RepositorySelector, R> selection);

    Instant createdAt();

    String id();

    boolean isCrossRepository();

    boolean isDirectReference();

    <R> R subject(Function<ReferencedSubjectSelector, R> selection);
}
