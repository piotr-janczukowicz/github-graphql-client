package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdateStatus;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2StatusUpdate}; used by the generated selection code only. */
final class ProjectV2StatusUpdateSelectorImpl implements ProjectV2StatusUpdateSelector {

    private final Cursor cursor;

    ProjectV2StatusUpdateSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String body() {
        return cursor.get("body", ScalarType.STRING);
    }

    @Override
    public @Nullable String bodyHTML() {
        return cursor.get("bodyHTML", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R creator(final Function<ActorSelector, R> selection) {
        return cursor.object("creator", child -> selection.apply(new ActorSelectorImpl(child)));
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
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> R project(final Function<ProjectV2Selector, R> selection) {
        return cursor.objectRequired("project", child -> selection.apply(new ProjectV2SelectorImpl(child)));
    }

    @Override
    public @Nullable LocalDate startDate() {
        return cursor.get("startDate", ScalarType.LOCAL_DATE);
    }

    @Override
    public @Nullable ProjectV2StatusUpdateStatus status() {
        return cursor.get(
                "status",
                ScalarType.enumeration(ProjectV2StatusUpdateStatus::fromWire, ProjectV2StatusUpdateStatus.AT_RISK));
    }

    @Override
    public @Nullable LocalDate targetDate() {
        return cursor.get("targetDate", ScalarType.LOCAL_DATE);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
