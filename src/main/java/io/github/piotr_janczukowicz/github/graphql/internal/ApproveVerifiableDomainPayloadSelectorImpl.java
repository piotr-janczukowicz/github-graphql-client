package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ApproveVerifiableDomainPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ApproveVerifiableDomainPayload}; used by the generated selection code only.
 */
final class ApproveVerifiableDomainPayloadSelectorImpl implements ApproveVerifiableDomainPayloadSelector {

    private final Cursor cursor;

    ApproveVerifiableDomainPayloadSelectorImpl(final Cursor cursor) {
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
