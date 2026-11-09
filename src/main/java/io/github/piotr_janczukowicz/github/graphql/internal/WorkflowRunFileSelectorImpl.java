package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code WorkflowRunFile}; used by the generated selection code only. */
final class WorkflowRunFileSelectorImpl implements WorkflowRunFileSelector {

    private final Cursor cursor;

    WorkflowRunFileSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String path() {
        return cursor.getRequired("path", ScalarType.STRING);
    }

    @Override
    public String repositoryFileUrl() {
        return cursor.getRequired("repositoryFileUrl", ScalarType.STRING);
    }

    @Override
    public String repositoryName() {
        return cursor.getRequired("repositoryName", ScalarType.STRING);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> R run(final Function<WorkflowRunSelector, R> selection) {
        return cursor.objectRequired("run", child -> selection.apply(new WorkflowRunSelectorImpl(child)));
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public boolean viewerCanPushRepository() {
        return cursor.getRequired("viewerCanPushRepository", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReadRepository() {
        return cursor.getRequired("viewerCanReadRepository", ScalarType.BOOLEAN);
    }
}
