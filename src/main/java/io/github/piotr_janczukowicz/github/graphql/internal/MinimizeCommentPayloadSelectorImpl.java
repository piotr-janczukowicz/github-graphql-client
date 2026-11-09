package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MinimizableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MinimizeCommentPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code MinimizeCommentPayload}; used by the generated selection code only. */
final class MinimizeCommentPayloadSelectorImpl implements MinimizeCommentPayloadSelector {

    private final Cursor cursor;

    MinimizeCommentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R minimizedComment(final Function<MinimizableSelector, R> selection) {
        return cursor.object("minimizedComment", child -> selection.apply(new MinimizableSelectorImpl(child)));
    }
}
