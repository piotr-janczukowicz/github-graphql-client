package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OrganizationIdentityProvider}. */
public interface OrganizationIdentityProviderSelector {

    @Nullable String digestMethod();

    <R> Page<R> externalIdentities(
            Paging paging,
            OrganizationIdentityProviderExternalIdentitiesFilter arguments,
            Function<ExternalIdentitySelector, R> selection);

    <R> Page<R> externalIdentities(Paging paging, Function<ExternalIdentitySelector, R> selection);

    String id();

    @Nullable String idpCertificate();

    @Nullable String issuer();

    <R> @Nullable R organization(Function<OrganizationSelector, R> selection);

    @Nullable String signatureMethod();

    @Nullable String ssoUrl();
}
