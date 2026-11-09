package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code EnterpriseUserAccount}. */
public interface EnterpriseUserAccountSelector {

    String avatarUrl(EnterpriseUserAccountAvatarUrlFilter arguments);

    String avatarUrl();

    Instant createdAt();

    <R> R enterprise(Function<EnterpriseSelector, R> selection);

    <R> Page<R> enterpriseInstallations(
            Paging paging,
            EnterpriseUserAccountEnterpriseInstallationsFilter arguments,
            Function<EnterpriseServerInstallationSelector, R> selection);

    <R> Page<R> enterpriseInstallations(Paging paging, Function<EnterpriseServerInstallationSelector, R> selection);

    String id();

    String login();

    @Nullable String name();

    <R> Page<R> organizations(
            Paging paging,
            EnterpriseUserAccountOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> organizations(Paging paging, Function<OrganizationSelector, R> selection);

    String resourcePath();

    Instant updatedAt();

    String url();

    <R> @Nullable R user(Function<UserSelector, R> selection);
}
