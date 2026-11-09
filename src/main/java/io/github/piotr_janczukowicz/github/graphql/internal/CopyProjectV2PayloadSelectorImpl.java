package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CopyProjectV2PayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CopyProjectV2Payload}; used by the generated selection code only. */
final class CopyProjectV2PayloadSelectorImpl implements CopyProjectV2PayloadSelector {

    private final Cursor cursor;

    CopyProjectV2PayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectV2(final Function<ProjectV2Selector, R> selection) {
        return cursor.object("projectV2", child -> selection.apply(new ProjectV2SelectorImpl(child)));
    }
}
