package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemoveEnterpriseOrganizationPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RemoveEnterpriseOrganizationPayload}; used by the generated selection code
 * only.
 */
final class RemoveEnterpriseOrganizationPayloadSelectorImpl implements RemoveEnterpriseOrganizationPayloadSelector {

    private final Cursor cursor;

    RemoveEnterpriseOrganizationPayloadSelectorImpl(final Cursor cursor) {
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

    @Override
    public <R> @Nullable R viewer(final Function<UserSelector, R> selection) {
        return cursor.object("viewer", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
