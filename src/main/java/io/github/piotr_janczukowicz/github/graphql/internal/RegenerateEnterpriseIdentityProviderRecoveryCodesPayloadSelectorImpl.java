package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RegenerateEnterpriseIdentityProviderRecoveryCodesPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RegenerateEnterpriseIdentityProviderRecoveryCodesPayload}; used by the
 * generated selection code only.
 */
final class RegenerateEnterpriseIdentityProviderRecoveryCodesPayloadSelectorImpl
        implements RegenerateEnterpriseIdentityProviderRecoveryCodesPayloadSelector {

    private final Cursor cursor;

    RegenerateEnterpriseIdentityProviderRecoveryCodesPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R identityProvider(final Function<EnterpriseIdentityProviderSelector, R> selection) {
        return cursor.object(
                "identityProvider", child -> selection.apply(new EnterpriseIdentityProviderSelectorImpl(child)));
    }
}
