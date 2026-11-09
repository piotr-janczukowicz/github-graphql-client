package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddProjectColumnPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddProjectColumnPayload}; used by the generated selection code only. */
final class AddProjectColumnPayloadSelectorImpl implements AddProjectColumnPayloadSelector {

    private final Cursor cursor;

    AddProjectColumnPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R columnEdge(final Function<ProjectColumnEdgeSelector, R> selection) {
        return cursor.object("columnEdge", child -> selection.apply(new ProjectColumnEdgeSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R project(final Function<ProjectSelector, R> selection) {
        return cursor.object("project", child -> selection.apply(new ProjectSelectorImpl(child)));
    }
}
