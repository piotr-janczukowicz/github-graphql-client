package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateDiscussionCommentPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateDiscussionCommentPayload}; used by the generated selection code only.
 */
final class UpdateDiscussionCommentPayloadSelectorImpl implements UpdateDiscussionCommentPayloadSelector {

    private final Cursor cursor;

    UpdateDiscussionCommentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R comment(final Function<DiscussionCommentSelector, R> selection) {
        return cursor.object("comment", child -> selection.apply(new DiscussionCommentSelectorImpl(child)));
    }
}
