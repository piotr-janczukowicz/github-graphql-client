package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReorderEnvironmentPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReorderEnvironmentPayload}; used by the generated selection code only. */
final class ReorderEnvironmentPayloadSelectorImpl implements ReorderEnvironmentPayloadSelector {

    private final Cursor cursor;

    ReorderEnvironmentPayloadSelectorImpl(final Cursor cursor) {
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
}
