package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinEnvironmentPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedEnvironmentSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PinEnvironmentPayload}; used by the generated selection code only. */
final class PinEnvironmentPayloadSelectorImpl implements PinEnvironmentPayloadSelector {

    private final Cursor cursor;

    PinEnvironmentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R environment(final Function<EnvironmentSelector, R> selection) {
        return cursor.object("environment", child -> selection.apply(new EnvironmentSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R pinnedEnvironment(final Function<PinnedEnvironmentSelector, R> selection) {
        return cursor.object("pinnedEnvironment", child -> selection.apply(new PinnedEnvironmentSelectorImpl(child)));
    }
}
