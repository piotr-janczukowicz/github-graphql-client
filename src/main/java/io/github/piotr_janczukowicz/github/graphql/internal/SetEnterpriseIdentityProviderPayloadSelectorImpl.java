package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SetEnterpriseIdentityProviderPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code SetEnterpriseIdentityProviderPayload}; used by the generated selection code
 * only.
 */
final class SetEnterpriseIdentityProviderPayloadSelectorImpl implements SetEnterpriseIdentityProviderPayloadSelector {

    private final Cursor cursor;

    SetEnterpriseIdentityProviderPayloadSelectorImpl(final Cursor cursor) {
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
