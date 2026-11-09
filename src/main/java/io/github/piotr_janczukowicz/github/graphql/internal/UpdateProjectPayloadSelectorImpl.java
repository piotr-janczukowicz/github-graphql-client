package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateProjectPayload}; used by the generated selection code only. */
final class UpdateProjectPayloadSelectorImpl implements UpdateProjectPayloadSelector {

    private final Cursor cursor;

    UpdateProjectPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R project(final Function<ProjectSelector, R> selection) {
        return cursor.object("project", child -> selection.apply(new ProjectSelectorImpl(child)));
    }
}
