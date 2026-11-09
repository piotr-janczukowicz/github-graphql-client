package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.StatusCheckConfigurationSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code StatusCheckConfiguration}; used by the generated selection code only. */
final class StatusCheckConfigurationSelectorImpl implements StatusCheckConfigurationSelector {

    private final Cursor cursor;

    StatusCheckConfigurationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String context() {
        return cursor.getRequired("context", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer integrationId() {
        return cursor.get("integrationId", ScalarType.INT);
    }
}
