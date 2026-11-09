package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RegenerateVerifiableDomainTokenPayload}. */
public interface RegenerateVerifiableDomainTokenPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String verificationToken();
}
