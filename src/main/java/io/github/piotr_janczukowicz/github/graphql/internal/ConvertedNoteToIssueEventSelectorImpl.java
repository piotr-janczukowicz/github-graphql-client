package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ConvertedNoteToIssueEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ConvertedNoteToIssueEvent}; used by the generated selection code only. */
final class ConvertedNoteToIssueEventSelectorImpl implements ConvertedNoteToIssueEventSelector {

    private final Cursor cursor;

    ConvertedNoteToIssueEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
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

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public <R> @Nullable R project(final Function<ProjectSelector, R> selection) {
        return cursor.object("project", child -> selection.apply(new ProjectSelectorImpl(child)));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public <R> @Nullable R projectCard(final Function<ProjectCardSelector, R> selection) {
        return cursor.object("projectCard", child -> selection.apply(new ProjectCardSelectorImpl(child)));
    }

    @Override
    public String projectColumnName() {
        return cursor.getRequired("projectColumnName", ScalarType.STRING);
    }
}
