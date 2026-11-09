package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RegenerateVerifiableDomainTokenPayloadSelector;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RegenerateVerifiableDomainTokenPayload}; used by the generated selection code
 * only.
 */
final class RegenerateVerifiableDomainTokenPayloadSelectorImpl
        implements RegenerateVerifiableDomainTokenPayloadSelector {

    private final Cursor cursor;

    RegenerateVerifiableDomainTokenPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable String verificationToken() {
        return cursor.get("verificationToken", ScalarType.STRING);
    }
}
