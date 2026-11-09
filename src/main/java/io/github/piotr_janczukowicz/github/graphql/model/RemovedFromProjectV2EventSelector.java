package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RemovedFromProjectV2Event}. */
public interface RemovedFromProjectV2EventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R project(Function<ProjectV2Selector, R> selection);

    boolean wasAutomated();
}
