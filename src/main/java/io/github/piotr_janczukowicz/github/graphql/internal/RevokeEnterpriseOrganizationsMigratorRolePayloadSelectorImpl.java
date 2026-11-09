package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RevokeEnterpriseOrganizationsMigratorRolePayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RevokeEnterpriseOrganizationsMigratorRolePayload}; used by the generated
 * selection code only.
 */
final class RevokeEnterpriseOrganizationsMigratorRolePayloadSelectorImpl
        implements RevokeEnterpriseOrganizationsMigratorRolePayloadSelector {

    private final Cursor cursor;

    RevokeEnterpriseOrganizationsMigratorRolePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> organizations(final Paging paging, final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "organizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }
}
