package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Organization.mannequins}; an argument left {@code null} is not sent. */
@RecordBuilder
public record OrganizationMannequinsFilter(
        @Nullable String login, @Nullable MannequinOrder orderBy) {}
