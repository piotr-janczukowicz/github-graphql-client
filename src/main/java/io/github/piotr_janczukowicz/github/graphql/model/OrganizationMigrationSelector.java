package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OrganizationMigration}. */
public interface OrganizationMigrationSelector {

    Instant createdAt();

    @Nullable String databaseId();

    @Nullable String failureReason();

    String id();

    @Nullable Integer remainingRepositoriesCount();

    String sourceOrgName();

    String sourceOrgUrl();

    OrganizationMigrationState state();

    String targetOrgName();

    @Nullable Integer totalRepositoriesCount();
}
