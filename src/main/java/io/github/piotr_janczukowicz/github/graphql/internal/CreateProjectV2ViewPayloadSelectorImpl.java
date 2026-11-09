package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateProjectV2ViewPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateProjectV2ViewPayload}; used by the generated selection code only. */
final class CreateProjectV2ViewPayloadSelectorImpl implements CreateProjectV2ViewPayloadSelector {

    private final Cursor cursor;

    CreateProjectV2ViewPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectV2View(final Function<ProjectV2ViewSelector, R> selection) {
        return cursor.object("projectV2View", child -> selection.apply(new ProjectV2ViewSelectorImpl(child)));
    }
}
