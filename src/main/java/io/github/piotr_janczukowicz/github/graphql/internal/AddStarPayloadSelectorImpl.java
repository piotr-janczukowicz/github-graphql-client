package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddStarPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StarrableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddStarPayload}; used by the generated selection code only. */
final class AddStarPayloadSelectorImpl implements AddStarPayloadSelector {

    private final Cursor cursor;

    AddStarPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R starrable(final Function<StarrableSelector, R> selection) {
        return cursor.object("starrable", child -> selection.apply(new StarrableSelectorImpl(child)));
    }
}
