package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldSingleSelectValue}. */
public interface ProjectV2ItemFieldSingleSelectValueSelector {

    ProjectV2SingleSelectFieldOptionColor color();

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    @Nullable Integer databaseId();

    @Nullable String description();

    @Nullable String descriptionHTML();

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    String id();

    <R> R item(Function<ProjectV2ItemSelector, R> selection);

    @Nullable String name();

    @Nullable String nameHTML();

    @Nullable String optionId();

    Instant updatedAt();
}
