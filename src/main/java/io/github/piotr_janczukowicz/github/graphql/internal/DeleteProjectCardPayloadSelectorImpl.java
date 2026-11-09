package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteProjectCardPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectColumnSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteProjectCardPayload}; used by the generated selection code only. */
final class DeleteProjectCardPayloadSelectorImpl implements DeleteProjectCardPayloadSelector {

    private final Cursor cursor;

    DeleteProjectCardPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R column(final Function<ProjectColumnSelector, R> selection) {
        return cursor.object("column", child -> selection.apply(new ProjectColumnSelectorImpl(child)));
    }

    @Override
    public @Nullable String deletedCardId() {
        return cursor.get("deletedCardId", ScalarType.STRING);
    }
}
