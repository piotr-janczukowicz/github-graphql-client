package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2SingleSelectField}. */
public interface ProjectV2SingleSelectFieldSelector {

    Instant createdAt();

    ProjectV2FieldType dataType();

    @Nullable Integer databaseId();

    String id();

    boolean isIssueField();

    <R> @Nullable R issueField(Function<IssueFieldsSelector, R> selection);

    String name();

    <R> List<R> options(
            ProjectV2SingleSelectFieldOptionsFilter arguments,
            Function<ProjectV2SingleSelectFieldOptionSelector, R> selection);

    <R> List<R> options(Function<ProjectV2SingleSelectFieldOptionSelector, R> selection);

    <R> R project(Function<ProjectV2Selector, R> selection);

    Instant updatedAt();
}
