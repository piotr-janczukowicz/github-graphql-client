package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMigrationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StartOrganizationMigrationPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code StartOrganizationMigrationPayload}; used by the generated selection code only.
 */
final class StartOrganizationMigrationPayloadSelectorImpl implements StartOrganizationMigrationPayloadSelector {

    private final Cursor cursor;

    StartOrganizationMigrationPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R orgMigration(final Function<OrganizationMigrationSelector, R> selection) {
        return cursor.object("orgMigration", child -> selection.apply(new OrganizationMigrationSelectorImpl(child)));
    }
}
