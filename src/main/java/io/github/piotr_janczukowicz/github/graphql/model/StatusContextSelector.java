package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code StatusContext}. */
public interface StatusContextSelector {

    @Nullable String avatarUrl(StatusContextAvatarUrlFilter arguments);

    @Nullable String avatarUrl();

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    String context();

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    @Nullable String description();

    String id();

    boolean isRequired(StatusContextIsRequiredFilter arguments);

    boolean isRequired();

    StatusState state();

    @Nullable String targetUrl();

    Instant updatedAt();
}
