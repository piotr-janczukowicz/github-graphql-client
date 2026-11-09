package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code EnterpriseUserAccount.organizations}; an argument left {@code null} is not sent. */
@RecordBuilder
public record EnterpriseUserAccountOrganizationsFilter(
        @Nullable OrganizationOrder orderBy,
        @Nullable String query,
        @Nullable EnterpriseUserAccountMembershipRole role) {}
