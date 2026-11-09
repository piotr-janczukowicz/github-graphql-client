package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Workflow}. */
public interface WorkflowSelector {

    Instant createdAt();

    @Nullable Integer databaseId();

    String id();

    String name();

    String resourcePath();

    <R> Page<R> runs(Paging paging, WorkflowRunsFilter arguments, Function<WorkflowRunSelector, R> selection);

    <R> Page<R> runs(Paging paging, Function<WorkflowRunSelector, R> selection);

    WorkflowState state();

    Instant updatedAt();

    String url();
}
