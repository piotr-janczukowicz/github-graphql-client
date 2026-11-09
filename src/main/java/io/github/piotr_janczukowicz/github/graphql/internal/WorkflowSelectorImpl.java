package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowState;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Workflow}; used by the generated selection code only. */
final class WorkflowSelectorImpl implements WorkflowSelector {

    private final Cursor cursor;

    WorkflowSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> runs(
            final Paging paging, final WorkflowRunsFilter arguments, final Function<WorkflowRunSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "runs",
                child -> selection.apply(new WorkflowRunSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "WorkflowRunOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> runs(final Paging paging, final Function<WorkflowRunSelector, R> selection) {
        return runs(paging, WorkflowRunsFilterBuilder.builder().build(), selection);
    }

    @Override
    public WorkflowState state() {
        return cursor.getRequired("state", ScalarType.enumeration(WorkflowState::fromWire, WorkflowState.ACTIVE));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
