package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DemilestonedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneItemSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DemilestonedEvent}; used by the generated selection code only. */
final class DemilestonedEventSelectorImpl implements DemilestonedEventSelector {

    private final Cursor cursor;

    DemilestonedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
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
    public String milestoneTitle() {
        return cursor.getRequired("milestoneTitle", ScalarType.STRING);
    }

    @Override
    public <R> R subject(final Function<MilestoneItemSelector, R> selection) {
        return cursor.objectRequired("subject", child -> selection.apply(new MilestoneItemSelectorImpl(child)));
    }
}
