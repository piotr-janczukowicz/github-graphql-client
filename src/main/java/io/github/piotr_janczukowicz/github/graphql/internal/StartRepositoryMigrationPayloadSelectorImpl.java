package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMigrationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StartRepositoryMigrationPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code StartRepositoryMigrationPayload}; used by the generated selection code only.
 */
final class StartRepositoryMigrationPayloadSelectorImpl implements StartRepositoryMigrationPayloadSelector {

    private final Cursor cursor;

    StartRepositoryMigrationPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R repositoryMigration(final Function<RepositoryMigrationSelector, R> selection) {
        return cursor.object(
                "repositoryMigration", child -> selection.apply(new RepositoryMigrationSelectorImpl(child)));
    }
}
