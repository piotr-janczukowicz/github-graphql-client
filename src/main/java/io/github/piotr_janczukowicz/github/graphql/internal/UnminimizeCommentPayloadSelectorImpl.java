package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MinimizableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnminimizeCommentPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UnminimizeCommentPayload}; used by the generated selection code only. */
final class UnminimizeCommentPayloadSelectorImpl implements UnminimizeCommentPayloadSelector {

    private final Cursor cursor;

    UnminimizeCommentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R unminimizedComment(final Function<MinimizableSelector, R> selection) {
        return cursor.object("unminimizedComment", child -> selection.apply(new MinimizableSelectorImpl(child)));
    }
}
