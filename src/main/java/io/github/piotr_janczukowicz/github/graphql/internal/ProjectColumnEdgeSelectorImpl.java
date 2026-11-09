package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectColumnEdge}; used by the generated selection code only. */
final class ProjectColumnEdgeSelectorImpl implements ProjectColumnEdgeSelector {

    private final Cursor cursor;

    ProjectColumnEdgeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String cursor() {
        return cursor.getRequired("cursor", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R node(final Function<ProjectColumnSelector, R> selection) {
        return cursor.object("node", child -> selection.apply(new ProjectColumnSelectorImpl(child)));
    }
}
