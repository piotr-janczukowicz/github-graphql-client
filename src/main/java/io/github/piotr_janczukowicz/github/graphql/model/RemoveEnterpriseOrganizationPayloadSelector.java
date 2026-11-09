package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RemoveEnterpriseOrganizationPayload}. */
public interface RemoveEnterpriseOrganizationPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R enterprise(Function<EnterpriseSelector, R> selection);

    <R> @Nullable R organization(Function<OrganizationSelector, R> selection);

    <R> @Nullable R viewer(Function<UserSelector, R> selection);
}
