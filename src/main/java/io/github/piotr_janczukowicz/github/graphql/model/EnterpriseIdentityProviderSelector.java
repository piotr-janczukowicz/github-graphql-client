package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code EnterpriseIdentityProvider}. */
public interface EnterpriseIdentityProviderSelector {

    @Nullable SamlDigestAlgorithm digestMethod();

    <R> @Nullable R enterprise(Function<EnterpriseSelector, R> selection);

    <R> Page<R> externalIdentities(
            Paging paging,
            EnterpriseIdentityProviderExternalIdentitiesFilter arguments,
            Function<ExternalIdentitySelector, R> selection);

    <R> Page<R> externalIdentities(Paging paging, Function<ExternalIdentitySelector, R> selection);

    String id();

    @Nullable String idpCertificate();

    @Nullable String issuer();

    List<String> recoveryCodes();

    @Nullable SamlSignatureAlgorithm signatureMethod();

    @Nullable String ssoUrl();
}
