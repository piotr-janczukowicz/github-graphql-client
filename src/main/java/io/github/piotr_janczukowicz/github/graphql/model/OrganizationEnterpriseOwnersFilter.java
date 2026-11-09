package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Organization.enterpriseOwners}; an argument left {@code null} is not sent. */
@RecordBuilder
public record OrganizationEnterpriseOwnersFilter(
        @Nullable OrgEnterpriseOwnerOrder orderBy,
        @Nullable RoleInOrganization organizationRole,
        @Nullable String query) {}
