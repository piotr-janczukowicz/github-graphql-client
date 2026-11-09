package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeleteVerifiableDomainPayload}. */
public interface DeleteVerifiableDomainPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R owner(Function<VerifiableDomainOwnerSelector, R> selection);
}
