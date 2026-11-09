package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.WorkflowFileReferenceSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code WorkflowFileReference}; used by the generated selection code only. */
final class WorkflowFileReferenceSelectorImpl implements WorkflowFileReferenceSelector {

    private final Cursor cursor;

    WorkflowFileReferenceSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String path() {
        return cursor.getRequired("path", ScalarType.STRING);
    }

    @Override
    public @Nullable String ref() {
        return cursor.get("ref", ScalarType.STRING);
    }

    @Override
    public int repositoryId() {
        return cursor.getRequired("repositoryId", ScalarType.INT);
    }

    @Override
    public @Nullable String sha() {
        return cursor.get("sha", ScalarType.STRING);
    }
}
