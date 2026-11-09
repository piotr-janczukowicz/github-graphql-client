package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryInteractionAbility}. */
public interface RepositoryInteractionAbilitySelector {

    @Nullable Instant expiresAt();

    RepositoryInteractionLimit limit();

    RepositoryInteractionLimitOrigin origin();
}
