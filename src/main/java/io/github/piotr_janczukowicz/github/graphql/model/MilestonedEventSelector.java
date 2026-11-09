package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MilestonedEvent}. */
public interface MilestonedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    String milestoneTitle();

    <R> R subject(Function<MilestoneItemSelector, R> selection);
}
