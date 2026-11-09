package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReopenDiscussionPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReopenDiscussionPayload}; used by the generated selection code only. */
final class ReopenDiscussionPayloadSelectorImpl implements ReopenDiscussionPayloadSelector {

    private final Cursor cursor;

    ReopenDiscussionPayloadSelectorImpl(final Cursor cursor) {
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
