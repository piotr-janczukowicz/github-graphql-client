package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemContentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldValuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldValuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemType;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2Item}; used by the generated selection code only. */
final class ProjectV2ItemSelectorImpl implements ProjectV2ItemSelector {

    private final Cursor cursor;

    ProjectV2ItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R content(final Function<ProjectV2ItemContentSelector, R> selection) {
        return cursor.object("content", child -> selection.apply(new ProjectV2ItemContentSelectorImpl(child)));
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
    public <R> @Nullable R fieldValueByName(
            final String name, final Function<ProjectV2ItemFieldValueSelector, R> selection) {
        requireNonNull(name, "name");
        return cursor.object(
                "fieldValueByName",
                child -> selection.apply(new ProjectV2ItemFieldValueSelectorImpl(child)),
                Argument.of("name", "String!", name));
    }

    @Override
    public <R> Page<R> fieldValues(
            final Paging paging,
            final ProjectV2ItemFieldValuesFilter arguments,
            final Function<ProjectV2ItemFieldValueSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "fieldValues",
                child -> selection.apply(new ProjectV2ItemFieldValueSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "ProjectV2ItemFieldValueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> fieldValues(final Paging paging, final Function<ProjectV2ItemFieldValueSelector, R> selection) {
        return fieldValues(
                paging, ProjectV2ItemFieldValuesFilterBuilder.builder().build(), selection);
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
    public boolean isArchived() {
        return cursor.getRequired("isArchived", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R project(final Function<ProjectV2Selector, R> selection) {
        return cursor.objectRequired("project", child -> selection.apply(new ProjectV2SelectorImpl(child)));
    }

    @Override
    public ProjectV2ItemType type() {
        return cursor.getRequired(
                "type", ScalarType.enumeration(ProjectV2ItemType::fromWire, ProjectV2ItemType.DRAFT_ISSUE));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
