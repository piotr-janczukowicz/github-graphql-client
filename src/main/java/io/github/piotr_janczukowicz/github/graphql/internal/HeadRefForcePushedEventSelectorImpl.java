package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.HeadRefForcePushedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code HeadRefForcePushedEvent}; used by the generated selection code only. */
final class HeadRefForcePushedEventSelectorImpl implements HeadRefForcePushedEventSelector {

    private final Cursor cursor;

    HeadRefForcePushedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R afterCommit(final Function<CommitSelector, R> selection) {
        return cursor.object("afterCommit", child -> selection.apply(new CommitSelectorImpl(child)));
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
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R ref(final Function<RefSelector, R> selection) {
        return cursor.object("ref", child -> selection.apply(new RefSelectorImpl(child)));
    }
}
