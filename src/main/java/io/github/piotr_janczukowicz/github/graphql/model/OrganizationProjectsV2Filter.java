package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Organization.projectsV2}; an argument left {@code null} is not sent. */
@RecordBuilder
public record OrganizationProjectsV2Filter(
        @Nullable ProjectV2PermissionLevel minPermissionLevel,
        @Nullable ProjectV2Order orderBy,
        @Nullable String query) {}
