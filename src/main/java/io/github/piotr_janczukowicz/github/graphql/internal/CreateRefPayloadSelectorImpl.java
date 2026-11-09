package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateRefPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateRefPayload}; used by the generated selection code only. */
final class CreateRefPayloadSelectorImpl implements CreateRefPayloadSelector {

    private final Cursor cursor;

    CreateRefPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R ref(final Function<RefSelector, R> selection) {
        return cursor.object("ref", child -> selection.apply(new RefSelectorImpl(child)));
    }
}
