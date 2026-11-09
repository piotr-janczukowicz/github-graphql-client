package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddProjectV2ItemByIdPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddProjectV2ItemByIdPayload}; used by the generated selection code only. */
final class AddProjectV2ItemByIdPayloadSelectorImpl implements AddProjectV2ItemByIdPayloadSelector {

    private final Cursor cursor;

    AddProjectV2ItemByIdPayloadSelectorImpl(final Cursor cursor) {
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
