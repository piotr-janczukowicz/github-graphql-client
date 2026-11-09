package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateMigrationSourcePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MigrationSourceSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateMigrationSourcePayload}; used by the generated selection code only. */
final class CreateMigrationSourcePayloadSelectorImpl implements CreateMigrationSourcePayloadSelector {

    private final Cursor cursor;

    CreateMigrationSourcePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R migrationSource(final Function<MigrationSourceSelector, R> selection) {
        return cursor.object("migrationSource", child -> selection.apply(new MigrationSourceSelectorImpl(child)));
    }
}
