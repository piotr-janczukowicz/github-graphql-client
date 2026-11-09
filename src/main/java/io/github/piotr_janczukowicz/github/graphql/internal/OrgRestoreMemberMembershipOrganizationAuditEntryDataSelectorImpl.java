package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberMembershipOrganizationAuditEntryDataSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code OrgRestoreMemberMembershipOrganizationAuditEntryData}; used by the generated
 * selection code only.
 */
final class OrgRestoreMemberMembershipOrganizationAuditEntryDataSelectorImpl
        implements OrgRestoreMemberMembershipOrganizationAuditEntryDataSelector {

    private static final String REMOVAL = "removal";

    private final Cursor cursor;

    OrgRestoreMemberMembershipOrganizationAuditEntryDataSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> @Nullable R organization(final Function<OrganizationSelector, R> selection) {
        return cursor.object("organization", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String organizationName() {
        return cursor.get("organizationName", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String organizationResourcePath() {
        return cursor.get("organizationResourcePath", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String organizationUrl() {
        return cursor.get("organizationUrl", ScalarType.STRING);
    }
}
