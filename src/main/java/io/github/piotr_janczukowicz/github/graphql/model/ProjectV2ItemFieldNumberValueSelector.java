package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldNumberValue}. */
public interface ProjectV2ItemFieldNumberValueSelector {

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    @Nullable Integer databaseId();

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    String id();

    <R> R item(Function<ProjectV2ItemSelector, R> selection);

    @Nullable Double number();

    Instant updatedAt();
}
