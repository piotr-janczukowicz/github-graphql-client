package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteProjectColumnPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteProjectColumnPayload}; used by the generated selection code only. */
final class DeleteProjectColumnPayloadSelectorImpl implements DeleteProjectColumnPayloadSelector {

    private final Cursor cursor;

    DeleteProjectColumnPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable String deletedColumnId() {
        return cursor.get("deletedColumnId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R project(final Function<ProjectSelector, R> selection) {
        return cursor.object("project", child -> selection.apply(new ProjectSelectorImpl(child)));
    }
}
