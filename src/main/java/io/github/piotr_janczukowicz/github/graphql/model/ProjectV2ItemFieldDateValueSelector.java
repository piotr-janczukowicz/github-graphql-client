package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldDateValue}. */
public interface ProjectV2ItemFieldDateValueSelector {

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    @Nullable Integer databaseId();

    @Nullable LocalDate date();

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    String id();

    <R> R item(Function<ProjectV2ItemSelector, R> selection);

    Instant updatedAt();
}
