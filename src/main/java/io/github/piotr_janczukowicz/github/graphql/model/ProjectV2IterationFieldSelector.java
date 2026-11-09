package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2IterationField}. */
public interface ProjectV2IterationFieldSelector {

    <R> R configuration(Function<ProjectV2IterationFieldConfigurationSelector, R> selection);

    Instant createdAt();

    ProjectV2FieldType dataType();

    @Nullable Integer databaseId();

    String id();

    boolean isIssueField();

    String name();

    <R> R project(Function<ProjectV2Selector, R> selection);

    Instant updatedAt();
}
