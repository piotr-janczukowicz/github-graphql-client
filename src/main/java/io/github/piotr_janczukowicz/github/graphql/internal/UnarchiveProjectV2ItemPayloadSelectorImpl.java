package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnarchiveProjectV2ItemPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UnarchiveProjectV2ItemPayload}; used by the generated selection code only. */
final class UnarchiveProjectV2ItemPayloadSelectorImpl implements UnarchiveProjectV2ItemPayloadSelector {

    private final Cursor cursor;

    UnarchiveProjectV2ItemPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R item(final Function<ProjectV2ItemSelector, R> selection) {
        return cursor.object("item", child -> selection.apply(new ProjectV2ItemSelectorImpl(child)));
    }
}
