package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateAttributionInvitationPayload}. */
public interface CreateAttributionInvitationPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R owner(Function<OrganizationSelector, R> selection);

    <R> @Nullable R source(Function<ClaimableSelector, R> selection);

    <R> @Nullable R target(Function<ClaimableSelector, R> selection);
}
