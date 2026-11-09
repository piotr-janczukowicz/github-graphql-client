package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2Field}. */
public interface ProjectV2FieldSelector {

    Instant createdAt();

    ProjectV2FieldType dataType();

    @Nullable Integer databaseId();

    String id();

    boolean isIssueField();

    <R> @Nullable R issueField(Function<IssueFieldsSelector, R> selection);

    String name();

    <R> R project(Function<ProjectV2Selector, R> selection);

    Instant updatedAt();
}
