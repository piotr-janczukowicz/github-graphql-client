package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OrgRestoreMemberMembershipOrganizationAuditEntryData}. */
public interface OrgRestoreMemberMembershipOrganizationAuditEntryDataSelector {

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> @Nullable R organization(Function<OrganizationSelector, R> selection);

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String organizationName();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String organizationResourcePath();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String organizationUrl();
}
