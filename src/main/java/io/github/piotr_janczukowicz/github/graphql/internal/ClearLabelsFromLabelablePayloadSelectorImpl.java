package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ClearLabelsFromLabelablePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ClearLabelsFromLabelablePayload}; used by the generated selection code only.
 */
final class ClearLabelsFromLabelablePayloadSelectorImpl implements ClearLabelsFromLabelablePayloadSelector {

    private final Cursor cursor;

    ClearLabelsFromLabelablePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R labelable(final Function<LabelableSelector, R> selection) {
        return cursor.object("labelable", child -> selection.apply(new LabelableSelectorImpl(child)));
    }
}
