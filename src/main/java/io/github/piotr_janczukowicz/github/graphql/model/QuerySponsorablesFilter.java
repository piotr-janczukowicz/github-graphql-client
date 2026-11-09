package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Query.sponsorables}; an argument left {@code null} is not sent. */
@RecordBuilder
public record QuerySponsorablesFilter(
        @Nullable SecurityAdvisoryEcosystem dependencyEcosystem,
        @Nullable DependencyGraphEcosystem ecosystem,
        @Nullable Boolean onlyDependencies,
        @Nullable SponsorableOrder orderBy,
        @Nullable String orgLoginForDependencies) {}
