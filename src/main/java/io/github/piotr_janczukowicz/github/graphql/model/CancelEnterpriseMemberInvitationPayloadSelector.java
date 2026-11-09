package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CancelEnterpriseMemberInvitationPayload}. */
public interface CancelEnterpriseMemberInvitationPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R invitation(Function<EnterpriseMemberInvitationSelector, R> selection);

    @Nullable String message();
}
