package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryInvitation}. */
public interface RepositoryInvitationSelector {

    @Nullable String email();

    String id();

    <R> @Nullable R invitee(Function<UserSelector, R> selection);

    <R> R inviter(Function<UserSelector, R> selection);

    String permalink();

    RepositoryPermission permission();

    <R> @Nullable R repository(Function<RepositoryInfoSelector, R> selection);
}
