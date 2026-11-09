package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MigrationSourceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MigrationState;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryMigrationSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryMigration}; used by the generated selection code only. */
final class RepositoryMigrationSelectorImpl implements RepositoryMigrationSelector {

    private final Cursor cursor;

    RepositoryMigrationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean continueOnError() {
        return cursor.getRequired("continueOnError", ScalarType.BOOLEAN);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String databaseId() {
        return cursor.get("databaseId", ScalarType.STRING);
    }

    @Override
    public @Nullable String failureReason() {
        return cursor.get("failureReason", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String migrationLogUrl() {
        return cursor.get("migrationLogUrl", ScalarType.STRING);
    }

    @Override
    public <R> R migrationSource(final Function<MigrationSourceSelector, R> selection) {
        return cursor.objectRequired(
                "migrationSource", child -> selection.apply(new MigrationSourceSelectorImpl(child)));
    }

    @Override
    public String repositoryName() {
        return cursor.getRequired("repositoryName", ScalarType.STRING);
    }

    @Override
    public String sourceUrl() {
        return cursor.getRequired("sourceUrl", ScalarType.STRING);
    }

    @Override
    public MigrationState state() {
        return cursor.getRequired("state", ScalarType.enumeration(MigrationState::fromWire, MigrationState.FAILED));
    }

    @Override
    public int warningsCount() {
        return cursor.getRequired("warningsCount", ScalarType.INT);
    }
}
