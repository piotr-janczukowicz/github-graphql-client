package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code InviteEnterpriseMemberPayload}. */
public interface InviteEnterpriseMemberPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R invitation(Function<EnterpriseMemberInvitationSelector, R> selection);
}
