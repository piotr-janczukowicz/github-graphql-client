package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeployKeySelector;
import java.time.Instant;

/** Reads and records the fields of {@code DeployKey}; used by the generated selection code only. */
final class DeployKeySelectorImpl implements DeployKeySelector {

    private final Cursor cursor;

    DeployKeySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public boolean enabled() {
        return cursor.getRequired("enabled", ScalarType.BOOLEAN);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String key() {
        return cursor.getRequired("key", ScalarType.STRING);
    }

    @Override
    public boolean readOnly() {
        return cursor.getRequired("readOnly", ScalarType.BOOLEAN);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }

    @Override
    public boolean verified() {
        return cursor.getRequired("verified", ScalarType.BOOLEAN);
    }
}
