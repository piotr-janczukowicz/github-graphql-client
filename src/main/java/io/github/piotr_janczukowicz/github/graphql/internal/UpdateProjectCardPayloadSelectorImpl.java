package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectCardPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateProjectCardPayload}; used by the generated selection code only. */
final class UpdateProjectCardPayloadSelectorImpl implements UpdateProjectCardPayloadSelector {

    private final Cursor cursor;

    UpdateProjectCardPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectCard(final Function<ProjectCardSelector, R> selection) {
        return cursor.object("projectCard", child -> selection.apply(new ProjectCardSelectorImpl(child)));
    }
}
