package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateEnterpriseOrganizationPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code CreateEnterpriseOrganizationPayload}; used by the generated selection code
 * only.
 */
final class CreateEnterpriseOrganizationPayloadSelectorImpl implements CreateEnterpriseOrganizationPayloadSelector {

    private final Cursor cursor;

    CreateEnterpriseOrganizationPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R enterprise(final Function<EnterpriseSelector, R> selection) {
        return cursor.object("enterprise", child -> selection.apply(new EnterpriseSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R organization(final Function<OrganizationSelector, R> selection) {
        return cursor.object("organization", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }
}
