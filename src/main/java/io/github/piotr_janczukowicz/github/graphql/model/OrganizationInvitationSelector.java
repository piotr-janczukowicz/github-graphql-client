package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OrganizationInvitation}. */
public interface OrganizationInvitationSelector {

    Instant createdAt();

    @Nullable String email();

    String id();

    OrganizationInvitationSource invitationSource();

    OrganizationInvitationType invitationType();

    <R> @Nullable R invitee(Function<UserSelector, R> selection);

    /**
     * @deprecated `inviter` will be removed. `inviter` will be replaced by `inviterActor`. Removal on 2024-07-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> R inviter(Function<UserSelector, R> selection);

    <R> @Nullable R inviterActor(Function<UserSelector, R> selection);

    <R> R organization(Function<OrganizationSelector, R> selection);

    OrganizationInvitationRole role();
}
