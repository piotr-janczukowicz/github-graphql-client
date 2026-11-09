package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code User.starredRepositories}; an argument left {@code null} is not sent. */
@RecordBuilder
public record UserStarredRepositoriesFilter(
        @Nullable StarOrder orderBy, @Nullable Boolean ownedByViewer) {}
