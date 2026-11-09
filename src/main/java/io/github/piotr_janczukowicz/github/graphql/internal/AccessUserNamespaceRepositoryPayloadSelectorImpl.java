package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AccessUserNamespaceRepositoryPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code AccessUserNamespaceRepositoryPayload}; used by the generated selection code
 * only.
 */
final class AccessUserNamespaceRepositoryPayloadSelectorImpl implements AccessUserNamespaceRepositoryPayloadSelector {

    private final Cursor cursor;

    AccessUserNamespaceRepositoryPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant expiresAt() {
        return cursor.get("expiresAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositorySelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
