package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Team.members}; an argument left {@code null} is not sent. */
@RecordBuilder
public record TeamMembersFilter(
        @Nullable TeamMembershipType membership,
        @Nullable TeamMemberOrder orderBy,
        @Nullable String query,
        @Nullable TeamMemberRole role) {}
