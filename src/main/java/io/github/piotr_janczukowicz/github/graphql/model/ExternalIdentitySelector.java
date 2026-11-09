package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ExternalIdentity}. */
public interface ExternalIdentitySelector {

    String guid();

    String id();

    <R> @Nullable R organizationInvitation(Function<OrganizationInvitationSelector, R> selection);

    <R> @Nullable R samlIdentity(Function<ExternalIdentitySamlAttributesSelector, R> selection);

    <R> @Nullable R scimIdentity(Function<ExternalIdentityScimAttributesSelector, R> selection);

    <R> @Nullable R user(Function<UserSelector, R> selection);
}
