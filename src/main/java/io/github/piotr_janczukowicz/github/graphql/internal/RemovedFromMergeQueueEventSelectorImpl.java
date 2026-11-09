package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemovedFromMergeQueueEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RemovedFromMergeQueueEvent}; used by the generated selection code only. */
final class RemovedFromMergeQueueEventSelectorImpl implements RemovedFromMergeQueueEventSelector {

    private final Cursor cursor;

    RemovedFromMergeQueueEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R beforeCommit(final Function<CommitSelector, R> selection) {
        return cursor.object("beforeCommit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R enqueuer(final Function<UserSelector, R> selection) {
        return cursor.object("enqueuer", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R mergeQueue(final Function<MergeQueueSelector, R> selection) {
        return cursor.object("mergeQueue", child -> selection.apply(new MergeQueueSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public @Nullable String reason() {
        return cursor.get("reason", ScalarType.STRING);
    }
}
