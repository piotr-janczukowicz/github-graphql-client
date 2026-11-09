package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateProjectV2PayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateProjectV2Payload}; used by the generated selection code only. */
final class CreateProjectV2PayloadSelectorImpl implements CreateProjectV2PayloadSelector {

    private final Cursor cursor;

    CreateProjectV2PayloadSelectorImpl(final Cursor cursor) {
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
