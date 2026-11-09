package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectV2ItemFieldValuePayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateProjectV2ItemFieldValuePayload}; used by the generated selection code
 * only.
 */
final class UpdateProjectV2ItemFieldValuePayloadSelectorImpl implements UpdateProjectV2ItemFieldValuePayloadSelector {

    private final Cursor cursor;

    UpdateProjectV2ItemFieldValuePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectV2Item(final Function<ProjectV2ItemSelector, R> selection) {
        return cursor.object("projectV2Item", child -> selection.apply(new ProjectV2ItemSelectorImpl(child)));
    }
}
