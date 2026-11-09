package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemoveEnterpriseIdentityProviderPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RemoveEnterpriseIdentityProviderPayload}; used by the generated selection code
 * only.
 */
final class RemoveEnterpriseIdentityProviderPayloadSelectorImpl
        implements RemoveEnterpriseIdentityProviderPayloadSelector {

    private final Cursor cursor;

    RemoveEnterpriseIdentityProviderPayloadSelectorImpl(final Cursor cursor) {
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
