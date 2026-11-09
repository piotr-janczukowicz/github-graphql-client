package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddDiscussionPollVotePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddDiscussionPollVotePayload}; used by the generated selection code only. */
final class AddDiscussionPollVotePayloadSelectorImpl implements AddDiscussionPollVotePayloadSelector {

    private final Cursor cursor;

    AddDiscussionPollVotePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R pollOption(final Function<DiscussionPollOptionSelector, R> selection) {
        return cursor.object("pollOption", child -> selection.apply(new DiscussionPollOptionSelectorImpl(child)));
    }
}
