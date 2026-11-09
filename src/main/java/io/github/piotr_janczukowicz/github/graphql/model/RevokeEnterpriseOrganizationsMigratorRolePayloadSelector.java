package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RevokeEnterpriseOrganizationsMigratorRolePayload}. */
public interface RevokeEnterpriseOrganizationsMigratorRolePayloadSelector {

    @Nullable String clientMutationId();

    <R> Page<R> organizations(Paging paging, Function<OrganizationSelector, R> selection);
}
