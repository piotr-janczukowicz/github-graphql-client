package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntryState;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code MergeQueueEntry}; used by the generated selection code only. */
final class MergeQueueEntrySelectorImpl implements MergeQueueEntrySelector {

    private final Cursor cursor;

    MergeQueueEntrySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R baseCommit(final Function<CommitSelector, R> selection) {
        return cursor.object("baseCommit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public Instant enqueuedAt() {
        return cursor.getRequired("enqueuedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R enqueuer(final Function<ActorSelector, R> selection) {
        return cursor.objectRequired("enqueuer", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable Integer estimatedTimeToMerge() {
        return cursor.get("estimatedTimeToMerge", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R headCommit(final Function<CommitSelector, R> selection) {
        return cursor.object("headCommit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean jump() {
        return cursor.getRequired("jump", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R mergeQueue(final Function<MergeQueueSelector, R> selection) {
        return cursor.object("mergeQueue", child -> selection.apply(new MergeQueueSelectorImpl(child)));
    }

    @Override
    public int position() {
        return cursor.getRequired("position", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public boolean solo() {
        return cursor.getRequired("solo", ScalarType.BOOLEAN);
    }

    @Override
    public MergeQueueEntryState state() {
        return cursor.getRequired(
                "state", ScalarType.enumeration(MergeQueueEntryState::fromWire, MergeQueueEntryState.AWAITING_CHECKS));
    }
}
