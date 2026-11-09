package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMigrationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMigrationState;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code OrganizationMigration}; used by the generated selection code only. */
final class OrganizationMigrationSelectorImpl implements OrganizationMigrationSelector {

    private final Cursor cursor;

    OrganizationMigrationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
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
    public @Nullable Integer remainingRepositoriesCount() {
        return cursor.get("remainingRepositoriesCount", ScalarType.INT);
    }

    @Override
    public String sourceOrgName() {
        return cursor.getRequired("sourceOrgName", ScalarType.STRING);
    }

    @Override
    public String sourceOrgUrl() {
        return cursor.getRequired("sourceOrgUrl", ScalarType.STRING);
    }

    @Override
    public OrganizationMigrationState state() {
        return cursor.getRequired(
                "state",
                ScalarType.enumeration(OrganizationMigrationState::fromWire, OrganizationMigrationState.FAILED));
    }

    @Override
    public String targetOrgName() {
        return cursor.getRequired("targetOrgName", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer totalRepositoriesCount() {
        return cursor.get("totalRepositoriesCount", ScalarType.INT);
    }
}
