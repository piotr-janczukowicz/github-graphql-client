package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.OffsetDateTime;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code GitActor}. */
public interface GitActorSelector {

    String avatarUrl(GitActorAvatarUrlFilter arguments);

    String avatarUrl();

    @Nullable OffsetDateTime date();

    @Nullable String email();

    @Nullable String name();

    <R> @Nullable R user(Function<UserSelector, R> selection);
}
