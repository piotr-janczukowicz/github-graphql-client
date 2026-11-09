package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SubscribableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateSubscriptionPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateSubscriptionPayload}; used by the generated selection code only. */
final class UpdateSubscriptionPayloadSelectorImpl implements UpdateSubscriptionPayloadSelector {

    private final Cursor cursor;

    UpdateSubscriptionPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R subscribable(final Function<SubscribableSelector, R> selection) {
        return cursor.object("subscribable", child -> selection.apply(new SubscribableSelectorImpl(child)));
    }
}
