package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Mannequin}. */
public interface MannequinSelector {

    String avatarUrl(MannequinAvatarUrlFilter arguments);

    String avatarUrl();

    <R> @Nullable R claimant(Function<UserSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    @Nullable String email();

    String id();

    String login();

    @Nullable String name();

    String resourcePath();

    Instant updatedAt();

    String url();
}
