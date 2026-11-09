package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnmarkDiscussionCommentAsAnswerPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UnmarkDiscussionCommentAsAnswerPayload}; used by the generated selection code
 * only.
 */
final class UnmarkDiscussionCommentAsAnswerPayloadSelectorImpl
        implements UnmarkDiscussionCommentAsAnswerPayloadSelector {

    private final Cursor cursor;

    UnmarkDiscussionCommentAsAnswerPayloadSelectorImpl(final Cursor cursor) {
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
