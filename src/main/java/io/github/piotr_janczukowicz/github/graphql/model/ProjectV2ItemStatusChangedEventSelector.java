package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2ItemStatusChangedEvent}. */
public interface ProjectV2ItemStatusChangedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    String previousStatus();

    <R> @Nullable R project(Function<ProjectV2Selector, R> selection);

    String status();

    boolean wasAutomated();
}
