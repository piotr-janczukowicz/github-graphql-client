package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteDiscussionPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteDiscussionPayload}; used by the generated selection code only. */
final class DeleteDiscussionPayloadSelectorImpl implements DeleteDiscussionPayloadSelector {

    private final Cursor cursor;

    DeleteDiscussionPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R discussion(final Function<DiscussionSelector, R> selection) {
        return cursor.object("discussion", child -> selection.apply(new DiscussionSelectorImpl(child)));
    }
}
