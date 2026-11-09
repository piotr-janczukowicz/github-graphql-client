package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteVerifiableDomainPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainOwnerSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeleteVerifiableDomainPayload}; used by the generated selection code only. */
final class DeleteVerifiableDomainPayloadSelectorImpl implements DeleteVerifiableDomainPayloadSelector {

    private final Cursor cursor;

    DeleteVerifiableDomainPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R owner(final Function<VerifiableDomainOwnerSelector, R> selection) {
        return cursor.object("owner", child -> selection.apply(new VerifiableDomainOwnerSelectorImpl(child)));
    }
}
