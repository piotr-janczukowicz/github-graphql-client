package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AcceptEnterpriseAdministratorInvitationPayload}. */
public interface AcceptEnterpriseAdministratorInvitationPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R invitation(Function<EnterpriseAdministratorInvitationSelector, R> selection);

    @Nullable String message();
}
