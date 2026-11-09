package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectV2StatusUpdatePayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateProjectV2StatusUpdatePayload}; used by the generated selection code
 * only.
 */
final class UpdateProjectV2StatusUpdatePayloadSelectorImpl implements UpdateProjectV2StatusUpdatePayloadSelector {

    private final Cursor cursor;

    UpdateProjectV2StatusUpdatePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R statusUpdate(final Function<ProjectV2StatusUpdateSelector, R> selection) {
        return cursor.object("statusUpdate", child -> selection.apply(new ProjectV2StatusUpdateSelectorImpl(child)));
    }
}
