package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateLabelPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateLabelPayload}; used by the generated selection code only. */
final class UpdateLabelPayloadSelectorImpl implements UpdateLabelPayloadSelector {

    private final Cursor cursor;

    UpdateLabelPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R label(final Function<LabelSelector, R> selection) {
        return cursor.object("label", child -> selection.apply(new LabelSelectorImpl(child)));
    }
}
