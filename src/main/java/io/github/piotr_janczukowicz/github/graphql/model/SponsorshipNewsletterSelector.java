package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SponsorshipNewsletter}. */
public interface SponsorshipNewsletterSelector {

    <R> @Nullable R author(Function<UserSelector, R> selection);

    String body();

    Instant createdAt();

    String id();

    boolean isPublished();

    <R> R sponsorable(Function<SponsorableSelector, R> selection);

    String subject();

    Instant updatedAt();
}
