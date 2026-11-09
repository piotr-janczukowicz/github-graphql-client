package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2WorkflowSelector;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2Workflow}; used by the generated selection code only. */
final class ProjectV2WorkflowSelectorImpl implements ProjectV2WorkflowSelector {

    private final Cursor cursor;

    ProjectV2WorkflowSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public boolean enabled() {
        return cursor.getRequired("enabled", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
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
    public int number() {
        return cursor.getRequired("number", ScalarType.INT);
    }

    @Override
    public <R> R project(final Function<ProjectV2Selector, R> selection) {
        return cursor.objectRequired("project", child -> selection.apply(new ProjectV2SelectorImpl(child)));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
