package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SubscribableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Subscribable}; used by the generated selection code only. */
final class SubscribableSelectorImpl implements SubscribableSelector {

    private final Cursor cursor;

    SubscribableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean viewerCanSubscribe() {
        return cursor.getRequired("viewerCanSubscribe", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable SubscriptionState viewerSubscription() {
        return cursor.get(
                "viewerSubscription", ScalarType.enumeration(SubscriptionState::fromWire, SubscriptionState.IGNORED));
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, SubscribableSelector.class, type, selection);
    }
}
