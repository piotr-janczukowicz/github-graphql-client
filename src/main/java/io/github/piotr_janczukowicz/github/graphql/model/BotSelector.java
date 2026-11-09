package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Bot}. */
public interface BotSelector {

    String avatarUrl(BotAvatarUrlFilter arguments);

    String avatarUrl();

    Instant createdAt();

    @Nullable Integer databaseId();

    String id();

    String login();

    String resourcePath();

    Instant updatedAt();

    String url();
}
