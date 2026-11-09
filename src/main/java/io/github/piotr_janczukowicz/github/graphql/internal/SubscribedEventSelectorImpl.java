package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscribableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscribedEventSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SubscribedEvent}; used by the generated selection code only. */
final class SubscribedEventSelectorImpl implements SubscribedEventSelector {

    private final Cursor cursor;

    SubscribedEventSelectorImpl(final Cursor cursor) {
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
    public <R> R subscribable(final Function<SubscribableSelector, R> selection) {
        return cursor.objectRequired("subscribable", child -> selection.apply(new SubscribableSelectorImpl(child)));
    }
}
