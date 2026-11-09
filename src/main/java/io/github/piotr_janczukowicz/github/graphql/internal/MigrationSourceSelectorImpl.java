package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MigrationSourceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MigrationSourceType;

/** Reads and records the fields of {@code MigrationSource}; used by the generated selection code only. */
final class MigrationSourceSelectorImpl implements MigrationSourceSelector {

    private final Cursor cursor;

    MigrationSourceSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public MigrationSourceType type() {
        return cursor.getRequired(
                "type", ScalarType.enumeration(MigrationSourceType::fromWire, MigrationSourceType.AZURE_DEVOPS));
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
