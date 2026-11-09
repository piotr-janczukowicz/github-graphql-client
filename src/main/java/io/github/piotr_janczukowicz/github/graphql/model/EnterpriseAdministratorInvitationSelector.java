package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code EnterpriseAdministratorInvitation}. */
public interface EnterpriseAdministratorInvitationSelector {

    Instant createdAt();

    @Nullable String email();

    <R> R enterprise(Function<EnterpriseSelector, R> selection);

    String id();

    <R> @Nullable R invitee(Function<UserSelector, R> selection);

    <R> @Nullable R inviter(Function<UserSelector, R> selection);

    EnterpriseAdministratorRole role();
}
