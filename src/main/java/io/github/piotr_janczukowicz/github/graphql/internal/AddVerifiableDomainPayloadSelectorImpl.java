package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddVerifiableDomainPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddVerifiableDomainPayload}; used by the generated selection code only. */
final class AddVerifiableDomainPayloadSelectorImpl implements AddVerifiableDomainPayloadSelector {

    private final Cursor cursor;

    AddVerifiableDomainPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R domain(final Function<VerifiableDomainSelector, R> selection) {
        return cursor.object("domain", child -> selection.apply(new VerifiableDomainSelectorImpl(child)));
    }
}
