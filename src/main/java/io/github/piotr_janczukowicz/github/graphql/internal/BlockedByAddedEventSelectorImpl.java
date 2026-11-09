package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BlockedByAddedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code BlockedByAddedEvent}; used by the generated selection code only. */
final class BlockedByAddedEventSelectorImpl implements BlockedByAddedEventSelector {

    private final Cursor cursor;

    BlockedByAddedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R blockingIssue(final Function<IssueSelector, R> selection) {
        return cursor.object("blockingIssue", child -> selection.apply(new IssueSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }
}
