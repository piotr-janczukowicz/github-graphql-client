package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code TransferredEvent}. */
public interface TransferredEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R fromRepository(Function<RepositorySelector, R> selection);

    String id();

    <R> R issue(Function<IssueSelector, R> selection);
}
