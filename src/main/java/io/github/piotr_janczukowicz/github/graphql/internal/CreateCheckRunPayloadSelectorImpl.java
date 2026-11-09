package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CheckRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreateCheckRunPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateCheckRunPayload}; used by the generated selection code only. */
final class CreateCheckRunPayloadSelectorImpl implements CreateCheckRunPayloadSelector {

    private final Cursor cursor;

    CreateCheckRunPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R checkRun(final Function<CheckRunSelector, R> selection) {
        return cursor.object("checkRun", child -> selection.apply(new CheckRunSelectorImpl(child)));
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
