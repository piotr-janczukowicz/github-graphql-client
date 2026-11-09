package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateEnvironmentPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateEnvironmentPayload}; used by the generated selection code only. */
final class CreateEnvironmentPayloadSelectorImpl implements CreateEnvironmentPayloadSelector {

    private final Cursor cursor;

    CreateEnvironmentPayloadSelectorImpl(final Cursor cursor) {
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
