package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OIDCProvider}. */
public interface OIDCProviderSelector {

    <R> @Nullable R enterprise(Function<EnterpriseSelector, R> selection);

    <R> Page<R> externalIdentities(
            Paging paging,
            OIDCProviderExternalIdentitiesFilter arguments,
            Function<ExternalIdentitySelector, R> selection);

    <R> Page<R> externalIdentities(Paging paging, Function<ExternalIdentitySelector, R> selection);

    String id();

    OIDCProviderType providerType();

    String tenantId();
}
