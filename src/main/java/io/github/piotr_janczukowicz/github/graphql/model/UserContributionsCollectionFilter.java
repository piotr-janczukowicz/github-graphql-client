package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code User.contributionsCollection}; an argument left {@code null} is not sent. */
@RecordBuilder
public record UserContributionsCollectionFilter(
        @Nullable Instant from,
        @Nullable String organizationID,
        @Nullable Instant to) {}
