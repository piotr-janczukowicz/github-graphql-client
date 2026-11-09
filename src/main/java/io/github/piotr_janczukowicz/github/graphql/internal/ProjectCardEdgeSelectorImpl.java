package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectCardEdge}; used by the generated selection code only. */
final class ProjectCardEdgeSelectorImpl implements ProjectCardEdgeSelector {

    private final Cursor cursor;

    ProjectCardEdgeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String cursor() {
        return cursor.getRequired("cursor", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R node(final Function<ProjectCardSelector, R> selection) {
        return cursor.object("node", child -> selection.apply(new ProjectCardSelectorImpl(child)));
    }
}
