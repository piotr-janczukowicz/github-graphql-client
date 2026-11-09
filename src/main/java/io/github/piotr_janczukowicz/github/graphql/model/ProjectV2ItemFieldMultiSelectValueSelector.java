package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldMultiSelectValue}. */
public interface ProjectV2ItemFieldMultiSelectValueSelector {

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    @Nullable Integer databaseId();

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    String id();

    <R> R item(Function<ProjectV2ItemSelector, R> selection);

    <R> List<R> options(Function<ProjectV2MultiSelectFieldOptionSelector, R> selection);

    Instant updatedAt();

    String value();
}
