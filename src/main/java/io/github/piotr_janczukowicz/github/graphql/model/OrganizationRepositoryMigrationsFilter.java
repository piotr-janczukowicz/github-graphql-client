package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Organization.repositoryMigrations}; an argument left {@code null} is not sent. */
@RecordBuilder
public record OrganizationRepositoryMigrationsFilter(
        @Nullable RepositoryMigrationOrder orderBy,
        @Nullable String repositoryName,
        @Nullable MigrationState state) {}
