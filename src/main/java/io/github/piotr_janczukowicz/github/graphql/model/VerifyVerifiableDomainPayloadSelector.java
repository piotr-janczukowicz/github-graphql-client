package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code VerifyVerifiableDomainPayload}. */
public interface VerifyVerifiableDomainPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R domain(Function<VerifiableDomainSelector, R> selection);
}
