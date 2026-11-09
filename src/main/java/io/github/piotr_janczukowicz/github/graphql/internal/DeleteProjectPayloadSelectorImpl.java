package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteProjectPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectOwnerSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteProjectPayload}; used by the generated selection code only. */
final class DeleteProjectPayloadSelectorImpl implements DeleteProjectPayloadSelector {

    private final Cursor cursor;

    DeleteProjectPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R owner(final Function<ProjectOwnerSelector, R> selection) {
        return cursor.object("owner", child -> selection.apply(new ProjectOwnerSelectorImpl(child)));
    }
}
