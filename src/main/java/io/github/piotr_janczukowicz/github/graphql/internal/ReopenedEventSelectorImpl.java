package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ClosableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReason;
import io.github.piotr_janczukowicz.github.graphql.model.ReopenedEventSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReopenedEvent}; used by the generated selection code only. */
final class ReopenedEventSelectorImpl implements ReopenedEventSelector {

    private final Cursor cursor;

    ReopenedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> R closable(final Function<ClosableSelector, R> selection) {
        return cursor.objectRequired("closable", child -> selection.apply(new ClosableSelectorImpl(child)));
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
    public @Nullable IssueStateReason stateReason() {
        return cursor.get(
                "stateReason", ScalarType.enumeration(IssueStateReason::fromWire, IssueStateReason.COMPLETED));
    }
}
