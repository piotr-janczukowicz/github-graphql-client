package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DequeuePullRequestPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntrySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DequeuePullRequestPayload}; used by the generated selection code only. */
final class DequeuePullRequestPayloadSelectorImpl implements DequeuePullRequestPayloadSelector {

    private final Cursor cursor;

    DequeuePullRequestPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R mergeQueueEntry(final Function<MergeQueueEntrySelector, R> selection) {
        return cursor.object("mergeQueueEntry", child -> selection.apply(new MergeQueueEntrySelectorImpl(child)));
    }
}
