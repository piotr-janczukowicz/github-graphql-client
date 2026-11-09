package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CloneProjectPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CloneProjectPayload}; used by the generated selection code only. */
final class CloneProjectPayloadSelectorImpl implements CloneProjectPayloadSelector {

    private final Cursor cursor;

    CloneProjectPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable String jobStatusId() {
        return cursor.get("jobStatusId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R project(final Function<ProjectSelector, R> selection) {
        return cursor.object("project", child -> selection.apply(new ProjectSelectorImpl(child)));
    }
}
