package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldIterationValue}. */
public interface ProjectV2ItemFieldIterationValueSelector {

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    @Nullable Integer databaseId();

    int duration();

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    String id();

    <R> R item(Function<ProjectV2ItemSelector, R> selection);

    String iterationId();

    LocalDate startDate();

    String title();

    String titleHTML();

    Instant updatedAt();
}
