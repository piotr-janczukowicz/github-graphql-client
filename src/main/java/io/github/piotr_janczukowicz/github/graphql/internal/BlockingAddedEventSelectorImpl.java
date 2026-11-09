package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BlockingAddedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code BlockingAddedEvent}; used by the generated selection code only. */
final class BlockingAddedEventSelectorImpl implements BlockingAddedEventSelector {

    private final Cursor cursor;

    BlockingAddedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R blockedIssue(final Function<IssueSelector, R> selection) {
        return cursor.object("blockedIssue", child -> selection.apply(new IssueSelectorImpl(child)));
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
