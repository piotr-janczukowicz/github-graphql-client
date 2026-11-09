package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OwnerProjectsV2Filter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OwnerProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2Owner}; used by the generated selection code only. */
final class ProjectV2OwnerSelectorImpl implements ProjectV2OwnerSelector {

    private final Cursor cursor;

    ProjectV2OwnerSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectV2(final int number, final Function<ProjectV2Selector, R> selection) {
        return cursor.object(
                "projectV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of("number", "Int!", number));
    }

    @Override
    public <R> Page<R> projectsV2(
            final Paging paging,
            final ProjectV2OwnerProjectsV2Filter arguments,
            final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "projectsV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of("minPermissionLevel", "ProjectV2PermissionLevel", arguments.minPermissionLevel()),
                Argument.of(
                        "orderBy",
                        "ProjectV2Order",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("query", "String", arguments.query()));
    }

    @Override
    public <R> Page<R> projectsV2(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        return projectsV2(
                paging, ProjectV2OwnerProjectsV2FilterBuilder.builder().build(), selection);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ProjectV2OwnerSelector.class, type, selection);
    }
}
