package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionAbilitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionLimit;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionLimitOrigin;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryInteractionAbility}; used by the generated selection code only. */
final class RepositoryInteractionAbilitySelectorImpl implements RepositoryInteractionAbilitySelector {

    private final Cursor cursor;

    RepositoryInteractionAbilitySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Instant expiresAt() {
        return cursor.get("expiresAt", ScalarType.INSTANT);
    }

    @Override
    public RepositoryInteractionLimit limit() {
        return cursor.getRequired(
                "limit",
                ScalarType.enumeration(
                        RepositoryInteractionLimit::fromWire, RepositoryInteractionLimit.COLLABORATORS_ONLY));
    }

    @Override
    public RepositoryInteractionLimitOrigin origin() {
        return cursor.getRequired(
                "origin",
                ScalarType.enumeration(
                        RepositoryInteractionLimitOrigin::fromWire, RepositoryInteractionLimitOrigin.ORGANIZATION));
    }
}
