package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UserStatus}. */
public interface UserStatusSelector {

    Instant createdAt();

    @Nullable String emoji();

    @Nullable String emojiHTML();

    @Nullable Instant expiresAt();

    String id();

    boolean indicatesLimitedAvailability();

    @Nullable String message();

    <R> @Nullable R organization(Function<OrganizationSelector, R> selection);

    Instant updatedAt();

    <R> R user(Function<UserSelector, R> selection);
}
