package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SetEnterpriseIdentityProviderPayload}. */
public interface SetEnterpriseIdentityProviderPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R identityProvider(Function<EnterpriseIdentityProviderSelector, R> selection);
}
