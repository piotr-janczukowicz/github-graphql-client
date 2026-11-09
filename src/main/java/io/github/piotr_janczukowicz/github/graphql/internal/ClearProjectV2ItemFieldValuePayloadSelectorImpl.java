package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ClearProjectV2ItemFieldValuePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ClearProjectV2ItemFieldValuePayload}; used by the generated selection code
 * only.
 */
final class ClearProjectV2ItemFieldValuePayloadSelectorImpl implements ClearProjectV2ItemFieldValuePayloadSelector {

    private final Cursor cursor;

    ClearProjectV2ItemFieldValuePayloadSelectorImpl(final Cursor cursor) {
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
